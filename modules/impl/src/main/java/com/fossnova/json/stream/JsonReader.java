/*
 * Copyright (c) 2012, FOSS Nova Software foundation (FNSF),
 * and individual contributors as indicated by the @author tags.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.fossnova.json.stream;

import static com.fossnova.json.stream.JsonConstants.ARRAY_END;
import static com.fossnova.json.stream.JsonConstants.ARRAY_START;
import static com.fossnova.json.stream.JsonConstants.BACKSLASH;
import static com.fossnova.json.stream.JsonConstants.BACKSPACE;
import static com.fossnova.json.stream.JsonConstants.CR;
import static com.fossnova.json.stream.JsonConstants.COLON;
import static com.fossnova.json.stream.JsonConstants.COMMA;
import static com.fossnova.json.stream.JsonConstants.FORMFEED;
import static com.fossnova.json.stream.JsonConstants.QUOTE;
import static com.fossnova.json.stream.JsonConstants.MINUS;
import static com.fossnova.json.stream.JsonConstants.NL;
import static com.fossnova.json.stream.JsonConstants.OBJECT_END;
import static com.fossnova.json.stream.JsonConstants.OBJECT_START;
import static com.fossnova.json.stream.JsonConstants.SOLIDUS;
import static com.fossnova.json.stream.JsonConstants.TAB;
import static com.fossnova.json.stream.Utils.isControl;
import static com.fossnova.json.stream.Utils.isNumberChar;
import static com.fossnova.json.stream.Utils.isNumberString;
import static com.fossnova.json.stream.Utils.isWhitespace;
import static com.fossnova.json.stream.Utils.toUnicodeString;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.fossnova.json.stream.JsonEvent;
import org.fossnova.json.stream.JsonException;

/**
 * @author <a href="mailto:opalka dot richard at gmail dot com">Richard Opalka</a>
 */
public final class JsonReader implements org.fossnova.json.stream.JsonReader {

    private static final char[] NULL = JsonConstants.NULL.toCharArray();
    private static final char[] TRUE = JsonConstants.TRUE.toCharArray();
    private static final char[] FALSE = JsonConstants.FALSE.toCharArray();
    private final Reader in;
    private final JsonGrammarAnalyzer analyzer;
    private char[] buffer = new char[ 1024 ];
    private int position;
    private int limit;
    private int numberOffset;
    private int numberLength;
    private int stringOffset;
    private int stringLength;
    private boolean jsonBoolean;
    private boolean closed;

    JsonReader( final Reader in ) {
        this.in = in;
        analyzer = new JsonGrammarAnalyzer();
    }

    @Override
    public void close() {
        closed = true;
    }

    @Override
    public boolean getBoolean() {
        if ( !isCurrentEvent( JsonEvent.BOOLEAN ) ) {
            throw new IllegalStateException( "Current event isn't boolean" );
        }
        return jsonBoolean;
    }

    public String getNumber() {
        if ( !isCurrentEvent( JsonEvent.NUMBER ) ) {
            throw new IllegalStateException( "Current event isn't number" );
        }
        return new String( buffer, numberOffset, numberLength );
    }

    @Override
    public String getString() {
        if ( !isCurrentEvent( JsonEvent.STRING ) ) {
            throw new IllegalStateException( "Current event isn't string" );
        }
        return new String( buffer, stringOffset, stringLength );
    }

    @Override
    public byte getByte() {
        return Byte.parseByte( getNumber() );
    }

    @Override
    public short getShort() {
        return Short.parseShort( getNumber() );
    }

    @Override
    public int getInt() {
        return Integer.parseInt( getNumber() );
    }

    @Override
    public long getLong() {
        return Long.parseLong( getNumber() );
    }

    @Override
    public BigInteger getBigInteger() {
        return new BigInteger( getNumber() );
    }

    @Override
    public BigDecimal getBigDecimal() {
        return new BigDecimal( getNumber() );
    }

    @Override
    public float getFloat() {
        return Float.parseFloat( getNumber() );
    }

    @Override
    public double getDouble() {
        return Double.parseDouble( getNumber() );
    }

    @Override
    public boolean isArrayEnd() {
        return isCurrentEvent( JsonEvent.ARRAY_END );
    }

    @Override
    public boolean isArrayStart() {
        return isCurrentEvent( JsonEvent.ARRAY_START );
    }

    @Override
    public boolean isNumber() {
        return isCurrentEvent( JsonEvent.NUMBER );
    }

    @Override
    public boolean isObjectEnd() {
        return isCurrentEvent( JsonEvent.OBJECT_END );
    }

    @Override
    public boolean isObjectStart() {
        return isCurrentEvent( JsonEvent.OBJECT_START );
    }

    @Override
    public boolean isString() {
        return isCurrentEvent( JsonEvent.STRING );
    }

    @Override
    public boolean isNull() {
        return isCurrentEvent( JsonEvent.NULL );
    }

    @Override
    public boolean isBoolean() {
        return isCurrentEvent( JsonEvent.BOOLEAN );
    }

    private boolean isCurrentEvent( final JsonEvent event ) {
        ensureOpen();
        return analyzer.currentEvent == event;
    }

    @Override
    public boolean hasNext() throws IOException, JsonException {
        ensureOpen();
        return !analyzer.finished;
    }

    @Override
    public JsonEvent next() throws IOException, JsonException {
        ensureOpen();
        if ( analyzer.finished ) {
            throw new IllegalStateException( "No more JSON tokens available" );
        }
        int currentChar;
        while ( true ) {
            currentChar = position < limit ? buffer[ position++ ] : read();
            switch ( currentChar ) {
                case QUOTE: {
                    analyzer.push( JsonGrammarAnalyzer.STRING );
                    readString();
                    return analyzer.currentEvent;
                }
                case COLON: {
                    analyzer.push( JsonGrammarAnalyzer.COLON );
                }
                    break;
                case COMMA: {
                    analyzer.push( JsonGrammarAnalyzer.COMMA );
                }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case MINUS: {
                    analyzer.push( JsonGrammarAnalyzer.NUMBER );
                    position--;
                    readNumber();
                    return analyzer.currentEvent;
                }
                case 'f':
                case 't': {
                    analyzer.push( JsonGrammarAnalyzer.BOOLEAN );
                    jsonBoolean = currentChar == 't';
                    readString( jsonBoolean ? TRUE : FALSE );
                    return analyzer.currentEvent;
                }
                case 'n': {
                    analyzer.push( JsonGrammarAnalyzer.NULL );
                    readString( NULL );
                    return analyzer.currentEvent;
                }
                case OBJECT_START: {
                    analyzer.push( JsonGrammarAnalyzer.OBJECT_START );
                    return analyzer.currentEvent;
                }
                case ARRAY_START: {
                    analyzer.push( JsonGrammarAnalyzer.ARRAY_START );
                    return analyzer.currentEvent;
                }
                case OBJECT_END: {
                    analyzer.push( JsonGrammarAnalyzer.OBJECT_END );
                    return analyzer.currentEvent;
                }
                case ARRAY_END: {
                    analyzer.push( JsonGrammarAnalyzer.ARRAY_END );
                    return analyzer.currentEvent;
                }
                default: {
                    if ( isWhitespace( currentChar ) ) {
                        continue;
                    }
                    if ( currentChar >= 0 ) {
                        throw newJsonException( "Unexpected character '" + toUnicodeString( currentChar ) + "' while reading JSON stream" );
                    } else {
                        throw newJsonException( "Unexpected EOF while reading JSON stream" );
                    }
                }
            }
        }
    }

    private void ensureData() throws IOException {
        if ( position == limit ) {
            if ( limit == buffer.length ) {
                limit = 0;
                position = 0;
            }
            fillBuffer();
        }
    }

    private void fillBuffer() throws IOException {
        int read;
        do {
            read = in.read( buffer, limit, buffer.length - limit );
            if ( read == -1 ) return;
            limit += read;
        } while ( limit != buffer.length );
    }

    private int read() throws IOException {
        ensureData();
        return position < limit ? buffer[ position++ ] : -1;
    }

    private void readString() throws IOException, JsonException {
        boolean escaped = false;
        char currentChar;
        stringLength = 0;
        boolean copy = false;
        while ( true ) {
            if ( stringLength == 0 ) stringOffset = position;
            while ( position != limit ) {
                currentChar = buffer[ position++ ];
                if ( escaped ) {
                    copy = true;
                    if ( currentChar == 'b' ) {
                        buffer[ stringOffset + stringLength++ ] = BACKSPACE;
                    } else if ( currentChar == 'f' ) {
                        buffer[ stringOffset + stringLength++ ] = FORMFEED;
                    } else if ( currentChar == 'n' ) {
                        buffer[ stringOffset + stringLength++ ] = NL;
                    } else if ( currentChar == 'r' ) {
                        buffer[ stringOffset + stringLength++ ] = CR;
                    } else if ( currentChar == 't' ) {
                        buffer[ stringOffset + stringLength++ ] = TAB;
                    } else if ( currentChar == QUOTE ) {
                        buffer[ stringOffset + stringLength++ ] = QUOTE;
                    } else if ( currentChar == SOLIDUS ) {
                        buffer[ stringOffset + stringLength++ ] = SOLIDUS;
                    } else if ( currentChar == BACKSLASH ) {
                        buffer[ stringOffset + stringLength++ ] = BACKSLASH;
                    } else if ( currentChar == 'u' ) {
                        if ( limit - position >= 4 ) {
                            try {
                                buffer[ stringOffset + stringLength++ ] = ( char ) Integer.parseInt( new String( buffer, position, 4 ), 16 );
                            } catch ( final NumberFormatException e ) {
                                throw newJsonException( "Invalid JSON unicode sequence. Expecting 4 hexadecimal digits but got '" + new String( buffer, position, 4 ) + "'" );
                            }
                            position += 4;
                        } else {
                            if ( stringOffset != 0 ) {
                                if ( stringLength > 0 ) System.arraycopy( buffer, stringOffset, buffer, 0, stringLength );
                                position = stringLength;
                                limit = stringLength;
                                stringOffset = 0;
                            }
                            while ( limit + 4 > buffer.length ) doubleBuffer();
                            fillBuffer();
                            if ( limit - position < 4 ) {
                                throw newJsonException( "Unexpected EOF while reading JSON string" );
                            }
                            try {
                                buffer[ stringOffset + stringLength++ ] = ( char ) Integer.parseInt( new String( buffer, position, 4 ), 16 );
                            } catch ( final NumberFormatException e ) {
                                throw newJsonException( "Invalid JSON unicode sequence. Expecting 4 hexadecimal digits but got '" + new String( buffer, position, 4 ) + "'" );
                            }
                            position += 4;
                        }
                    } else {
                        throw newJsonException( "Unexpected character '" + toUnicodeString( currentChar ) + "' after escape character while reading JSON string" );
                    }
                    escaped = false;
                } else {
                    if ( currentChar == QUOTE ) return;
                    if ( currentChar == BACKSLASH ) {
                        escaped = true;
                        continue;
                    }
                    if ( isControl( currentChar ) ) {
                        throw newJsonException( "Unexpected control character '" + toUnicodeString( currentChar ) + "' while reading JSON string" );
                    }
                    if ( copy ) {
                        buffer[ stringOffset + stringLength ] = currentChar;
                    }
                    stringLength++;
                }
            }
            if ( stringOffset != 0 && stringLength > 0 ) {
                System.arraycopy( buffer, stringOffset, buffer, 0, stringLength );
                position = stringLength;
                limit = stringLength;
                stringOffset = 0;
            } else if ( stringOffset == 0 && limit == buffer.length ) doubleBuffer();
            ensureData();
            if ( position == limit ) {
                throw newJsonException( "Unexpected EOF while reading JSON string" );
            }
        }
    }

    private void readString( final char[] expected ) throws IOException, JsonException {
        int i = 1;
        if ( position < limit - expected.length + 1 ) {
            // fast path
            for ( ; i < expected.length; i++ ) {
                if ( buffer[ position++ ] != expected[ i ] ) {
                    throw newJsonException( "Unexpected character '" + toUnicodeString( buffer[ --position ] )
                            + "' while reading JSON " + new String( expected ) + " token" );
                }
            }
        } else {
            // slow path
            while ( true ) {
                while ( position < limit && i != expected.length ) {
                    if ( buffer[ position++ ] != expected[ i++ ] ) {
                        throw newJsonException( "Unexpected character '" + toUnicodeString( buffer[ position - 1 ] )
                                + "' while reading JSON " + new String( expected ) + " token" );
                    }
                }
                if ( i == expected.length ) return;
                ensureData();
                if ( position == limit ) {
                    throw newJsonException( "Unexpected EOF while reading JSON " + new String( expected ) + " token" );
                }
            }
        }
    }

    private void readNumber() throws IOException, JsonException {
        numberOffset = position;
        while ( true ) {
            while ( position < limit ) {
                if ( isNumberChar( buffer[ position++ ] ) ) continue;
                position--;
                break;
            }
            numberLength = position - numberOffset;
            if ( position < limit ) break;
            if ( numberOffset != 0 ) {
                System.arraycopy( buffer, numberOffset, buffer, 0, numberLength );
                position = numberLength;
                limit = numberLength;
                numberOffset = 0;
            } else if ( limit == buffer.length ) doubleBuffer();
            ensureData();
            if ( position == limit ) {
                throw newJsonException( "Unexpected EOF while reading JSON number" );
            }
        }
        if ( !isNumberString( buffer, numberOffset, numberLength ) ) {
            throw newJsonException( "Incorrect JSON number: '" + getNumber() + "'" );
        }
    }

    private void doubleBuffer() {
        final char[] oldData = buffer;
        buffer = new char[ oldData.length * 2 ];
        System.arraycopy( oldData, 0, buffer, 0, oldData.length );
    }

    private JsonException newJsonException( final String message ) {
        analyzer.finished = true;
        return new JsonException( message );
    }

    private void ensureOpen() {
        if ( closed ) {
            throw new IllegalStateException( "JSON reader have been closed" );
        }
    }
}

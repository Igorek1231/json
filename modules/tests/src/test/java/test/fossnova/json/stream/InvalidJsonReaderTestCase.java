/*
 * Copyright (c) 2012-2017, FOSS Nova Software foundation (FNSF),
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
package test.fossnova.json.stream;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.fossnova.json.stream.JsonException;
import org.fossnova.json.stream.JsonReader;
import org.junit.Test;

/**
 * @author <a href="mailto:opalka.richard@gmail.com">Richard Opalka</a>
 */
public final class InvalidJsonReaderTestCase extends AbstractJsonStreamsTestCase {

    @Test
    public void noData() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "" );
        assertJsonException( reader, "Unexpected EOF while reading JSON stream" );
        reader.close();
    }

    @Test
    public void emptyState() throws IOException, JsonException {
        read_colon();
        read_comma();
        read_objectEnd();
        read_arrayEnd();
    }

    @Test
    public void emptyObjectStartState() throws IOException, JsonException {
        read_objectStart_arrayEnd();
        read_objectStart_colon();
        read_objectStart_comma();
        read_objectStart_number();
        read_objectStart_false();
        read_objectStart_true();
        read_objectStart_null();
    }

    @Test
    public void emptyArrayStartState() throws IOException, JsonException {
        read_arrayStart_objectEnd();
        read_arrayStart_colon();
        read_arrayStart_comma();
    }

    @Test
    public void notEmptyArrayStartState() throws IOException, JsonException {
        read_arrayStart_arrayStart_arrayEnd_objectEnd();
        read_arrayStart_objectStart_objectEnd_objectEnd();
        read_arrayStart_string_objectEnd();
        read_arrayStart_number_objectEnd();
        read_arrayStart_false_objectEnd();
        read_arrayStart_true_objectEnd();
        read_arrayStart_null_objectEnd();
        read_arrayStart_arrayStart_arrayEnd_objectStart();
        read_arrayStart_objectStart_objectEnd_objectStart();
        read_arrayStart_string_objectStart();
        read_arrayStart_number_objectStart();
        read_arrayStart_false_objectStart();
        read_arrayStart_true_objectStart();
        read_arrayStart_null_objectStart();
        read_arrayStart_arrayStart_arrayEnd_arrayStart();
        read_arrayStart_objectStart_objectEnd_arrayStart();
        read_arrayStart_string_arrayStart();
        read_arrayStart_number_arrayStart();
        read_arrayStart_false_arrayStart();
        read_arrayStart_true_arrayStart();
        read_arrayStart_null_arrayStart();
        read_arrayStart_arrayStart_arrayEnd_string();
        read_arrayStart_objectStart_objectEnd_string();
        read_arrayStart_string_string();
        read_arrayStart_number_string();
        read_arrayStart_false_string();
        read_arrayStart_true_string();
        read_arrayStart_null_string();
        read_arrayStart_arrayStart_arrayEnd_number();
        read_arrayStart_objectStart_objectEnd_number();
        read_arrayStart_string_number();
        read_arrayStart_false_number();
        read_arrayStart_true_number();
        read_arrayStart_null_number();
        read_arrayStart_arrayStart_arrayEnd_true();
        read_arrayStart_objectStart_objectEnd_true();
        read_arrayStart_string_true();
        read_arrayStart_number_true();
        read_arrayStart_true_true();
        read_arrayStart_false_true();
        read_arrayStart_null_true();
        read_arrayStart_arrayStart_arrayEnd_false();
        read_arrayStart_objectStart_objectEnd_false();
        read_arrayStart_string_false();
        read_arrayStart_number_false();
        read_arrayStart_true_false();
        read_arrayStart_false_false();
        read_arrayStart_null_false();
        read_arrayStart_arrayStart_arrayEnd_null();
        read_arrayStart_objectStart_objectEnd_null();
        read_arrayStart_string_null();
        read_arrayStart_number_null();
        read_arrayStart_true_null();
        read_arrayStart_false_null();
        read_arrayStart_null_null();
        read_arrayStart_arrayStart_arrayEnd_colon();
        read_arrayStart_objectStart_objectEnd_colon();
        read_arrayStart_string_colon();
        read_arrayStart_number_colon();
        read_arrayStart_false_colon();
        read_arrayStart_true_colon();
        read_arrayStart_null_colon();
        read_arrayStart_arrayStart_arrayEnd_comma_arrayEnd();
        read_arrayStart_objectStart_objectEnd_comma_arrayEnd();
        read_arrayStart_string_comma_arrayEnd();
        read_arrayStart_number_comma_arrayEnd();
        read_arrayStart_false_comma_arrayEnd();
        read_arrayStart_true_comma_arrayEnd();
        read_arrayStart_null_comma_arrayEnd();
        read_arrayStart_arrayStart_arrayEnd_comma_objectEnd();
        read_arrayStart_objectStart_objectEnd_comma_objectEnd();
        read_arrayStart_string_comma_objectEnd();
        read_arrayStart_number_comma_objectEnd();
        read_arrayStart_false_comma_objectEnd();
        read_arrayStart_true_comma_objectEnd();
        read_arrayStart_null_comma_objectEnd();
        read_arrayStart_arrayStart_arrayEnd_comma_comma();
        read_arrayStart_objectStart_objectEnd_comma_comma();
        read_arrayStart_string_comma_comma();
        read_arrayStart_number_comma_comma();
        read_arrayStart_false_comma_comma();
        read_arrayStart_true_comma_comma();
        read_arrayStart_null_comma_comma();
        read_arrayStart_arrayStart_arrayEnd_comma_colon();
        read_arrayStart_objectStart_objectEnd_comma_colon();
        read_arrayStart_string_comma_colon();
        read_arrayStart_number_comma_colon();
        read_arrayStart_false_comma_colon();
        read_arrayStart_true_comma_colon();
        read_arrayStart_null_comma_colon();
    }

    @Test
    public void notEmptyObjectStartState() throws IOException, JsonException {
        read_objectStart_string_arrayEnd();
        read_objectStart_string_arrayStart();
        read_objectStart_string_objectEnd();
        read_objectStart_string_objectStart();
        read_objectStart_string_comma();
        read_objectStart_string_string();
        read_objectStart_string_number();
        read_objectStart_string_false();
        read_objectStart_string_true();
        read_objectStart_string_null();
        read_objectStart_string_colon_arrayEnd();
        read_objectStart_string_colon_objectEnd();
        read_objectStart_string_colon_colon();
        read_objectStart_string_colon_comma();
        read_objectStart_string_colon_string_arrayEnd();
        read_objectStart_string_colon_string_arrayStart();
        read_objectStart_string_colon_string_objectStart();
        read_objectStart_string_colon_string_colon();
        read_objectStart_string_colon_string_string();
        read_objectStart_string_colon_string_number();
        read_objectStart_string_colon_string_false();
        read_objectStart_string_colon_string_true();
        read_objectStart_string_colon_string_null();
        read_objectStart_string_colon_string_comma_arrayEnd();
        read_objectStart_string_colon_string_comma_arrayStart();
        read_objectStart_string_colon_string_comma_objectEnd();
        read_objectStart_string_colon_string_comma_objectStart();
        read_objectStart_string_colon_string_comma_colon();
        read_objectStart_string_colon_string_comma_number();
        read_objectStart_string_colon_string_comma_false();
        read_objectStart_string_colon_string_comma_true();
        read_objectStart_string_colon_string_comma_null();
        read_objectStart_string_colon_string_comma_comma();
        read_objectStart_string_colon_string_comma_string_arrayEnd();
        read_objectStart_string_colon_string_comma_string_arrayStart();
        read_objectStart_string_colon_string_comma_string_objectEnd();
        read_objectStart_string_colon_string_comma_string_objectStart();
        read_objectStart_string_colon_string_comma_string_comma();
        read_objectStart_string_colon_string_comma_string_string();
        read_objectStart_string_colon_string_comma_string_number();
        read_objectStart_string_colon_string_comma_string_false();
        read_objectStart_string_colon_string_comma_string_true();
        read_objectStart_string_colon_string_comma_string_null();
        read_objectStart_string_colon_number_arrayEnd();
        read_objectStart_string_colon_number_arrayStart();
        read_objectStart_string_colon_number_objectStart();
        read_objectStart_string_colon_number_colon();
        read_objectStart_string_colon_number_string();
        read_objectStart_string_colon_number_false();
        read_objectStart_string_colon_number_true();
        read_objectStart_string_colon_number_null();
        read_objectStart_string_colon_number_comma_arrayEnd();
        read_objectStart_string_colon_number_comma_arrayStart();
        read_objectStart_string_colon_number_comma_objectEnd();
        read_objectStart_string_colon_number_comma_objectStart();
        read_objectStart_string_colon_number_comma_colon();
        read_objectStart_string_colon_number_comma_number();
        read_objectStart_string_colon_number_comma_false();
        read_objectStart_string_colon_number_comma_true();
        read_objectStart_string_colon_number_comma_null();
        read_objectStart_string_colon_number_comma_comma();
        read_objectStart_string_colon_number_comma_string_arrayEnd();
        read_objectStart_string_colon_number_comma_string_arrayStart();
        read_objectStart_string_colon_number_comma_string_objectEnd();
        read_objectStart_string_colon_number_comma_string_objectStart();
        read_objectStart_string_colon_number_comma_string_comma();
        read_objectStart_string_colon_number_comma_string_string();
        read_objectStart_string_colon_number_comma_string_number();
        read_objectStart_string_colon_number_comma_string_false();
        read_objectStart_string_colon_number_comma_string_true();
        read_objectStart_string_colon_number_comma_string_null();
        read_objectStart_string_colon_false_arrayEnd();
        read_objectStart_string_colon_false_arrayStart();
        read_objectStart_string_colon_false_objectStart();
        read_objectStart_string_colon_false_colon();
        read_objectStart_string_colon_false_string();
        read_objectStart_string_colon_false_number();
        read_objectStart_string_colon_false_false();
        read_objectStart_string_colon_false_true();
        read_objectStart_string_colon_false_null();
        read_objectStart_string_colon_false_comma_arrayEnd();
        read_objectStart_string_colon_false_comma_arrayStart();
        read_objectStart_string_colon_false_comma_objectEnd();
        read_objectStart_string_colon_false_comma_objectStart();
        read_objectStart_string_colon_false_comma_colon();
        read_objectStart_string_colon_false_comma_number();
        read_objectStart_string_colon_false_comma_false();
        read_objectStart_string_colon_false_comma_true();
        read_objectStart_string_colon_false_comma_null();
        read_objectStart_string_colon_false_comma_comma();
        read_objectStart_string_colon_false_comma_string_arrayEnd();
        read_objectStart_string_colon_false_comma_string_arrayStart();
        read_objectStart_string_colon_false_comma_string_objectEnd();
        read_objectStart_string_colon_false_comma_string_objectStart();
        read_objectStart_string_colon_false_comma_string_comma();
        read_objectStart_string_colon_false_comma_string_string();
        read_objectStart_string_colon_false_comma_string_number();
        read_objectStart_string_colon_false_comma_string_false();
        read_objectStart_string_colon_false_comma_string_true();
        read_objectStart_string_colon_false_comma_string_null();
        read_objectStart_string_colon_true_arrayEnd();
        read_objectStart_string_colon_true_arrayStart();
        read_objectStart_string_colon_true_objectStart();
        read_objectStart_string_colon_true_colon();
        read_objectStart_string_colon_true_string();
        read_objectStart_string_colon_true_number();
        read_objectStart_string_colon_true_false();
        read_objectStart_string_colon_true_true();
        read_objectStart_string_colon_true_null();
        read_objectStart_string_colon_true_comma_arrayEnd();
        read_objectStart_string_colon_true_comma_arrayStart();
        read_objectStart_string_colon_true_comma_objectEnd();
        read_objectStart_string_colon_true_comma_objectStart();
        read_objectStart_string_colon_true_comma_colon();
        read_objectStart_string_colon_true_comma_number();
        read_objectStart_string_colon_true_comma_false();
        read_objectStart_string_colon_true_comma_true();
        read_objectStart_string_colon_true_comma_null();
        read_objectStart_string_colon_true_comma_comma();
        read_objectStart_string_colon_true_comma_string_arrayEnd();
        read_objectStart_string_colon_true_comma_string_arrayStart();
        read_objectStart_string_colon_true_comma_string_objectEnd();
        read_objectStart_string_colon_true_comma_string_objectStart();
        read_objectStart_string_colon_true_comma_string_comma();
        read_objectStart_string_colon_true_comma_string_string();
        read_objectStart_string_colon_true_comma_string_number();
        read_objectStart_string_colon_true_comma_string_false();
        read_objectStart_string_colon_true_comma_string_true();
        read_objectStart_string_colon_true_comma_string_null();
        read_objectStart_string_colon_null_arrayEnd();
        read_objectStart_string_colon_null_arrayStart();
        read_objectStart_string_colon_null_objectStart();
        read_objectStart_string_colon_null_colon();
        read_objectStart_string_colon_null_string();
        read_objectStart_string_colon_null_number();
        read_objectStart_string_colon_null_false();
        read_objectStart_string_colon_null_true();
        read_objectStart_string_colon_null_null();
        read_objectStart_string_colon_null_comma_arrayEnd();
        read_objectStart_string_colon_null_comma_arrayStart();
        read_objectStart_string_colon_null_comma_objectEnd();
        read_objectStart_string_colon_null_comma_objectStart();
        read_objectStart_string_colon_null_comma_colon();
        read_objectStart_string_colon_null_comma_number();
        read_objectStart_string_colon_null_comma_false();
        read_objectStart_string_colon_null_comma_true();
        read_objectStart_string_colon_null_comma_null();
        read_objectStart_string_colon_null_comma_comma();
        read_objectStart_string_colon_null_comma_string_arrayEnd();
        read_objectStart_string_colon_null_comma_string_arrayStart();
        read_objectStart_string_colon_null_comma_string_objectEnd();
        read_objectStart_string_colon_null_comma_string_objectStart();
        read_objectStart_string_colon_null_comma_string_comma();
        read_objectStart_string_colon_null_comma_string_string();
        read_objectStart_string_colon_null_comma_string_number();
        read_objectStart_string_colon_null_comma_string_false();
        read_objectStart_string_colon_null_comma_string_true();
        read_objectStart_string_colon_null_comma_string_null();
        read_objectStart_string_colon_arrayStart_arrayEnd_arrayEnd();
        read_objectStart_string_colon_arrayStart_arrayEnd_arrayStart();
        read_objectStart_string_colon_arrayStart_arrayEnd_objectStart();
        read_objectStart_string_colon_arrayStart_arrayEnd_colon();
        read_objectStart_string_colon_arrayStart_arrayEnd_string();
        read_objectStart_string_colon_arrayStart_arrayEnd_number();
        read_objectStart_string_colon_arrayStart_arrayEnd_false();
        read_objectStart_string_colon_arrayStart_arrayEnd_true();
        read_objectStart_string_colon_arrayStart_arrayEnd_null();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_arrayEnd();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_arrayStart();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_objectEnd();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_objectStart();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_colon();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_number();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_false();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_true();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_null();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_comma();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_arrayEnd();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_arrayStart();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_objectEnd();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_objectStart();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_comma();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_string();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_number();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_false();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_true();
        read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_null();
        read_objectStart_string_colon_objectStart_objectEnd_arrayEnd();
        read_objectStart_string_colon_objectStart_objectEnd_arrayStart();
        read_objectStart_string_colon_objectStart_objectEnd_objectStart();
        read_objectStart_string_colon_objectStart_objectEnd_colon();
        read_objectStart_string_colon_objectStart_objectEnd_string();
        read_objectStart_string_colon_objectStart_objectEnd_number();
        read_objectStart_string_colon_objectStart_objectEnd_false();
        read_objectStart_string_colon_objectStart_objectEnd_true();
        read_objectStart_string_colon_objectStart_objectEnd_null();
        read_objectStart_string_colon_objectStart_objectEnd_comma_arrayEnd();
        read_objectStart_string_colon_objectStart_objectEnd_comma_arrayStart();
        read_objectStart_string_colon_objectStart_objectEnd_comma_objectEnd();
        read_objectStart_string_colon_objectStart_objectEnd_comma_objectStart();
        read_objectStart_string_colon_objectStart_objectEnd_comma_colon();
        read_objectStart_string_colon_objectStart_objectEnd_comma_number();
        read_objectStart_string_colon_objectStart_objectEnd_comma_false();
        read_objectStart_string_colon_objectStart_objectEnd_comma_true();
        read_objectStart_string_colon_objectStart_objectEnd_comma_null();
        read_objectStart_string_colon_objectStart_objectEnd_comma_comma();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_arrayEnd();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_arrayStart();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_objectEnd();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_objectStart();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_comma();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_string();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_number();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_false();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_true();
        read_objectStart_string_colon_objectStart_objectEnd_comma_string_null();
    }

    @Test
    public void uniqueObjectKeys() throws IOException, JsonException {
        read_objectStart_string_null_string();
        read_objectStart_string_objectStart_string_null_objectEnd_string();
    }

    @Test
    public void unexpectedEOF() throws IOException, JsonException {
        read_arrayStart_string_EOF();
        read_arrayStart_number_EOF();
        read_arrayStart_true_EOF();
        read_arrayStart_false_EOF();
        read_arrayStart_null_EOF();
        read_arrayStart_EOF();
        read_objectStart_EOF();
        read_arrayStart_stringwithescapedunicode_EOF();
    }

    @Test
    public void illegalCharacter() throws IOException, JsonException {
        read_arrayStart_string_illegalChar();
        read_arrayStart_string_illegal_escape();
        read_arrayStart_string_illegal_unicode_escape();
        read_arrayStart_true_illegalChar();
        read_arrayStart_false_illegalChar();
        read_arrayStart_null_illegalChar();
        read_arrayStart_illegalChar();
        read_objectStart_illegalChar();
    }

    @Test
    public void invalidNumbers() throws IOException, JsonException {
        read_arrayStart_wrongByte();
        read_arrayStart_wrongShort();
        read_arrayStart_wrongInt();
        read_arrayStart_wrongLong();
        read_arrayStart_wrongBigInteger();
        read_arrayStart_wrongBigDecimal();
        read_arrayStart_wrongFloat();
        read_arrayStart_wrongFloat_twice_minus();
        read_arrayStart_wrongFloat_minus_followed_with_plus();
        read_arrayStart_wrongFloat_plus_followed_with_minus();
        read_arrayStart_wrongFloat_plus_ends_number();
        read_arrayStart_wrongFloat_minus_ends_number();
        read_arrayStart_wrongFloat_e_without_digits();
        read_arrayStart_wrongFloat_E_without_digits();
        read_arrayStart_wrongFloat_dot_followed_with_e();
        read_arrayStart_wrongFloat_dot_followed_with_E();
        read_arrayStart_wrongFloat_number_starts_with_0_dot();
        read_arrayStart_wrongFloat_number_starts_with_0_e();
        read_arrayStart_wrongFloat_number_starts_with_0_E();
        read_arrayStart_wrongFloat_number_starts_with_0();
        read_arrayStart_wrongFloat_negative_number_starts_with_0();
        read_arrayStart_wrongFloat_number_ends_with_dot();
        read_arrayStart_wrongFloat_twice_plus();
        read_arrayStart_wrongDouble();
    }

    private void read_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( ":" );
        assertJsonException( reader, "Expecting { [" );
    }

    private void read_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "," );
        assertJsonException( reader, "Expecting { [" );
    }

    private void read_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "}" );
        assertJsonException( reader, "Expecting { [" );
    }

    private void read_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "]" );
        assertJsonException( reader, "Expecting { [" );
    }

    private void read_objectStart_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{]" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{:" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{," );
        assertObjectStartState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{1" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{false" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{true" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{null" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_arrayStart_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[}" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Expecting ] { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[:" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Expecting ] { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[," );
        assertArrayStartState( reader );
        assertJsonException( reader, "Expecting ] { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]}" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}}" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"}" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0}" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true}" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false}" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null}" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[][" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}[" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"[" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0[" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false}" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true[" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null[" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]{" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}{" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"{" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0{" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false{" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true{" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null{" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]\"\"" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}\"\"" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"\"\"" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0\"\"" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false\"\"" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true\"\"" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null\"\"" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]0" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}0" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"0" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false0" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true0" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null0" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]true" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}true" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"true" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0true" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[truetrue" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[falsetrue" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[nulltrue" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]false" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}false" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"false" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0false" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[truefalse" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[falsefalse" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[nullfalse" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]null" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}null" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\"null" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0null" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[truenull" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[falsenull" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[nullnull" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[]:" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_objectStart_objectEnd_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{}:" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_string_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\":" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_number_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0:" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_false_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false:" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_true_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true:" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_null_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null:" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , ]" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[],]" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_objectStart_objectEnd_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{},]" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_string_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\",]" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_number_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0,]" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_false_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false,]" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_true_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true,]" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_null_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null,]" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[],}" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_objectStart_objectEnd_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{},}" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_string_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\",}" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_number_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0,}" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_false_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false,}" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_true_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true,}" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_null_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null,}" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[],," );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_objectStart_objectEnd_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{},," );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_string_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\",," );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_number_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0,," );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_false_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false,," );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_true_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true,," );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_null_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null,," );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_arrayStart_arrayEnd_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[[],:" );
        assertArrayStartState( reader );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_objectStart_objectEnd_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[{},:" );
        assertArrayStartState( reader );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_string_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\",:" );
        assertArrayStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_number_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0,:" );
        assertArrayStartState( reader );
        assertDoubleState( reader, 1.0 );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_false_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[false,:" );
        assertArrayStartState( reader );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_true_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[true,:" );
        assertArrayStartState( reader );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_arrayStart_null_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[null,:" );
        assertArrayStartState( reader );
        assertNullState( reader );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_objectStart_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_objectStart_string_colon_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_objectStart_string_colon_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\"::" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_objectStart_string_colon_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting { [ STRING NUMBER true false null" );
    }

    private void read_objectStart_string_colon_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\":" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-3.14E-11]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertDoubleState( reader, -3.14E-11 );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-3.14E-11[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertDoubleState( reader, -3.14E-11 );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-3.14{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertDoubleState( reader, -3.14 );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":0:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertIntState( reader, 0 );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-3.14\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertFloatState( reader, -3.14F );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-5false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertLongState( reader, -5L );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-1.0true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertDoubleState( reader, -1.0F );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_number_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false-1e+1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":falsefalse" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":falsetrue" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_false_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":falsenull" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true-1e+1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":truefalse" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":truetrue" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_true_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":truenull" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null-1e+1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":nullfalse" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":nulltrue" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_null_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":nullnull" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[][" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]-1e+1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[]null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}\"\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}-1e+1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{}null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting , }" );
    }

    private void read_objectStart_string_colon_string_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":\"\",," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertStringState( reader, "" );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":0,]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertIntState( reader, 0 );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":18,[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertLongState( reader, 18L );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":0,}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertIntState( reader, 0 );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":10,{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBigDecimalState( reader, BigDecimal.TEN );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":1,1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBigIntegerState( reader, BigInteger.ONE );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-1,true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertShortState( reader, ( short ) -1 );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":2,false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertByteState( reader, ( byte ) 2 );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-0,null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertIntState( reader, 0 );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":3.14E+5,:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertFloatState( reader, 3.14E+5F );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_number_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":-3.14E+12,," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertDoubleState( reader, -3.14E+12 );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_false_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":false,," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, false );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_true_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":true,," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertBooleanState( reader, true );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_null_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":null,," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertNullState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":[],," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},]" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},[" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},}" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},{" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},1" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},true" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},false" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},null" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_colon() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},:" );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"\":{},," );
        assertObjectStartState( reader );
        assertStringState( reader, "" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertJsonException( reader, "Expecting } STRING" );
    }

    private void read_objectStart_string_colon_string_comma_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"\"3\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_string_comma_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":\"1\",\"2\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertStringState( reader, "1" );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":-3.1415E-1,\"2\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertFloatState( reader, -3.1415E-1F );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":2.71828,\"2\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertDoubleState( reader, 2.71828 );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":-2.71828e-1,\"2\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertFloatState( reader, -2.71828e-1F );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":-2.71828e-10,\"2\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertDoubleState( reader, -2.71828e-10 );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":1,\"2\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBigIntegerState( reader, BigInteger.ONE );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":-5,\"2\"\"3\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertByteState( reader, ( byte ) -5 );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":-1e+1,\"2\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertFloatState( reader, -1e+1F );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":-0e+1,\"2\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertFloatState( reader, -0e+1F );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":2.71828,\"2\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertDoubleState( reader, 2.71828 );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_number_comma_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":0,\"2\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertLongState( reader, 0L );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"\"3\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_false_comma_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":false,\"2\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, false );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"\"3\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_true_comma_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":true,\"2\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertBooleanState( reader, true );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"\"3\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_null_comma_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":null,\"2\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertNullState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"\"3\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_arrayStart_arrayEnd_comma_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":[],\"2\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertArrayStartState( reader );
        assertArrayEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_arrayEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"]" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_arrayStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"[" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_objectEnd() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"}" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_objectStart() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"{" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_comma() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"," );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_string() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"\"3\"" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"1.0" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_false() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"false" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_true() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"true" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_objectStart_string_colon_objectStart_objectEnd_comma_string_null() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{\"0\":{},\"2\"null" );
        assertObjectStartState( reader );
        assertStringState( reader, "0" );
        assertObjectStartState( reader );
        assertObjectEndState( reader );
        assertStringState( reader, "2" );
        assertJsonException( reader, "Expecting :" );
    }

    private void read_arrayStart_string_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"0" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected EOF while reading JSON string" );
    }

    private void read_arrayStart_number_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[0" );
        assertArrayStartState( reader );
        assertIntState( reader, 0 );
        assertJsonException( reader, "Unexpected EOF while reading JSON stream" );
    }

    private void read_arrayStart_false_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[fals" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected EOF while reading JSON false token" );
    }

    private void read_arrayStart_true_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[tru" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected EOF while reading JSON true token" );
    }

    private void read_arrayStart_null_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[nul" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected EOF while reading JSON null token" );
    }

    private void read_arrayStart_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected EOF while reading JSON stream" );
    }

    private void read_objectStart_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Unexpected EOF while reading JSON stream" );
    }

    private void read_arrayStart_string_illegalChar() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"\t" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected control character '\\u0009' while reading JSON string" );
    }

    private void read_arrayStart_string_illegal_escape() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"asdf\\a" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected character '\\u0061' after escape character while reading JSON string" );
    }

    private void read_arrayStart_string_illegal_unicode_escape() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"asdf\\uy000" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Invalid JSON unicode sequence. Expecting 4 hexadecimal digits but got 'y000'" );
    }

    private void read_arrayStart_stringwithescapedunicode_EOF() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[\"asdf\\u00" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected EOF while reading JSON string" );
    }

    private void read_arrayStart_false_illegalChar() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[falsa" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected character '\\u0061' while reading JSON false token" );
    }

    private void read_arrayStart_true_illegalChar() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[trua" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected character '\\u0061' while reading JSON true token" );
    }

    private void read_arrayStart_null_illegalChar() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[nula" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected character '\\u0061' while reading JSON null token" );
    }

    private void read_arrayStart_illegalChar() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[a" );
        assertArrayStartState( reader );
        assertJsonException( reader, "Unexpected character '\\u0061' while reading JSON stream" );
    }

    private void read_objectStart_illegalChar() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "{a" );
        assertObjectStartState( reader );
        assertJsonException( reader, "Unexpected character '\\u0061' while reading JSON stream" );
    }

    private void read_arrayStart_wrongByte() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[129]" );
        assertArrayStartState( reader );
        try {
            assertByteState( reader, ( byte ) 0 );
        } catch ( final NumberFormatException ignore ) {}
    }

    private void read_arrayStart_wrongShort() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[32768]" );
        assertArrayStartState( reader );
        try {
            assertShortState( reader, ( short ) 0 );
        } catch ( final NumberFormatException ignore ) {}
    }

    private void read_arrayStart_wrongInt() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[2147483648]" );
        assertArrayStartState( reader );
        try {
            assertIntState( reader, 0 );
        } catch ( final NumberFormatException ignore ) {}
    }

    private void read_arrayStart_wrongLong() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[9223372036854775808]" );
        assertArrayStartState( reader );
        try {
            assertLongState( reader, 0L );
        } catch ( final NumberFormatException ignore ) {}
    }

    private void read_arrayStart_wrongBigInteger() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1]" );
        assertArrayStartState( reader );
        try {
            assertBigIntegerState( reader, BigInteger.ZERO );
        } catch ( final NumberFormatException ignore ) {}
    }

    private void read_arrayStart_wrongBigDecimal() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e--10]" );
        assertArrayStartState( reader );
        try {
            assertBigDecimalState( reader, BigDecimal.ZERO );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e-99999999999999999999999999999999]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final NumberFormatException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_twice_minus() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e--9]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_twice_plus() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e++9]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_minus_followed_with_plus() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e-+9]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_plus_followed_with_minus() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e+-9]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_plus_ends_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e+]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_minus_ends_number() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e-]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_e_without_digits() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0e]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_E_without_digits() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.0E]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_dot_followed_with_e() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.e1]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_dot_followed_with_E() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.E1]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_number_starts_with_0_dot() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[01.0]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_number_starts_with_0_e() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[01e0]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_number_starts_with_0_E() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[01E0]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_number_starts_with_0() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[01]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_negative_number_starts_with_0() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[-01]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongFloat_number_ends_with_dot() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.]" );
        assertArrayStartState( reader );
        try {
            assertFloatState( reader, 0.0F );
        } catch ( final JsonException ignore ) {}
    }

    private void read_arrayStart_wrongDouble() throws IOException, JsonException {
        final JsonReader reader = getJsonReader( "[1.1e-99999999999999999999999999999999]" );
        assertArrayStartState( reader );
        try {
            assertDoubleState( reader, 0.0 );
        } catch ( final NumberFormatException ignore ) {}
    }

    private void read_objectStart_string_null_string() throws IOException, JsonException {
        final String sameKey = "same key";
        final JsonReader reader = getJsonReader( "{\"" + sameKey + "\":null,\"" + sameKey + "\"" );
        assertObjectStartState( reader );
        assertStringState( reader, sameKey );
        assertNullState( reader );
        try {
            reader.next();
        } catch ( final JsonException e ) {
            assertEquals( "JSON keys have to be unique. The key '" + sameKey + "' already exists", e.getMessage() );
        }
    }

    private void read_objectStart_string_objectStart_string_null_objectEnd_string() throws IOException, JsonException {
        final String sameKey = "same key";
        final JsonReader reader = getJsonReader( "{\"" + sameKey + "\":{\"" + sameKey + "\":null},\"" + sameKey + "\"" );
        assertObjectStartState( reader );
        assertStringState( reader, sameKey );
        assertObjectStartState( reader );
        assertStringState( reader, sameKey );
        assertNullState( reader );
        assertObjectEndState( reader );
        try {
            reader.next();
        } catch ( final JsonException e ) {
            assertEquals( "JSON keys have to be unique. The key '" + sameKey + "' already exists", e.getMessage() );
        }
    }
}

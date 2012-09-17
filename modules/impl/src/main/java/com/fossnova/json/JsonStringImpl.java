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
package com.fossnova.json;

import org.fossnova.json.JsonString;

/**
 * @author <a href="mailto:opalka dot richard at gmail dot com">Richard Opalka</a>
 */
final class JsonStringImpl implements JsonString {

    private static final long serialVersionUID = 1L;

    private String value;

    JsonStringImpl( final String value ) {
        this.value = value;
    }

    public void setString( final String value ) {
        if ( value == null ) {
            throw new IllegalArgumentException( "Parameter cannot be null" );
        }
        this.value = value;
    }

    public String getString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals( final Object o ) {
        if ( o == this ) return true;
        if ( !( o instanceof JsonStringImpl ) ) return false;
        final JsonStringImpl s = ( JsonStringImpl ) o;
        return value.equals( s.value );
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public JsonStringImpl clone() {
        return new JsonStringImpl( value );
    }
}

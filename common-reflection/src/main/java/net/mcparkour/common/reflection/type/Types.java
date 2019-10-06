/*
 * MIT License
 *
 * Copyright (c) 2019 MCParkour
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.mcparkour.common.reflection.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class Types {

	private Types() {
		throw new UnsupportedOperationException("Cannot create an instance of this class");
	}

	public static Type getRawType(Type type) {
		if (isParametrizedType(type)) {
			ParameterizedType parameterizedType = asParametrizedType(type);
			return parameterizedType.getRawType();
		}
		return type;
	}

	public static ParameterizedType asParametrizedType(Type type) {
		if (!isParametrizedType(type)) {
			throw new InvalidTypeTypeException(ParameterizedType.class);
		}
		return (ParameterizedType) type;
	}

	public static boolean isParametrizedType(Type type) {
		return type instanceof ParameterizedType;
	}

	public static Class<?> asClassType(Type type) {
		if (!isClassType(type)) {
			throw new InvalidTypeTypeException(Class.class);
		}
		return (Class<?>) type;
	}

	public static boolean isClassType(Type type) {
		return type instanceof Class;
	}
}

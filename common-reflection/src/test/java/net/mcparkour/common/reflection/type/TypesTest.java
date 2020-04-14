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

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import net.mcparkour.common.reflection.TestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TypesTest {

	@Test
	public void testGetRawClassType() throws NoSuchFieldException {
		Type stringType = getFieldType("stringField");
		Assertions.assertSame(String.class, Types.getRawClassType(stringType));
		Type mapType = getFieldType("genericsField");
		Assertions.assertSame(Map.class, Types.getRawClassType(mapType));
	}

	@Test
	public void testGetRawType() throws NoSuchFieldException {
		Type stringType = getFieldType("stringField");
		Assertions.assertEquals(String.class, Types.getRawType(stringType));
		Type mapType = getFieldType("genericsField");
		Assertions.assertEquals(Map.class, Types.getRawType(mapType));
	}

	@Test
	public void testAsParametrizedType() throws NoSuchFieldException {
		Type stringType = getFieldType("stringField");
		Assertions.assertThrows(InvalidTypeTypeException.class, () -> Types.asParametrizedType(stringType));
		Type mapType = getFieldType("genericsField");
		Assertions.assertEquals(mapType, Types.asParametrizedType(mapType));
	}

	@Test
	public void testIsParametrizedType() throws NoSuchFieldException {
		Type stringType = getFieldType("stringField");
		Assertions.assertFalse(Types.isParametrizedType(stringType));
		Type mapType = getFieldType("genericsField");
		Assertions.assertTrue(Types.isParametrizedType(mapType));
	}

	@Test
	public void testAsClassType() throws NoSuchFieldException {
		Type stringType = getFieldType("stringField");
		Assertions.assertEquals(stringType, Types.asClassType(stringType));
		Type mapType = getFieldType("genericsField");
		Assertions.assertThrows(InvalidTypeTypeException.class, () -> Types.asClassType(mapType));
	}

	@Test
	public void testIsClassType() throws NoSuchFieldException {
		Type stringType = getFieldType("stringField");
		Assertions.assertTrue(Types.isClassType(stringType));
		Type mapType = getFieldType("genericsField");
		Assertions.assertFalse(Types.isClassType(mapType));
	}

	private Type getFieldType(String fieldName) throws NoSuchFieldException {
		Field field = TestClass.class.getDeclaredField(fieldName);
		return field.getGenericType();
	}
}

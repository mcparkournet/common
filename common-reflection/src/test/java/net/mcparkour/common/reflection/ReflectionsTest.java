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

package net.mcparkour.common.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.reflect.ReflectionFactory;

public class ReflectionsTest {

	@Test
	public void testGetGenericTypes() throws NoSuchFieldException {
		Field field = TestClass.class.getDeclaredField("genericsField");
		Assertions.assertEquals(List.of(String.class, Integer.class), Reflections.getGenericTypes(field));
	}

	@Test
	public void testIsStatic() throws NoSuchFieldException {
		Field staticField = TestClass.class.getDeclaredField("staticField");
		Assertions.assertTrue(Reflections.isStatic(staticField));
		Field notStaticField = TestClass.class.getDeclaredField("notStaticField");
		Assertions.assertFalse(Reflections.isStatic(notStaticField));
	}

	@Test
	public void testAccessible() throws NoSuchFieldException {
		Field field = TestClass.class.getDeclaredField("stringField");
		TestClass testClass = new TestClass();
		Assertions.assertFalse(field.canAccess(testClass));
		Field accessibleField = Reflections.accessible(field);
		Assertions.assertTrue(field.canAccess(testClass));
		Assertions.assertTrue(accessibleField.canAccess(testClass));
	}

	@Test
	public void testGetClass() {
		Assertions.assertSame(TestClass.class, Reflections.getClass("net.mcparkour.common.reflection.TestClass"));
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getClass("net.mcparkour.common.reflection.NotTestClass"));
	}

	@Test
	public void testGetField() throws NoSuchFieldException {
		Field field = TestClass.class.getDeclaredField("stringField");
		Assertions.assertEquals(field, Reflections.getField(TestClass.class, "stringField"));
		Field staticField = TestClass.class.getDeclaredField("staticStringField");
		Assertions.assertEquals(staticField, Reflections.getField(TestClass.class, "staticStringField"));
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getField(TestClass.class, "notStringField"));
	}

	@Test
	public void testGetFieldValue() throws Exception {
		Field field = TestClass.class.getDeclaredField("stringField");
		TestClass testClass = new TestClass();
		Assertions.assertEquals(testClass.getStringField(), Reflections.getFieldValue(field, testClass));
		Field staticField = TestClass.class.getDeclaredField("staticStringField");
		Assertions.assertEquals(TestClass.getStaticStringField(), Reflections.getFieldValue(staticField, null));
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getField(TestClass.class, "notStringField"));
	}

	@Test
	public void testSetFieldValue() throws Exception {
		Field field = TestClass.class.getDeclaredField("stringField");
		TestClass testClass = new TestClass();
		Reflections.setFieldValue(field, testClass, "reflection");
		Assertions.assertEquals("reflection", testClass.getStringField());
		Field staticField = TestClass.class.getDeclaredField("staticStringField");
		Reflections.setFieldValue(staticField, null, "reflection");
		Assertions.assertEquals("reflection", TestClass.getStaticStringField());
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getField(TestClass.class, "notStringField"));
	}

	@Test
	public void testGetMethod() throws NoSuchMethodException {
		Method method = TestClass.class.getDeclaredMethod("stringMethod", String.class, String.class);
		Assertions.assertEquals(method, Reflections.getMethod(TestClass.class, "stringMethod", String.class, String.class));
		Method staticMethod = TestClass.class.getDeclaredMethod("staticStringMethod", String.class, String.class);
		Assertions.assertEquals(staticMethod, Reflections.getMethod(TestClass.class, "staticStringMethod", String.class, String.class));
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getMethod(TestClass.class, "notStringMethod"));
	}

	@Test
	public void testInvokeMethod() throws Throwable {
		Method method = TestClass.class.getDeclaredMethod("stringMethod", String.class, String.class);
		TestClass testClass = new TestClass();
		String result = (String) Reflections.invokeMethod(method, testClass, "1", "2");
		Assertions.assertEquals("12", result);
		Method staticMethod = TestClass.class.getDeclaredMethod("staticStringMethod", String.class, String.class);
		String staticResult = (String) Reflections.invokeMethod(staticMethod, null, "1", "2");
		Assertions.assertEquals("12", staticResult);
		Method exceptionMethod = TestClass.class.getDeclaredMethod("exceptionMethod");
		Assertions.assertThrows(UncheckedInvocationTargetException.class, () -> Reflections.invokeMethod(exceptionMethod, testClass));
		try {
			Reflections.invokeMethod(exceptionMethod, testClass);
		} catch (UncheckedInvocationTargetException exception) {
			Assertions.assertSame(TestException.class, exception.getTargetException().getClass());
		}
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getMethod(TestClass.class, "notStringMethod"));
	}

	@Test
	public void testGetConstructor() throws NoSuchMethodException {
		Constructor<TestClass> constructor = TestClass.class.getDeclaredConstructor(String.class, String.class);
		Assertions.assertEquals(constructor, Reflections.getConstructor(TestClass.class, String.class, String.class));
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getConstructor(TestClass.class, Integer.class));
	}

	@Test
	@SuppressWarnings("UseOfSunClasses")
	public void testGetSerializationConstructor() throws NoSuchMethodException {
		ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
		Constructor<Object> objectConstructor = Object.class.getDeclaredConstructor();
		Constructor<?> constructor = reflectionFactory.newConstructorForSerialization(TestClass.class, objectConstructor);
		Assertions.assertEquals(constructor, Reflections.getSerializationConstructor(TestClass.class));
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getConstructor(TestClass.class, Integer.class));
	}

	@Test
	public void testNewInstance() throws NoSuchMethodException {
		Constructor<TestClass> constructor = TestClass.class.getDeclaredConstructor(String.class);
		Assertions.assertEquals(new TestClass("test"), Reflections.newInstance(constructor, "test"));
		Assertions.assertThrows(UncheckedReflectiveOperationException.class, () -> Reflections.getConstructor(TestClass.class, Integer.class));
	}
}

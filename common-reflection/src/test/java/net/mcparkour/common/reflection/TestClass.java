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

import java.util.Map;
import java.util.Objects;

public class TestClass {

	public TestClass() {}

	private Map<String, Integer> genericsField;
	private static String staticField;
	private String notStaticField;
	private String stringField = "test";
	private static String staticStringField = "static test";
	private String string;
	private final String finalField = null;
	private transient String transientField;

	private String stringMethod(String string1, String string2) {
		return string1 + string2;
	}

	private static String staticStringMethod(String string1, String string2) {
		return string1 + string2;
	}

	private void exceptionMethod() {
		throw new TestException();
	}

	private TestClass(String string1, String string2) {}

	public TestClass(String string) {
		this.string = string;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		TestClass testClass = (TestClass) object;
		return Objects.equals(this.string, testClass.string);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.string);
	}

	public String getStringField() {
		return this.stringField;
	}

	public static String getStaticStringField() {
		return staticStringField;
	}
}

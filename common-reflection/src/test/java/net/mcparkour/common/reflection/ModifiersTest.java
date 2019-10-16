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

import java.lang.reflect.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModifiersTest {

	@Test
	public void testIsFinal() throws NoSuchFieldException {
		Field finalField = TestClass.class.getDeclaredField("finalField");
		Assertions.assertTrue(Modifiers.isFinal(finalField));
		Field notFinalField = TestClass.class.getDeclaredField("transientField");
		Assertions.assertFalse(Modifiers.isFinal(notFinalField));
	}

	@Test
	public void testIsStatic() throws NoSuchFieldException {
		Field staticField = TestClass.class.getDeclaredField("staticField");
		Assertions.assertTrue(Modifiers.isStatic(staticField));
		Field notStaticField = TestClass.class.getDeclaredField("finalField");
		Assertions.assertFalse(Modifiers.isStatic(notStaticField));
	}

	@Test
	public void testIsTransient() throws NoSuchFieldException {
		Field transientField = TestClass.class.getDeclaredField("transientField");
		Assertions.assertTrue(Modifiers.isTransient(transientField));
		Field notTransientField = TestClass.class.getDeclaredField("staticField");
		Assertions.assertFalse(Modifiers.isTransient(notTransientField));
	}
}

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

package net.mcparkour.common.text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UUIDConverterTest {

	@Test
	public void testToDashed() {
		Assertions.assertEquals("00000001-0001-0001-0001-0000000000f1", UUIDConverter.toDashed("000000010001000100010000000000f1"));
	}

	@Test
	public void testIsDashed() {
		Assertions.assertTrue(UUIDConverter.isDashed("00000001-0001-0001-0001-0000000000f1"));
		Assertions.assertFalse(UUIDConverter.isDashed("000000010001000100010000000000f1"));
		Assertions.assertFalse(UUIDConverter.isDashed("00000001-0001-0001-0001-000000000gf1"));
	}

	@Test
	public void testToPlain() {
		Assertions.assertEquals("000000010001000100010000000000f1", UUIDConverter.toPlain("00000001-0001-0001-0001-0000000000f1"));
	}

	@Test
	public void testIsPlain() {
		Assertions.assertTrue(UUIDConverter.isPlain("000000010001000100010000000000f1"));
		Assertions.assertFalse(UUIDConverter.isPlain("00000001-0001-0001-0001-0000000000f1"));
		Assertions.assertFalse(UUIDConverter.isPlain("00000001000100010001000000000gf1"));
	}
}

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

public class NumericParserTest {

	@Test
	public void testParseByte() {
		Assertions.assertEquals((byte) 1, NumericParser.parseByte("1"));
		Assertions.assertNull(NumericParser.parseByte("a"));
	}

	@Test
	public void testParseShort() {
		Assertions.assertEquals((short) 1, NumericParser.parseShort("1"));
		Assertions.assertNull(NumericParser.parseShort("a"));
	}

	@Test
	public void testParseInteger() {
		Assertions.assertEquals(1, NumericParser.parseInteger("1"));
		Assertions.assertNull(NumericParser.parseInteger("a"));
	}

	@Test
	public void testParseLong() {
		Assertions.assertEquals(1, NumericParser.parseLong("1"));
		Assertions.assertNull(NumericParser.parseLong("a"));
	}

	@Test
	public void testParseFloat() {
		Assertions.assertEquals(1, NumericParser.parseFloat("1"));
		Assertions.assertNull(NumericParser.parseFloat("a"));
	}

	@Test
	public void testParseDouble() {
		Assertions.assertEquals(1, NumericParser.parseDouble("1"));
		Assertions.assertNull(NumericParser.parseDouble("a"));
	}
}

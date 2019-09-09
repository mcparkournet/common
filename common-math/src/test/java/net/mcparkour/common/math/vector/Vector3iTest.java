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

package net.mcparkour.common.math.vector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Vector3iTest {

	private Vector3i vector;

	@BeforeEach
	public void setUp() {
		this.vector = new Vector3i(2, 2, 2);
	}

	@Test
	public void testPlusX() {
		Assertions.assertEquals(new Vector3i(5, 2, 2), this.vector.plusX(3));
		Assertions.assertEquals(new Vector3i(-1, 2, 2), this.vector.plusX(-3));
	}

	@Test
	public void testPlusY() {
		Assertions.assertEquals(new Vector3i(2, 5, 2), this.vector.plusY(3));
		Assertions.assertEquals(new Vector3i(2, -1, 2), this.vector.plusY(-3));
	}

	@Test
	public void testPlusZ() {
		Assertions.assertEquals(new Vector3i(2, 2, 5), this.vector.plusZ(3));
		Assertions.assertEquals(new Vector3i(2, 2, -1), this.vector.plusZ(-3));
	}

	@Test
	public void testPlusVector() {
		Assertions.assertEquals(new Vector3i(5, 5, 5), this.vector.plus(new Vector3i(3, 3, 3)));
		Assertions.assertEquals(new Vector3i(-1, -1, -1), this.vector.plus(new Vector3i(-3, -3, -3)));
	}

	@Test
	public void testPlus() {
		Assertions.assertEquals(new Vector3i(5, 5, 5), this.vector.plus(3, 3, 3));
		Assertions.assertEquals(new Vector3i(-1, -1, -1), this.vector.plus(-3, -3, -3));
	}

	@Test
	public void testTimesX() {
		Assertions.assertEquals(new Vector3i(6, 2, 2), this.vector.timesX(3));
		Assertions.assertEquals(new Vector3i(-6, 2, 2), this.vector.timesX(-3));
	}

	@Test
	public void testTimesY() {
		Assertions.assertEquals(new Vector3i(2, 6, 2), this.vector.timesY(3));
		Assertions.assertEquals(new Vector3i(2, -6, 2), this.vector.timesY(-3));
	}

	@Test
	public void testTimesZ() {
		Assertions.assertEquals(new Vector3i(2, 2, 6), this.vector.timesZ(3));
		Assertions.assertEquals(new Vector3i(2, 2, -6), this.vector.timesZ(-3));
	}

	@Test
	public void testTimesVector() {
		Assertions.assertEquals(new Vector3i(6, 6, 6), this.vector.times(new Vector3i(3, 3, 3)));
		Assertions.assertEquals(new Vector3i(-6, -6, -6), this.vector.times(new Vector3i(-3, -3, -3)));
	}

	@Test
	public void testTimes() {
		Assertions.assertEquals(new Vector3i(6, 6, 6), this.vector.times(3, 3, 3));
		Assertions.assertEquals(new Vector3i(-6, -6, -6), this.vector.times(-3, -3, -3));
	}
}

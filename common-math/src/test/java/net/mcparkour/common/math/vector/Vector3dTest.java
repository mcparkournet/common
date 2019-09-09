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

public class Vector3dTest {

	private Vector3d vector;

	@BeforeEach
	public void setUp() {
		this.vector = new Vector3d(2, 2, 2);
	}

	@Test
	public void testPlusX() {
		Assertions.assertEquals(new Vector3d(5, 2, 2), this.vector.plusX(3));
		Assertions.assertEquals(new Vector3d(-1, 2, 2), this.vector.plusX(-3));
		Assertions.assertEquals(new Vector3d(5.5, 2, 2), this.vector.plusX(3.5));
		Assertions.assertEquals(new Vector3d(-1.5, 2, 2), this.vector.plusX(-3.5));
	}

	@Test
	public void testPlusY() {
		Assertions.assertEquals(new Vector3d(2, 5, 2), this.vector.plusY(3));
		Assertions.assertEquals(new Vector3d(2, -1, 2), this.vector.plusY(-3));
		Assertions.assertEquals(new Vector3d(2, 5.5, 2), this.vector.plusY(3.5));
		Assertions.assertEquals(new Vector3d(2, -1.5, 2), this.vector.plusY(-3.5));
	}

	@Test
	public void testPlusZ() {
		Assertions.assertEquals(new Vector3d(2, 2, 5), this.vector.plusZ(3));
		Assertions.assertEquals(new Vector3d(2, 2, -1), this.vector.plusZ(-3));
		Assertions.assertEquals(new Vector3d(2, 2, 5.5), this.vector.plusZ(3.5));
		Assertions.assertEquals(new Vector3d(2, 2, -1.5), this.vector.plusZ(-3.5));
	}

	@Test
	public void testPlusVector() {
		Assertions.assertEquals(new Vector3d(5, 5, 5), this.vector.plus(new Vector3d(3, 3, 3)));
		Assertions.assertEquals(new Vector3d(-1, -1, -1), this.vector.plus(new Vector3d(-3, -3, -3)));
		Assertions.assertEquals(new Vector3d(5.5, 5.5, 5.5), this.vector.plus(new Vector3d(3.5, 3.5, 3.5)));
		Assertions.assertEquals(new Vector3d(-1.5, -1.5, -1.5), this.vector.plus(new Vector3d(-3.5, -3.5, -3.5)));
	}

	@Test
	public void testPlus() {
		Assertions.assertEquals(new Vector3d(5, 5, 5), this.vector.plus(3, 3, 3));
		Assertions.assertEquals(new Vector3d(-1, -1, -1), this.vector.plus(-3, -3, -3));
		Assertions.assertEquals(new Vector3d(5.5, 5.5, 5.5), this.vector.plus(3.5, 3.5, 3.5));
		Assertions.assertEquals(new Vector3d(-1.5, -1.5, -1.5), this.vector.plus(-3.5, -3.5, -3.5));
	}

	@Test
	public void testTimesX() {
		Assertions.assertEquals(new Vector3d(6, 2, 2), this.vector.timesX(3));
		Assertions.assertEquals(new Vector3d(-6, 2, 2), this.vector.timesX(-3));
		Assertions.assertEquals(new Vector3d(7, 2, 2), this.vector.timesX(3.5));
		Assertions.assertEquals(new Vector3d(-7, 2, 2), this.vector.timesX(-3.5));
	}

	@Test
	public void testTimesY() {
		Assertions.assertEquals(new Vector3d(2, 6, 2), this.vector.timesY(3));
		Assertions.assertEquals(new Vector3d(2, -6, 2), this.vector.timesY(-3));
		Assertions.assertEquals(new Vector3d(2, 7, 2), this.vector.timesY(3.5));
		Assertions.assertEquals(new Vector3d(2, -7, 2), this.vector.timesY(-3.5));
	}

	@Test
	public void testTimesZ() {
		Assertions.assertEquals(new Vector3d(2, 2, 6), this.vector.timesZ(3));
		Assertions.assertEquals(new Vector3d(2, 2, -6), this.vector.timesZ(-3));
		Assertions.assertEquals(new Vector3d(2, 2, 7), this.vector.timesZ(3.5));
		Assertions.assertEquals(new Vector3d(2, 2, -7), this.vector.timesZ(-3.5));
	}

	@Test
	public void testTimesVector() {
		Assertions.assertEquals(new Vector3d(6, 6, 6), this.vector.times(new Vector3d(3, 3, 3)));
		Assertions.assertEquals(new Vector3d(-6, -6, -6), this.vector.times(new Vector3d(-3, -3, -3)));
		Assertions.assertEquals(new Vector3d(7, 7, 7), this.vector.times(new Vector3d(3.5, 3.5, 3.5)));
		Assertions.assertEquals(new Vector3d(-7, -7, -7), this.vector.times(new Vector3d(-3.5, -3.5, -3.5)));
	}

	@Test
	public void testTimes() {
		Assertions.assertEquals(new Vector3d(6, 6, 6), this.vector.times(3, 3, 3));
		Assertions.assertEquals(new Vector3d(-6, -6, -6), this.vector.times(-3, -3, -3));
		Assertions.assertEquals(new Vector3d(7, 7, 7), this.vector.times(3.5, 3.5, 3.5));
		Assertions.assertEquals(new Vector3d(-7, -7, -7), this.vector.times(-3.5, -3.5, -3.5));
	}
}

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

package net.mcparkour.common.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathHelperTest {

	@Test
	public void testCircleArea() {
		Assertions.assertEquals(Math.PI * 9, MathHelper.circleArea(3));
		Assertions.assertEquals(Math.PI * 12.25, MathHelper.circleArea(3.5));
	}

	@Test
	public void testSphereVolume() {
		Assertions.assertEquals(4.0 / 3.0 * Math.PI * 27, MathHelper.sphereVolume(3));
		Assertions.assertEquals(4.0 / 3.0 * Math.PI * 42.875, MathHelper.sphereVolume(3.5));
	}

	@Test
	public void testSquare() {
		Assertions.assertEquals(9, MathHelper.square(3));
		Assertions.assertEquals(12.25, MathHelper.square(3.5));
	}

	@Test
	public void testCube() {
		Assertions.assertEquals(27, MathHelper.cube(3));
		Assertions.assertEquals(42.875, MathHelper.cube(3.5));
	}
}

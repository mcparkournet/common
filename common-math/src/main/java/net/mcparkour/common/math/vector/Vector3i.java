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

import java.util.Objects;

public class Vector3i {

	private int x;
	private int y;
	private int z;

	public Vector3i() {
		this(0, 0, 0);
	}

	public Vector3i(Vector3i vector) {
		this(vector.x, vector.y, vector.z);
	}

	public Vector3i(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3i plusX(int x) {
		return plus(x, 0, 0);
	}

	public Vector3i plusY(int y) {
		return plus(0, y, 0);
	}

	public Vector3i plusZ(int z) {
		return plus(0, 0, z);
	}

	public Vector3i plus(Vector3i vector) {
		return plus(vector.x, vector.y, vector.z);
	}

	public Vector3i plus(int x, int y, int z) {
		return new Vector3i(this.x + x, this.y + y, this.z + z);
	}

	public Vector3i timesX(int x) {
		return times(x, 1, 1);
	}

	public Vector3i timesY(int y) {
		return times(1, y, 1);
	}

	public Vector3i timesZ(int z) {
		return times(1, 1, z);
	}

	public Vector3i times(Vector3i vector) {
		return times(vector.x, vector.y, vector.z);
	}

	public Vector3i times(int x, int y, int z) {
		return new Vector3i(this.x * x, this.y * y, this.z * z);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Vector3i vector3i = (Vector3i) object;
		return this.x == vector3i.x &&
			this.y == vector3i.y &&
			this.z == vector3i.z;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y, this.z);
	}

	@Override
	public String toString() {
		return "Vector3i{" +
			"x=" + this.x +
			", y=" + this.y +
			", z=" + this.z +
			"}";
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getZ() {
		return this.z;
	}
}

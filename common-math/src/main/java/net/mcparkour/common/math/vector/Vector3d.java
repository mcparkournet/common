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

public class Vector3d {

	private double x;
	private double y;
	private double z;

	public Vector3d() {
		this(0, 0, 0);
	}

	public Vector3d(Vector3d vector) {
		this(vector.x, vector.y, vector.z);
	}

	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d plusX(double x) {
		return plus(x, 0, 0);
	}

	public Vector3d plusY(double y) {
		return plus(0, y, 0);
	}

	public Vector3d plusZ(double z) {
		return plus(0, 0, z);
	}

	public Vector3d plus(Vector3d vector) {
		return plus(vector.x, vector.y, vector.z);
	}

	public Vector3d plus(double x, double y, double z) {
		return new Vector3d(this.x + x, this.y + y, this.z + z);
	}

	public Vector3d timesX(double x) {
		return times(x, 1, 1);
	}

	public Vector3d timesY(double y) {
		return times(1, y, 1);
	}

	public Vector3d timesZ(double z) {
		return times(1, 1, z);
	}

	public Vector3d times(Vector3d vector) {
		return times(vector.x, vector.y, vector.z);
	}

	public Vector3d times(double x, double y, double z) {
		return new Vector3d(this.x * x, this.y * y, this.z * z);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Vector3d vector3d = (Vector3d) object;
		return Double.compare(vector3d.x, this.x) == 0 &&
			Double.compare(vector3d.y, this.y) == 0 &&
			Double.compare(vector3d.z, this.z) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y, this.z);
	}

	@Override
	public String toString() {
		return "Vector3d{" +
			"x=" + this.x +
			", y=" + this.y +
			", z=" + this.z +
			"}";
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}
}

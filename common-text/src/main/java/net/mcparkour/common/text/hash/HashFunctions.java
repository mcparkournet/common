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

package net.mcparkour.common.text.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashFunctions {

	private HashFunctions() {
		throw new UnsupportedOperationException("Cannot create an instance of this class");
	}

	public static String hash(String text, HashFunction function) {
		String functionName = function.getName();
		return hash(text, functionName);
	}

	public static String hash(String text, String functionName) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(functionName);
			byte[] bytes = text.getBytes();
			messageDigest.update(bytes);
			byte[] digest = messageDigest.digest();
			StringBuilder builder = new StringBuilder(digest.length * 2);
			for (byte decimal : digest) {
				String hex = Integer.toHexString(decimal & 0xFF | 0x100);
				builder.append(hex, 1, 3);
			}
			return builder.toString();
		} catch (NoSuchAlgorithmException exception) {
			throw new RuntimeException(exception);
		}
	}
}

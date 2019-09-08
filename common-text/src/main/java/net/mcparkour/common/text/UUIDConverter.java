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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UUIDConverter {

	private static final Pattern DASHED_UUID_PATTERN = Pattern.compile("([0-9a-fA-F]{8})-([0-9a-fA-F]{4})-([0-9a-fA-F]{4})-([0-9a-fA-F]{4})-([0-9a-fA-F]{12})");
	private static final Pattern PLAIN_UUID_PATTERN = Pattern.compile("([0-9a-fA-F]{8})([0-9a-fA-F]{4})([0-9a-fA-F]{4})([0-9a-fA-F]{4})([0-9a-fA-F]{12})");

	private UUIDConverter() {
		throw new UnsupportedOperationException("Cannot create an instance of this class");
	}

	public static String toDashed(String plainUUID) {
		Matcher matcher = PLAIN_UUID_PATTERN.matcher(plainUUID);
		return matcher.replaceAll("$1-$2-$3-$4-$5");
	}

	public static boolean isDashed(String uuid) {
		Matcher matcher = DASHED_UUID_PATTERN.matcher(uuid);
		return matcher.matches();
	}

	public static String toPlain(String dashedUUID) {
		Matcher matcher = DASHED_UUID_PATTERN.matcher(dashedUUID);
		return matcher.replaceAll("$1$2$3$4$5");
	}

	public static boolean isPlain(String uuid) {
		Matcher matcher = PLAIN_UUID_PATTERN.matcher(uuid);
		return matcher.matches();
	}
}

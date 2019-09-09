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

package net.mcparkour.common.cache;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class TemporaryCache<T> implements Cache<T> {

	private Supplier<? extends T> refresher;
	private Duration duration;
	private T cached;
	private Instant expirationTime;

	public TemporaryCache(Supplier<? extends T> refresher, Duration duration) {
		this.refresher = refresher;
		this.duration = duration;
		this.cached = refresher.get();
		this.expirationTime = calculateExpirationTime();
	}

	@Override
	public synchronized void refresh() {
		this.cached = this.refresher.get();
		this.expirationTime = calculateExpirationTime();
	}

	@Override
	public synchronized T get() {
		Instant now = Instant.now();
		Duration duration = Duration.between(now, this.expirationTime);
		if (duration.isNegative()) {
			this.cached = this.refresher.get();
			this.expirationTime = calculateExpirationTime(now);
		}
		return this.cached;
	}

	private Instant calculateExpirationTime() {
		Instant now = Instant.now();
		return calculateExpirationTime(now);
	}

	private Instant calculateExpirationTime(Instant now) {
		return now.plus(this.duration);
	}
}

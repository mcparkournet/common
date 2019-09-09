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
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.function.Supplier;

public class CacheBuilder<T> {

	private Supplier<? extends T> refresher;
	private Duration duration;

	public CacheBuilder<T> refresher(Supplier<? extends T> refresher) {
		this.refresher = refresher;
		return this;
	}

	public CacheBuilder<T> millis(long millis) {
		Duration duration = Duration.ofMillis(millis);
		return duration(duration);
	}

	public CacheBuilder<T> seconds(long seconds) {
		Duration duration = Duration.ofSeconds(seconds);
		return duration(duration);
	}

	public CacheBuilder<T> minutes(long minutes) {
		Duration duration = Duration.ofMinutes(minutes);
		return duration(duration);
	}

	public CacheBuilder<T> hours(long hours) {
		Duration duration = Duration.ofHours(hours);
		return duration(duration);
	}

	public CacheBuilder<T> days(long days) {
		Duration duration = Duration.ofDays(days);
		return duration(duration);
	}

	public CacheBuilder<T> duration(long amount, ChronoUnit unit) {
		Duration duration = Duration.of(amount, unit);
		return duration(duration);
	}

	public CacheBuilder<T> duration(Duration duration) {
		this.duration = duration;
		return this;
	}

	public Cache<T> build() {
		Objects.requireNonNull(this.refresher);
		return this.duration == null ? new PermanentCache<>(this.refresher) : new TemporaryCache<>(this.refresher, this.duration);
	}
}

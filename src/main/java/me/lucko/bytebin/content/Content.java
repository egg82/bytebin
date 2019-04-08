/*
 * This file is part of bytebin, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.bytebin.content;

import org.rapidoid.http.MediaType;

/**
 * Encapsulates content within the service
 */
public final class Content {

    /** Empty byte array */
    public static final byte[] EMPTY_BYTES = new byte[0];

    /** Empty content instance */
    public static final Content EMPTY_CONTENT = new Content(null, MediaType.TEXT_PLAIN, Long.MAX_VALUE, EMPTY_BYTES);

    /** Number of bytes in a megabyte */
    public static final long MEGABYTE_LENGTH = 1024L * 1024L;

    private final String key;
    private final MediaType mediaType;
    private final long expiry;
    private final byte[] content;

    public Content(String key, MediaType mediaType, long expiry, byte[] content) {
        this.key = key;
        this.mediaType = mediaType;
        this.expiry = expiry;
        this.content = content;
    }

    public String getKey() {
        return this.key;
    }

    public MediaType getMediaType() {
        return this.mediaType;
    }

    public long getExpiry() {
        return this.expiry;
    }

    public byte[] getContent() {
        return this.content;
    }

    public boolean shouldExpire() {
        return this.getExpiry() < System.currentTimeMillis();
    }
}

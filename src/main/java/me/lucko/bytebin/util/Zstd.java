package me.lucko.bytebin.util;

import com.github.luben.zstd.ZstdOutputStream;

import com.google.common.io.ByteStreams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class Zstd {
    private Zstd() {}

    public static byte[] compress(byte[] buf) {
        ByteArrayOutputStream out = new ByteArrayOutputStream(buf.length);
        try (ZstdOutputStream zstdOut = new ZstdOutputStream(out, 9)) {
            zstdOut.write(buf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }

    public static byte[] decompress(byte[] buf) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        try (ZipInputStream zstdIn = new ZipInputStream(in)) {
            return ByteStreams.toByteArray(zstdIn);
        }
    }

}

package com.github.yuizho.v12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class IoUpdates {
    public static void main(String... args) throws IOException {
        var path1 = Path.of("/tmp", "hoge1.txt");
        Files.writeString(path1, "hogefugapiyo");
        var path2 = Path.of("/tmp", "hoge2.txt");
        Files.writeString(path2, "hogerugapiyo");
        // https://docs.oracle.com/javase/jp/12/docs/api/java.base/java/nio/file/Files.html#mismatch(java.nio.file.Path,java.nio.file.Path)
        // 2つのファイルの不一致バイト位置を返す。同じなら-1
        System.out.println(Files.mismatch(path1, path2));

        // https://docs.oracle.com/javase/jp/12/docs/api/java.base/java/io/ByteArrayInputStream.html#skipNBytes(long)
        var input = new ByteArrayInputStream("hello world".getBytes());
        input.skipNBytes(6);
        int n;
        while ((n = input.read()) != -1) {
            System.out.println((char) n);
        }
    }
}

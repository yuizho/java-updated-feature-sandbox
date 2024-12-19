package com.github.yuizho.v8_11;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class IoUpdates {
    public static void main(String... args) throws IOException {
        // これ複数の引数指定できたのね (/とかで区切られるイメージになる)
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/nio/file/Path.html#of(java.lang.String,java.lang.String...)
        var path = Path.of("/tmp", "hoge.txt");

        // 一発でファイル書き込みできるようになった
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/nio/file/Files.html#writeString(java.nio.file.Path,java.lang.CharSequence,java.nio.charset.Charset,java.nio.file.OpenOption...)
        Files.writeString(path, "hoge");

        // 読み込みもファイルして一発でStringで取れる
        // バッファリングとかうまいことやったりはしないので、単純なファイルをパッと撮るケースで使われるのを想定してるとのこと
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/nio/file/Files.html#readString(java.nio.file.Path,java.nio.charset.Charset)
        System.out.println(Files.readString(path));


        // inputStream, outputStream系も同様
        // readerで読み取った内容をそのままwriterに流せるように
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/io/Reader.html#transferTo(java.io.Writer)
        var printWriter = new PrintWriter(System.out, true);
        new StringReader("hogefugapiyo").transferTo(printWriter);
        printWriter.println();

        // inputStream, outputStream系も同様
        // 書き込まれても何もしない(捨てちゃう)Writerを返すファクトリみたいなのが増えた。本番で使う用途とかではない気がする。
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/io/Writer.html#nullWriter()
        try (var nullWriter = PrintWriter.nullWriter()) {
            nullWriter.write("hoge");
            nullWriter.flush();
        }
    }
}

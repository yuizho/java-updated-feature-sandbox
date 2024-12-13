package com.github.yuizho.v8_11;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Optional.html#isEmpty()
        var emptyOpt = Optional.ofNullable(null);
        System.out.println(emptyOpt.isEmpty());

        System.out.println("-------------------------");

        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Optional.html#orElseThrow()
        try {
            emptyOpt.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-------------------------");

        // Optionalを直接steamに変換できるようになった
        // 前は中身あるかfilterしたりしてたのが不要になって、そのままflatmapしてstreamに変換できる
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Optional.html#stream()
        var map = Map.of(1, "hoge", 2, "fuga", 3, "piyo");
        var ids = List.of(1, 3, 4);
        ids.stream().flatMap(id -> Optional.ofNullable(map.get(id)).stream())
                .forEach(System.out::println);

        System.out.println("-------------------------");

        // これもかなり使いそうで非常によい
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Optional.html#ifPresentOrElse(java.util.function.Consumer,java.lang.Runnable)
        emptyOpt.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("empty")
        );

        System.out.println("-------------------------");

        // あんま使い方わからんかったので利用例の記事。orElseGetとちがって、Optinalを返すのでフォールバック処理をチェーンしてかける
        // https://developer.mamezou-tech.com/blogs/2023/01/23/rethinking-optional-afterjava9/#or---%E3%83%95%E3%82%A9%E3%83%BC%E3%83%AB%E3%83%90%E3%83%83%E3%82%AF%E5%87%A6%E7%90%86%E3%81%8C%E6%96%AD%E7%84%B6%E8%A6%8B%E3%82%84%E3%81%99%E3%81%8F%E3%81%AA%E3%82%8B
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Optional.html#or()
        emptyOpt
                .or(() -> Optional.of("fallback"))
                .stream()
                .forEach(System.out::println);
    }
}

package com.github.yuizho.v8_11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class CollectionsUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/List.html#of(E)
        var list = List.of("hoge", "fuga", "piyo");

        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/List.html#copyOf(java.util.Collection)
        var copiedList = List.copyOf(list);
        System.out.println(copiedList);

        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Map.html#ofEntries(java.util.Map.Entry...)
        var map = Map.ofEntries(
                Map.entry(1, "a"),
                Map.entry(2, "b"),
                Map.entry(3, "c"),
                Map.entry(4, "")
        );
        System.out.println(map);

        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/function/Predicate.html#not(java.util.function.Predicate)
        map.values()
                .stream()
                .filter(not(String::isEmpty))
                .forEach(System.out::println);

        // 地味に面倒だったtoArrayがやりやすくなった (配列のインスタンスではなくて、配列を生成する関数を渡せるようになった！)
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Collection.html#toArray(java.util.function.IntFunction)
        String[] copiedArray = list.toArray(String[]::new);
        Arrays.stream(copiedArray).forEach(System.out::println);

        // 順序付けされていないStreamの場合結果は非決定的になると
        // 順序付けられたパラレル・パイプラインで使うと高価な操作になるとのことで、unorderedにすると早くなったり可能性があるとのこと
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/stream/Stream.html#dropWhile(java.util.function.Predicate)
        Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r")
                .dropWhile(not(s -> s.equals("g")))
                .takeWhile(not(s -> s.equals("k")))
                .forEach(System.out::println);

        // Optional.ofNullableのStream版
        Stream.ofNullable(null).forEach(System.out::println);
        Stream.ofNullable("hoge").forEach(System.out::println);

        // 以前はimitが必要で使い所が難しかったが、停止条件(第二引数: hasNext)をつけられるようになった
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/stream/Stream.html#iterate(T,java.util.function.Predicate,java.util.function.UnaryOperator)
        IntStream.iterate(0, i -> i <= 30, i -> i + 1)
                .forEach(System.out::print);
    }
}

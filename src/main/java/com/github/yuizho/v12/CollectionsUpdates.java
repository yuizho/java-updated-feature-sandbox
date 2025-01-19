package com.github.yuizho.v12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class CollectionsUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/12/docs/api/java.base/java/util/stream/Collectors.html#teeing(java.util.stream.Collector,java.util.stream.Collector,java.util.function.BiFunction)
        // 終端で２つのCollectorを実行できる
        var map = Stream.of("aaa", "bb", "ccc", "d")
                .collect(
                        Collectors.teeing(
                                Collectors.filtering(s -> s.length() % 2 == 0, Collectors.toList()),
                                Collectors.filtering(not(s -> s.length() % 2 == 0), Collectors.toList()),
                                (List<String> nonEmpty, List<String> empty) -> Map.of("偶数", nonEmpty, "奇数", empty)
                        )
                );
        System.out.println(map);
    }
}

package com.github.yuizho.v8_11;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsUpdates {
    public static void main(String... args) {
        var list = List.of("hoge", "fuga", "piyo");
        // その名の通り、unmodifiableなListを返す。Mpa, Setもある
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/stream/Collectors.html#toUnmodifiableList()
        // Java16以降使えるならStream#toList()とかが使えるのであんまり使う機会なくなるかもなぁ
        try {
            var collectedUnmodified = list.stream().collect(Collectors.toUnmodifiableList());
            collectedUnmodified.add("hoge");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        // これ、最初Stream#filterと何が違うんだと思ったが、groupingByの結果をさらにfilterできるようになったりしてるとのこと
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/stream/Collectors.html#filtering(java.util.function.Predicate,java.util.stream.Collector)
        var map = List.of("hoge", "fuga", "piyo", "hoge", "bar", "foo", "bar", "aa", "bas", "bb")
                .stream()
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.filtering(
                                        // groupingByのvalueのListに対してさらにfilterをかける
                                        s -> !s.contains("a"),
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(map);

        // filteringと同じような感じでgropingByの結果をさらにflatmapできるようになった
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/stream/Collectors.html#flatMapping(java.util.function.Function,java.util.stream.Collector)
        var orderdByCustomer = List.of(
                new Order("hoge", List.of("hoge")),
                new Order("fuga", List.of("fuga", "piyo")),
                new Order("piyo", List.of("hoge", "fuga", "piyo")),
                new Order("hoge", List.of("hoge", "fuga", "piyo"))
        )
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.flatMapping(
                                        // groupingByのvalueのListに対してさらにflatmapをかける
                                        order -> order.getItems().stream(),
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(orderdByCustomer);
    }
}

class Order {
    private final String customerName;
    private final List<String> items;

    public Order(String customerName, List<String> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return items;
    }
}

package com.github.yuizho.v8_11;

public class StringUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/lang/String.html
        "hogehogee".chars().forEach(System.out::println);

        System.out.println("-------------------------");

        "fugafuga".codePoints().forEach(System.out::println);

        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/lang/String.html
        System.out.println(
                "hoge".repeat(3)
        );

        System.out.println("-------------------------");

        // 文字列がからか、スペースのみならtrueを返す
        System.out.println(" ".isBlank());
        // 全角スペースも行ける (Unicode対応)
        System.out.println("　".isBlank());

        System.out.println("-------------------------");

        // lineと組み合わせると各業の前後スペースが取り除けて便利とのこと
        System.out.println(" hoge ".strip());
        System.out.println(" hoge ".stripLeading());
        System.out.println(" hoge ".stripTrailing());

        System.out.println("-------------------------");

        // javadocによると遅延評価と改行記号の拘束な検索をするのでsplitより早いらしい
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/lang/String.html#lines()
        "hoge\nfuga\npiyo".lines().forEach(System.out::println);
    }
}

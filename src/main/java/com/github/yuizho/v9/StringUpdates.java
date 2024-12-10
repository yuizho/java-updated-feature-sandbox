package com.github.yuizho.v9;

public class StringUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/lang/String.html
        "hogehogee".chars().forEach(System.out::println);

        System.out.println("-------------------------");

        "fugafuga".codePoints().forEach(System.out::println);
    }
}

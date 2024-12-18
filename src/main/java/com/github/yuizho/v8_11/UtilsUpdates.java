package com.github.yuizho.v8_11;

import java.util.Objects;

public class UtilsUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Objects.html#requireNonNullElse(T,T)
        System.out.println(
                Objects.requireNonNullElse(null, "hoge")
        );

        // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Objects.html#requireNonNullElseGet(T,java.util.function.Supplier)
        System.out.println(
                Objects.requireNonNullElseGet(null, () -> "hoge by supplier")
        );

        try {
            // なにこれ？と思ったけどListとかのindex範囲チェックにつかうんかな
            // ここでは省略するけど、派生で checkFromToIndex, checkFromIndexSizeもある
            // https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Objects.html#checkIndex(int,int)
            System.out.println(
                    Objects.checkIndex(2, 3)
            );
            Objects.checkIndex(3, 3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}

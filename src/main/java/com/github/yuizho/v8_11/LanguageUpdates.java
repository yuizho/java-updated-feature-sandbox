package com.github.yuizho.v8_11;

import java.io.IOException;

public class LanguageUpdates {
    public static void main(String[] args) throws IOException {
        // https://openjdk.org/jeps/213
        // 実施的finalならtry-with-resourcesの外で宣言した変数を指定できるようになった
        ClosableImpl closable = new ClosableImpl();
        try (closable) {
            System.out.println("do something");
        }

        // https://openjdk.org/jeps/286
        var hoge = "hoge";
    }
}

class ClosableImpl implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("close CloseImpl instance");
    }
}

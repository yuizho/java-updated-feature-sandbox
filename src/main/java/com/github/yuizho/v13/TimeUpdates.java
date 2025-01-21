package com.github.yuizho.v13;

import java.time.chrono.JapaneseDate;

public class TimeUpdates {
    public static void main(String... args) {
        // https://qiita.com/nowokay/items/3e1625a77cb435394547#japaneseera%E3%81%B8%E3%81%AE%E4%BB%A4%E5%92%8C%E3%81%AE%E8%BF%BD%E5%8A%A0
        // JapaneseEraに令和の年号が増えた。それまではNewEra表記だった。
        System.out.println(JapaneseDate.of(2019, 4, 30));
        System.out.println(JapaneseDate.of(2019, 5, 1));
    }
}

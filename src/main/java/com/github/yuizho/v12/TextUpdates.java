package com.github.yuizho.v12;

import java.text.NumberFormat;
import java.util.Locale;

public class TextUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/12/docs/api/java.base/java/text/NumberFormat.html#getCompactNumberInstance()
        var formatJpn = NumberFormat.getCompactNumberInstance();
        System.out.println(formatJpn.format(100000));

        var formatFrance = NumberFormat.getCompactNumberInstance(Locale.FRANCE, NumberFormat.Style.LONG);
        System.out.println(formatFrance.format(100000));
    }
}

package com.github.yuizho.v12;

public class LanguageUpdates {
    public static void main(String... args) {
        // https://qiita.com/nowokay/items/0e860819b6ffb1aca90a#325-switch-expressions-preview
        // https://openjdk.org/jeps/325
        // switchの改善
        // 式になった
        String result = switch ("HOGE") {
            // 単一ケース内に複数条件を記載できるように
            // -> を使うとbreakが不要に
            case "HOGE", "hoge" -> {
                // ブロック作れるように
                var v = "hogehoge".toLowerCase();
                // 正確に言うとこれはJava13で決まったがyieldでブロックないから値を返せる
                // java12の段階だとbreakで返せたとのこと
                yield v;
            }
            case "fuga" -> "fugafuga";
            default -> "default";
        };
        System.out.println(result);
    }
}

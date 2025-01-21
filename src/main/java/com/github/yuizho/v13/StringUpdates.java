package com.github.yuizho.v13;

public class StringUpdates {
    public static void main(String... args) {
        // text block用のメソッドが追加されている

        // https://docs.oracle.com/javase/jp/13/docs/api/java.base/java/lang/String.html#formatted(java.lang.Object...)
        // text block関連の仕様なので、13だとDeprecatedで入っているとのこと
        System.out.println(
          "hello %s さん".formatted("world")
        );

        // https://docs.oracle.com/javase/jp/13/docs/api/java.base/java/lang/String.html#translateEscapes()
        System.out.println(
          "hoge\\nfuga\\n".translateEscapes()
        );

        // https://docs.oracle.com/javase/jp/13/docs/api/java.base/java/lang/String.html#stripIndent()
        // んー以下の感じで書くと、stripIndentによって先頭の\tが取りのぞかれるかと思ったんだけどうまくいかない。
        var html = " <html>\n     <body>\n         <p>Hello, world</p>\n     </body>\n </html>\n";
        System.out.println(html.stripIndent());
    }
}

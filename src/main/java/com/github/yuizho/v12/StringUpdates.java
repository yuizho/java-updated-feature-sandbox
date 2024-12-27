package com.github.yuizho.v12;

public class StringUpdates {
    public static void main(String... args) {
        // https://docs.oracle.com/javase/jp/12/docs/api/java.base/java/lang/String.html#indent(int)
        System.out.println(
                "hoge\n" +
                        "fuga\n".indent(3) +
                        "piyo"
        );

        // https://docs.oracle.com/javase/jp/12/docs/api/java.base/java/lang/String.html#transform(java.util.function.Function)
        // 用法
        // https://qiita.com/nowokay/items/0e860819b6ffb1aca90a#stringtransformfunction
        var users = java.util.List.of(
                new User("hoge", 20),
                new User("fuga", 30),
                new User("piyo", 40)
        );
        // Stringの値を受けて、別のオブジェクトを返すsupplierを指定してやる感じ
        "hoge".transform(s -> users.stream()
                .filter(user -> user.name.equals(s))
                .findFirst()
        ).ifPresent(System.out::println);
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

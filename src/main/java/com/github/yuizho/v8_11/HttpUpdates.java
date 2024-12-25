package com.github.yuizho.v8_11;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUpdates {
    public static void main(String... args) throws IOException, InterruptedException {
        // https://openjdk.org/groups/net/httpclient/intro.html
        // https://docs.oracle.com/javase/jp/11/docs/api/java.net.http/java/net/http/HttpClient.html
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(java.time.Duration.ofSeconds(20))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create("https://yuizho.dev"))
                .build();
        // 同期
        System.out.println("================== 同期 ==================");
        HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        // 非同期
        System.out.println("================== 非同期 ==================");
        client.sendAsync(request, java.net.http.HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}

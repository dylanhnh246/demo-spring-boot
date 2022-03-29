package com.example.demo;

import okhttp3.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"messages\": [\r\n        {\r\n            \"from\": \"ShinhanLife\",\r\n            \"destinations\": [\r\n                {\r\n                    \"to\": \"84987992246\"\r\n                }\r\n            ],\r\n            \"text\": \"This is a sample message\"\r\n        }\r\n    ]\r\n}");
        Request request = new Request.Builder()
                .url("https://ejyjkq.api.infobip.com/sms/2/text/advanced")
                .method("POST", body)
                .addHeader("Authorization", "App af2e84c21de9952501096ba78ad527a5-847f45d0-83be-4683-9ebe-16ea89d2b0ef")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String temp = response.body().string();
    }
}

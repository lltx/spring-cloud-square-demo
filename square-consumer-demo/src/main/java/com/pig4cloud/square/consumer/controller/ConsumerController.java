package com.pig4cloud.square.consumer.controller;

import com.pig4cloud.square.consumer.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ConsumerController {

    private final OkHttpClient.Builder builder;

    private final DemoService demoService;

    @SneakyThrows
    @GetMapping
    public String req() {
        Request request = new Request.Builder()
                .url("http://square-provider/req").build();
        Response response = builder.build().newCall(request).execute();
        return response.body().string();
    }


    @SneakyThrows
    @GetMapping("/retrofit")
    public String retrofit(){
        return demoService.req();
    }

}

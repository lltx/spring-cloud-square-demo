package com.pig4cloud.square.consumer.service;

import org.springframework.cloud.square.retrofit.core.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;

@RetrofitClient("square-provider")
public interface DemoService {

    @GET("/")
    Call<String> req();
}

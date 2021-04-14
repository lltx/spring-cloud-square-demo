package com.pig4cloud.square.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.square.retrofit.EnableRetrofitClients;

@EnableRetrofitClients
@SpringBootApplication
public class SquareConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquareConsumerDemoApplication.class, args);
	}

}

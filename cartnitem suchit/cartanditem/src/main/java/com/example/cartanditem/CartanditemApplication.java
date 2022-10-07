package com.example.cartanditem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CartanditemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartanditemApplication.class, args);
	}

}

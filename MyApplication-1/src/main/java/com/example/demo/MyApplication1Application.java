package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/* (exclude={DataSourceAutoConfiguration.class}) */
@SpringBootApplication
public class MyApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication1Application.class, args);
		
	
	}

}
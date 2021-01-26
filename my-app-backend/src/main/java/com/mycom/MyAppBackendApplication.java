package com.mycom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MyAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppBackendApplication.class, args);
	}
}

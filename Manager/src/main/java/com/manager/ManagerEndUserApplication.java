package com.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.manager.feignclient")
public class ManagerEndUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerEndUserApplication.class, args);
	}

}

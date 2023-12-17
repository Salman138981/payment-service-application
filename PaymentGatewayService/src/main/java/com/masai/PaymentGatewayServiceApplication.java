package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;


@SpringBootApplication
public class PaymentGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayServiceApplication.class, args);
	}

}

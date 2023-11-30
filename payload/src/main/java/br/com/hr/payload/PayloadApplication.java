package br.com.hr.payload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PayloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayloadApplication.class, args);
	}

}

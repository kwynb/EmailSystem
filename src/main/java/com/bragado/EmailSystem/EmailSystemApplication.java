package com.bragado.EmailSystem;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class EmailSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSystemApplication.class, args);
	}

}

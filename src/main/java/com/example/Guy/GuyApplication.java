package com.example.Guy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@SpringBootApplication
public class GuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuyApplication.class, args);
		System.out.println("Spring boot started");

	}

}

package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Example01Application {

	public static void main(String[] args) {
		SpringApplication.run(Example01Application.class, args);
		System.out.println("Kalpa");
	}
@Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
}
}

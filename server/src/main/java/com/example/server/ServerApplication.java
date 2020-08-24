package com.example.server;

import com.example.server.Entity.*;
import com.example.server.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.stream.Stream;

@CrossOrigin(origins = "*")
@SpringBootApplication
public class ServerApplication{
	private static final Logger logger = LoggerFactory.getLogger(ServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);

		System.out.println("\t\t\t\t---- <-IS RUNNING-> ----\n");

	}
	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
}


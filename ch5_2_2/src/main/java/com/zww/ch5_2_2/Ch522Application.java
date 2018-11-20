package com.zww.ch5_2_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Ch522Application {
	@Value("${book.name}")
	String bookName;
	
	@Value("${book.author}")
	String bookAuthor;
	
	@RequestMapping("/")
	String index() {
		System.out.println("bookName:" + bookName +" bookAuthor:" + bookAuthor);
		return "Hello Spring Boot";
	}
	public static void main(String[] args) {
		SpringApplication.run(Ch522Application.class, args);
	}
}

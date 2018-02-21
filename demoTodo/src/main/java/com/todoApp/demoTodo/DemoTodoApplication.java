package com.todoApp.demoTodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan({"com.todoApp.demoTodo.resource","com.todoApp.demoTodo.service","com.todoApp.demoTodo.repository"})
public class DemoTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTodoApplication.class, args);
	}
}

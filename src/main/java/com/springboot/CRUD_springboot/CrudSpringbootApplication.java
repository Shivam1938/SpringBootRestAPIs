package com.springboot.CRUD_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = DataSourceAutoConfiguration.class)
public class CrudSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootApplication.class, args);


	}
    
}

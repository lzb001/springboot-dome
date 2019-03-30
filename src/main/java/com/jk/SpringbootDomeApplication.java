package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jk.dao,com.jk.mongodao")
public class SpringbootDomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDomeApplication.class, args);
	}

}

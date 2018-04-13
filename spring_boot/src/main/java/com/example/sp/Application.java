package com.example.sp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sp.mapper")//扫描
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

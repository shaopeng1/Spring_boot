package com.example.sp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //缓存策略
@MapperScan("com.example.sp.mapper")//扫描
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

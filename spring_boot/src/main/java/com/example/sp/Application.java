package com.example.sp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching //缓存策略
@EnableScheduling//开启定时任务
//@EnableEurekaServer
@MapperScan("com.example.sp.mapper")//扫描
public class Application { 

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

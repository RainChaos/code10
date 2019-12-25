package com.jiapeng.messageplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = {"com.jiapeng.messageplatform.dao"})
@EnableTransactionManagement
public class MessagePlatformApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(MessagePlatformApplication.class, args);
	}




}

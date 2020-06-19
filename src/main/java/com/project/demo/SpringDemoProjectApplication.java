package com.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


import com.project.demo.model.Employee;

@SpringBootApplication
@EnableCaching
public class SpringDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoProjectApplication.class, args);
	}

}

/*@Bean
JedisConnectionFactory jedisconnectionFactory() {
	return new JedisConnectionFactory();
}

@Bean
RedisTemplate<String, Employee> redisTemplate(){
	RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<String, Employee>();
	redisTemplate.setConnectionFactory(jedisconnectionFactory());
	return redisTemplate;
}*/
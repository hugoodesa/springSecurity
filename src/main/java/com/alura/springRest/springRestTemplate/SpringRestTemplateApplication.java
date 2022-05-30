package com.alura.springRest.springRestTemplate;

import javax.persistence.Cacheable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@Cacheable
public class SpringRestTemplateApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringRestTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String encode = new BCryptPasswordEncoder().encode("654321");
//		System.out.println("senha criptografada :"+encode);
	}

}

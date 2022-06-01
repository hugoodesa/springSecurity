package br.com.alura.springSecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport
@EnableWebSecurity

public class SpringSecurityExercicioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExercicioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String encode = new BCryptPasswordEncoder().encode("abc@123");
//		System.out.println("Encode : "+encode);
	}

}

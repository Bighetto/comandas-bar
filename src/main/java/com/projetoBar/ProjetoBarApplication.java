package com.projetoBar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableJpaRepositories
public class ProjetoBarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBarApplication.class, args);
	}

}

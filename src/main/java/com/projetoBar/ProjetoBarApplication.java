package com.projetoBar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableSpringDataWebSupport
@EnableCaching
@EnableJpaRepositories
@EnableSwagger2
public class ProjetoBarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBarApplication.class, args);
	}

}

package com.vehicule.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.vehicule.manage.models")
@EnableJpaRepositories("com.vehicule.manage.repositories")
public class ManageApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ManageApplication.class, args);
	}

}

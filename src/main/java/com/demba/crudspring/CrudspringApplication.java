package com.demba.crudspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.demba.crudspring.model.User;

@SpringBootApplication
public class CrudspringApplication implements CommandLineRunner {


//@Autowired
//private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CrudspringApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//restConfiguration.exposeIdsFor(User.class);
	}
}

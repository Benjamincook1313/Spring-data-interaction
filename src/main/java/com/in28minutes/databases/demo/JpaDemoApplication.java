package com.in28minutes.databases.demo;

import com.in28minutes.databases.demo.entity.Person;
import com.in28minutes.databases.demo.jdbc.PersonJdbcDao;
import com.in28minutes.databases.demo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info( "User id 2 -> {}", repository.findById(1));
		logger.info( "Inserting User data -> {}",
				repository.insert(new Person("Kambri", "Cottonwood Heights", "2008-09-04")));

		logger.info( "Update User data -> {}",
				repository.update(new Person(3, "Hunter", "Cottonwood Heights", "2007-05-15")));

		repository.deleteById(2);

		logger.info("All users -> {}", repository.findAll());

	}
}

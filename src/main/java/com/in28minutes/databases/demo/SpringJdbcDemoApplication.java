package com.in28minutes.databases.demo;

import com.in28minutes.databases.demo.entity.Person;
import com.in28minutes.databases.demo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info( "All users -> {}", dao.findAll());
		logger.info( "User id 2 -> {}", dao.findById(2));

//		logger.info( "Delete User 3 -> num of rows deleted - {}", dao.deleteById(3));
//		logger.info( "All users -> {}", dao.findAll());

		logger.info( "Inserting User data -> {}",
				dao.insert(new Person(null, "Kambri", "Cottonwood Heights", "2008-09-04")));

		logger.info( "Update User data -> {}",
				dao.update(new Person(3, "Hunter", "Cottonwood Heights", "2007-05-15")));

		logger.info( "All users -> {}", dao.findAll());

	}
}

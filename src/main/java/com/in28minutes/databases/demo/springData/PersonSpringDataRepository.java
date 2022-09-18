package com.in28minutes.databases.demo.springData;

import com.in28minutes.databases.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}

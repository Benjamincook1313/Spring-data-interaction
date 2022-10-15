package com.in28minutes.databases.demo.springData;

import com.in28minutes.databases.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA - dataDemoApplication uses this Repository
// Auto configures delete, and findById methods; uses ".save" for inserting and updating
// with the springframework JpaRepository
public interface PersonSpringDataRepository
    extends JpaRepository<Person, Integer> {

}

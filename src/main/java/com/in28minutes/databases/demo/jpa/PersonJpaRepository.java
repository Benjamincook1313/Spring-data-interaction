package com.in28minutes.databases.demo.jpa;

import com.in28minutes.databases.demo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // interacts with the DB
@Transactional // Transaction management
public class PersonJpaRepository {
  @PersistenceContext //  connects to the database
  EntityManager entityManager; // Maps the Entity to the in-memory DB implements PersistenceContext interface

  public List<Person> findAll(){
    TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
    return namedQuery.getResultList();
  }


  public Person findById(int id){
    // finds row in table by the id
    return entityManager.find(Person.class, id); //JPA
  }

  public Person update(Person person){
//    .merge will check if there is an id and update it if there is otherwise it adds data with a new Id
    return entityManager.merge(person);
  }

  public Person insert(Person person){
    // same things as the update method above
    return entityManager.merge(person);
  }

  public void deleteById(int id){
    // get person by id
    Person person = findById(id);
    // removes person from the database
    entityManager.remove(person);
  }

}

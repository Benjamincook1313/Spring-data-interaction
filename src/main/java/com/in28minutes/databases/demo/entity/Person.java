package com.in28minutes.databases.demo.entity;

import jakarta.persistence.*;

//import java.util.Date;
@Entity
//@Table(name="person")
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
  @Id
  @GeneratedValue
  private Integer id;

//  @Column(name="name")
  private String name;
  private String location;
  private String birthDate;

  public Person(){}

  public Person(Integer id, String name, String location, String birthDate) {
    super();
    this.id = id;
    this.name = name;
    this.location = location;
    this.birthDate = birthDate;
  }

//  Using Hibernate to Generate an id
  public Person(String name, String location, String birthDate) {
    super();
    this.name = name;
    this.location = location;
    this.birthDate = birthDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return "\nPerson{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", location='" + location + '\'' +
        ", birthDate=" + birthDate +
        '}';
  }
}

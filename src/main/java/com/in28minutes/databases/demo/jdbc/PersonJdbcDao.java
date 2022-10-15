package com.in28minutes.databases.demo.jdbc;

import com.in28minutes.databases.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDao {
  @Autowired
  JdbcTemplate jdbcTemplate;


//  Custom Row Mapper
//  create inner class that uses the RowMapper interface
  class PersonRowMapper implements RowMapper<Person> {

//    implementing RowMapper methods
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
      Person person = new Person();

      person.setId(rs.getInt("id"));
      person.setName(rs.getString("name"));
      person.setLocation(rs.getString("location"));
      person.setBirthDate(rs.getString("birth_date"));

      return person;
    }

  }

//  SELECT * FROM person, uses "query"
  public List<Person> findAll() {
    return jdbcTemplate.query("select * from person",
        new PersonRowMapper());
  }

//  select person by an id, uses "queryForObject"
  public Person findById(int id) {
    return jdbcTemplate.queryForObject(
        "select * from person " +
            "where id=?", new Object[]{id},
        new BeanPropertyRowMapper<Person>(Person.class));
  }

//  delete person by id, uses "update", takes in QUERY STRING and an OBJECT ARRAY
  public int deleteById(int id) {
    return jdbcTemplate.update("delete from person " +
            "where id=?",
        new Object[]{id});
  }

//  insert into db, uses "update", takes in QUERY STRING
  public int insert(Person person) {
    return jdbcTemplate.update("insert into person (name, location, birth_date) " +
            "values(?,?,?) ",
        new Object[]{person.getName(), person.getLocation(), person.getBirthDate()});
  }

//  update by id, uses "update", takes in QUERY STRING and an OBJECT ARRAY
  public int update(Person person) {
    return jdbcTemplate.update("update person " +
            "set name=?, location=?, birth_date=? " +
            "where id=?",
        new Object[]{
            person.getName(),
            person.getLocation(),
            person.getBirthDate(),
            person.getId()
        });
  }
}

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

  class PersonRowMapper implements RowMapper<Person> {

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

//  SELECT * FROM person
  public List<Person> findAll() {
    return jdbcTemplate.query("select * from person",
        new PersonRowMapper());
  }

  public Person findById(int id) {
    return jdbcTemplate.queryForObject(
        "select * from person " +
            "where id=?", new Object[]{id},
        new BeanPropertyRowMapper<Person>(Person.class));
  }

  public int deleteById(int id) {
    return jdbcTemplate.update("delete from person " +
            "where id=?",
        new Object[]{id});
  }

  public int insert(Person person) {
    return jdbcTemplate.update("insert into person (name, location, birth_date) " +
            "values(?,?,?) ",
        new Object[]{person.getName(), person.getLocation(), person.getBirthDate()});
  }

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

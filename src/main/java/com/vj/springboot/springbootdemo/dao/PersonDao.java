package com.vj.springboot.springbootdemo.dao;

import com.vj.springboot.springbootdemo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectALlPeople();

    int updatePersonById(UUID id, Person person);

    int deleteById(UUID id);

    Optional<Person>  selectPersonById(UUID id);

}

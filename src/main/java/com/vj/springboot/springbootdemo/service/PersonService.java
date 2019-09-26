package com.vj.springboot.springbootdemo.service;

import com.vj.springboot.springbootdemo.dao.PersonDao;
import com.vj.springboot.springbootdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private final PersonDao personDao;

    public PersonService(@Qualifier("fakedao") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectALlPeople();
    }

}

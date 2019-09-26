package com.vj.springboot.springbootdemo.api;

import com.vj.springboot.springbootdemo.model.Person;
import com.vj.springboot.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPerson(){
       return personService.getAllPeople();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @GetMapping(path = "/{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }
}

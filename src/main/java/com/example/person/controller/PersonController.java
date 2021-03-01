package com.example.person.controller;

import com.example.person.entity.Person;
import com.example.person.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/")
    public Person addPerson(@RequestBody Person person){
        log.info("Inside addPerson method of PersonController");
        return personService.addPerson(person);
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable("id") Long id){
        log.info("Inside findPersonById method of PersonController");
        return personService.findPersonById(id);
    }

    @GetMapping("")
    public List<Person> listPerson(){
        log.info("Inside listPerson method of PersonController");
        return  personService.findPersonList();
    }

    @GetMapping("/count")
    public long countPerson(){
        log.info("Inside countPerson method of PersonController");
        return  personService.countPerson();
    }

    @PutMapping("/update")
    public Person editPerson(@RequestBody Person person){
        log.info("Inside editPerson method of PersonController");
        return personService.editPerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePersonById(id);
    }
}

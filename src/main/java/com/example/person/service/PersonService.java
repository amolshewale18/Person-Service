package com.example.person.service;

import com.example.person.entity.Person;
import com.example.person.repository.PersonRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRespository personRespository;

    public Person addPerson(Person person){
        log.info("Inside addPerson method of PersonService");
        return personRespository.save(person);
    }

    public Person findPersonById(Long id) {
        log.info("Inside findPersonById method of PersonService");
        return personRespository.findPersonById(id);
    }

    public List<Person> findPersonList() {
        log.info("Inside findPersonList method of PersonService");
        return personRespository.findAll();
    }

    public long countPerson() {
        log.info("Inside countPerson method of PersonService");
        return  personRespository.count();
    }

    public Person editPerson(Person person) {
        log.info("Inside editPerson method of PersonService");
        Person dbo = personRespository.findPersonById(person.getId());
        //Person vo = new Person();
        dbo.setFirstName(person.getFirstName());
        dbo.setSurname(person.getSurname());
        return personRespository.save(dbo);
    }

    public void deletePersonById(Long id) {
        log.info("Inside deletePersonById method of PersonService");
        personRespository.deleteById(id);
    }
}

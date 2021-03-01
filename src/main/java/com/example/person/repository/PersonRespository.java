package com.example.person.repository;

import com.example.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends JpaRepository<Person, Long> {

    Person findPersonById(Long id);
}

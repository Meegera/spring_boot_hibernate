package com.homework.hw_hibernate.controller;

import com.homework.hw_hibernate.entity.Person;
import com.homework.hw_hibernate.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    final Repository repository;
    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getByCity(@RequestParam("city") String city){
        return repository.getPersonsByCity(city);
    }
}

package com.homework.hw_hibernate.controller;

import com.homework.hw_hibernate.entity.Person;
import com.homework.hw_hibernate.repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class Controller {

    final Repository repository;
    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Person> getByCity(@RequestParam("city") String city){
        return repository.findByCityOfLiving(city);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> getByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return repository.findByUserInfoNameAndUserInfoSurname(name, surname);
    }
    @GetMapping("/by-age")
    public List<Person> getByAge(@RequestParam("age") int age){
        return repository.findByUserInfoAgeLessThan(age);
    }
    @GetMapping("/")
    public List<Person> getAll(){
        return repository.findAll();
    }

    @PostMapping("/save")
    public Optional<Person> save(@RequestBody Person person){
        return Optional.of(repository.save(person));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Person person){
        repository.delete(person);
    }

}

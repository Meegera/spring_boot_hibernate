package com.homework.hw_hibernate.controller;

import com.homework.hw_hibernate.entity.Person;
import com.homework.hw_hibernate.repository.Repository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Secured({"ROLE_READ"})
    @GetMapping("/by-city")
    public List<Person> getByCity(@RequestParam("city") String city){
        return repository.findByCityOfLiving(city);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> getByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return repository.findByUserInfoNameAndUserInfoSurname(name, surname);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/by-age")
    public List<Person> getByAge(@RequestParam("age") int age){
        return repository.findByUserInfoAgeLessThan(age);
    }
    @GetMapping("/all")
    public List<Person> getAll(){
        return repository.findAll();
    }

    @PreAuthorize("#username = authentication.principal.username")
    @PostMapping("/save")
    public Optional<Person> save(@RequestBody Person person, @RequestParam String username){
        return Optional.of(repository.save(person));
    }

    @PreAuthorize("hasAnyRole('ROLE_DELETE', 'ROLE_WRITE')")
    @DeleteMapping("/delete")
    public void delete(@RequestBody Person person){
        repository.delete(person);
    }

}

package com.homework.hw_hibernate.repository;

import com.homework.hw_hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    final String select = "from Person ";

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city){
        List<Person> persons = entityManager.createQuery(select, Person.class).getResultList();
        return persons.stream()
                .filter(x -> x.getCityOfLiving().toLowerCase().equals(city.toLowerCase()))
                .collect(Collectors.toList());
    }
}

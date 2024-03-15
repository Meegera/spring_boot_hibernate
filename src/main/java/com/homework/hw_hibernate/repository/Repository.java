package com.homework.hw_hibernate.repository;

import com.homework.hw_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, Long> {

     List<Person> findByCityOfLiving(String city);

     List<Person> findByUserInfoAgeLessThan(int age);

    Optional<Person> findByUserInfoNameAndUserInfoSurname(String name, String surname);
}

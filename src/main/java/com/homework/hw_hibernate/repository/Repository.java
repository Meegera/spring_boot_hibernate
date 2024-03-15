package com.homework.hw_hibernate.repository;

import com.homework.hw_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, Long> {

     @Query(value = "select p from Person p where p.cityOfLiving = :city")
     List<Person> findByCityOfLivingJPQL(String city);

     @Query(value = "select p from Person p where p.userInfo.age < :age")
     List<Person> findByUserInfoAgeLessThanJPQL(int age);

     @Query(value = "select p from Person p where p.userInfo.name = :name AND p.userInfo.surname = :surname")
    Optional<Person> findByUserInfoNameAndUserInfoSurnameJPQL(String name, String surname);
}

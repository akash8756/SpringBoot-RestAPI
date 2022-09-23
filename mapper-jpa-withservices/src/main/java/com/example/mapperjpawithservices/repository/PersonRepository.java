package com.example.mapperjpawithservices.repository;

import com.example.mapperjpawithservices.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

package com.example.serverdemo.repository;

import com.example.serverdemo.domain.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}

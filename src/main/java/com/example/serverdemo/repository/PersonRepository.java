package com.example.serverdemo.repository;

import com.example.serverdemo.domain.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}

package com.example.serverdemo.controller;

import com.example.serverdemo.controller.base.BaseController;
import com.example.serverdemo.domain.entity.Person;
import com.example.serverdemo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PersonController extends BaseController {
    private final PersonRepository personRepository;

    @PutMapping("person")
    public void save(@Valid @RequestBody Person person) {
        personRepository.save(person);
    }

    @GetMapping("person/{id}")
    public Person get(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @GetMapping("person")
    public Page<Person> get(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}

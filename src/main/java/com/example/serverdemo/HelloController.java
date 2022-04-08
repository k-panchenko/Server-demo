package com.example.serverdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {
    @GetMapping("hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return String.join(" ", "Hello ", name);
    }
}

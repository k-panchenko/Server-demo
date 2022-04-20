package com.example.serverdemo.controller;

import com.example.serverdemo.controller.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController extends BaseController {
    @GetMapping("hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return String.join(" ", "Hello ", name);
    }
}

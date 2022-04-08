package com.example.serverdemo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TokenizerController {
    @PostMapping("tokenize")
    public Map<String, Integer> tokenize(@RequestBody String str) {
        return Arrays.stream(str.split("\\s+")).collect(Collectors.groupingBy(
                s -> s.replaceAll("[^\\w]", ""),
                Collectors.summingInt(__ -> 1)
        ));
    }
}

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
    public Map<String, Integer> tokenize(@RequestBody Request str) {
        var map = Arrays.stream(str.getText().split("\\s+")).collect(Collectors.groupingBy(
                s -> s.replaceAll("[^\\w]", "").toLowerCase(),
                Collectors.summingInt(__ -> 1)
        ));
        map.remove("");
        return map;
    }
}

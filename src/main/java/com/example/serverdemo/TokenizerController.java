package com.example.serverdemo;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TokenizerController {
    @PostMapping("tokenize")
    public Map<String, Integer> tokenize(@Validated @RequestBody Request str) {
        var map = Arrays.stream(str.getText().split("\\s+")).collect(Collectors.groupingBy(
                s -> s.replaceAll("[^\\w]", "").toLowerCase(),
                Collectors.summingInt(__ -> 1)
        ));
        map.remove("");
        return map;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream().findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Unknown error");
    }
}

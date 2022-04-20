package com.example.serverdemo.controller;

import com.example.serverdemo.controller.base.BaseController;
import com.example.serverdemo.domain.request.TokenizeRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TokenizerController extends BaseController {
    @PostMapping("tokenize")
    public Map<String, Integer> tokenize(@Valid @RequestBody TokenizeRequest str) {
        var response = Arrays.stream(str.getText().split("\\s+")).collect(Collectors.groupingBy(
                s -> s.replaceAll("[^\\w]", "").toLowerCase(),
                Collectors.summingInt(__ -> 1)
        ));
        response.remove("");
        return response;
    }
}

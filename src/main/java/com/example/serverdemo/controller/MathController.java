package com.example.serverdemo.controller;

import com.example.serverdemo.controller.base.BaseController;
import com.example.serverdemo.domain.request.DivisionRequest;
import com.example.serverdemo.domain.response.DivisionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static java.math.BigDecimal.ZERO;

@RestController
public class MathController extends BaseController {
    @PostMapping("math/divide")
    public DivisionResponse divide(@Valid @RequestBody DivisionRequest request) {
        if (request.getDivisor().equals(ZERO.doubleValue()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dividing by zero");
        return new DivisionResponse(request.getDividend() / request.getDivisor());
    }
}

package com.example.serverdemo.domain.response;

import lombok.Value;

import java.util.List;

@Value
public class ErrorResponse {
    List<String> errors;
}

package com.example.serverdemo.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DivisionRequest {
    @NotNull
    private Double dividend;
    @NotNull
    private Double divisor;
}

package com.example.serverdemo.domain.request;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TokenizeRequest {
    @NotNull
    private String text;
}

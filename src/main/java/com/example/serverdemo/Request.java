package com.example.serverdemo;


import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Request {
    @NotNull(message = "Text is null")
    private String text;

    public Request() {
        text = null;
    }

    public String getText() {
        return text;
    }

    public Request setText(String text) {
        this.text = text;
        return this;
    }
}

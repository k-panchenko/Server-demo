package com.example.serverdemo;


public class Request {
    private String text;

    public String getText() {
        return text;
    }

    public Request setText(String text) {
        this.text = text;
        return this;
    }
}

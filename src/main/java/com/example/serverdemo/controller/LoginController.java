package com.example.serverdemo.controller;

import com.example.serverdemo.controller.base.BaseController;
import com.example.serverdemo.domain.request.LoginRequest;
import com.example.serverdemo.domain.response.LoginResponse;
import com.example.serverdemo.statics.AuthorizationStatics;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class LoginController extends BaseController {
    @PostMapping("login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        if (!request.getLogin().equals("alex") && !request.getPassword().equals("pass"))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return new LoginResponse(AuthorizationStatics.TOKEN);
    }
}

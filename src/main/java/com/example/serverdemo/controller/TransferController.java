package com.example.serverdemo.controller;

import com.example.serverdemo.domain.request.TransferRequest;
import com.example.serverdemo.domain.response.TransferResponse;
import com.example.serverdemo.service.api.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("transfer")
public class TransferController implements TransferService {
    private final TransferService transferServiceImpl;


    @Override
    @PostMapping
    @ResponseBody
    public TransferResponse createTransfer(@RequestBody @Valid TransferRequest transferRequest) {
        return transferServiceImpl.createTransfer(transferRequest);
    }
}

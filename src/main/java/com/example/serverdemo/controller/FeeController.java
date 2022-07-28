package com.example.serverdemo.controller;

import com.example.serverdemo.domain.transfer.Network;
import com.example.serverdemo.service.api.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fee")
public class FeeController implements FeeService {
    private final FeeService feeServiceImpl;

    @Override
    @GetMapping
    @ResponseBody
    public Double getCommission(@RequestParam Network network) {
        return feeServiceImpl.getCommission(network);
    }
}

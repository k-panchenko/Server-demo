package com.example.serverdemo.service.api;

import com.example.serverdemo.domain.transfer.Network;

public interface FeeService {
    Double getCommission(Network network);
}

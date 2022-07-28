package com.example.serverdemo.service;

import com.example.serverdemo.domain.transfer.Network;
import com.example.serverdemo.service.api.FeeService;
import org.springframework.stereotype.Service;

@Service
public class FeeServiceImpl implements FeeService {
    @Override
    public Double getCommission(Network network) {
        switch (network) {
            case OMNI:
                return 15.;
            case ERC20:
                return 5.;
            case TRC20:
                return 1.;
            default:
                return 0.;
        }
    }
}

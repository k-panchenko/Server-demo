package com.example.serverdemo.service;

import com.example.serverdemo.domain.request.TransferRequest;
import com.example.serverdemo.domain.response.TransferResponse;
import com.example.serverdemo.domain.transfer.Status;
import com.example.serverdemo.service.api.FeeService;
import com.example.serverdemo.service.api.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final FeeService feeServiceImpl;

    @Override
    public TransferResponse createTransfer(TransferRequest transferRequest) {
        var fee = feeServiceImpl.getCommission(transferRequest.getNetwork());
        var amount = transferRequest.getAmount() - fee;
        var status = Status.SUCCESS;
        String error = null;
        if (amount <= 0) {
            status = Status.FAILED;
            error = "Filled amount <= 0";
        }
        return TransferResponse.builder()
                .commission(fee)
                .amount(amount)
                .status(status)
                .error(error)
                .build();
    }
}

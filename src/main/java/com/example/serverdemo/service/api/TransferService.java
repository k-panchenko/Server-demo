package com.example.serverdemo.service.api;

import com.example.serverdemo.domain.request.TransferRequest;
import com.example.serverdemo.domain.response.TransferResponse;

public interface TransferService {
    TransferResponse createTransfer(TransferRequest transferRequest);
}

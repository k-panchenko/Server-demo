package com.example.serverdemo.domain.response;

import com.example.serverdemo.domain.transfer.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferResponse {
    private Double amount;
    private Double commission;
    private Status status;
    private String error;
}

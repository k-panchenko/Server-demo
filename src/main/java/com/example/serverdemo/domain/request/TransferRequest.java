package com.example.serverdemo.domain.request;

import com.example.serverdemo.domain.transfer.Network;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TransferRequest {
    @DecimalMin("0.0")
    private Double amount;
    @NotNull
    private Network network;
    @NotEmpty
    private String address;
    @NotEmpty
    private String currency;
}

package com.example.serverdemo.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Person {
    @Id
    @Min(value = 1_000_000_000L, message = "TIN contains only 10 numbers")
    @Max(value = 9_999_999_999L, message = "TIN contains only 10 numbers")
    private Long tin;
    @NotBlank
    private String passportID;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
}

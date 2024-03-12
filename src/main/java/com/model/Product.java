package com.model;

import lombok.*;

import java.math.BigInteger;

@Data
//@Entity
public class Product {
    private String name;
    private int id;
    private BigInteger price;
    private String description;
    private int quantity;
}

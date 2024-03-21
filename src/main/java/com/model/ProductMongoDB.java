package com.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Random;

@Data
@Document(collection = "productinventory")
public class ProductMongoDB implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private Integer productId;
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
    private Status status;


    public enum Status {
        AVAILABLE, OUT_OF_STOCK, SOLD
    }


}

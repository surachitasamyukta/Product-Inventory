/*
package com.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.model.ProductMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryDynamoDB {

    @Autowired
    DynamoDBMapper mapper;

    public String add(ProductMongoDB product) {
        product.setCount(1);
        mapper.save(product);
        return "product added";
    }

    public ProductMongoDB getById(Integer id) {
        return mapper.load(ProductMongoDB.class, id.trim());
    }



    public List<ProductMongoDB> getProducts() {
        return mapper.scan(ProductMongoDB.class, new DynamoDBScanExpression());
    }



    public void delete(Integer id) {
        ProductMongoDB product = new ProductMongoDB();
        product.setId(id);
        mapper.delete(product);

    }
}
*/

package com.config.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    public static final String REGION = "ap-south-1";
    public static final String SERVICE_ENDPOINT = "dynamodb.ap-south-1.amazonaws.com";

    @Bean
    public DynamoDBMapper getDynamoDBMapper() {
        return new DynamoDBMapper(getAmazonDynamoDBMapper());
    }

    private AmazonDynamoDB getAmazonDynamoDBMapper() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("AKIAUMR7YQ26TRQW4WYT", "CYqaRyvZPJZUK636Oghrg8oVmAfttTAw7rRWfL2J")) {
                })
                .build();
    }
}

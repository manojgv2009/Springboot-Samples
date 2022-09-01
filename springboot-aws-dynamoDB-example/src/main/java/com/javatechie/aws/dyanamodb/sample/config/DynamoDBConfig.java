package com.javatechie.aws.dyanamodb.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {
	
	@Bean
	public DynamoDBMapper mapper() {
		
		return new DynamoDBMapper(dynamoDBConfig());
	}

	private AmazonDynamoDB dynamoDBConfig() {
		
		EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration("dynamodb.eu-north-1.amazonaws.com", "eu-north-1");
		
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(endpointConfiguration)
				.withCredentials(credentialsProvider).build();
	}

}

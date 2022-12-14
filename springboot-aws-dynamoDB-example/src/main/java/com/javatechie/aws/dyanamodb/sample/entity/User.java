package com.javatechie.aws.dyanamodb.sample.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "User")
public class User implements Serializable{
	
	@DynamoDBHashKey(attributeName = "userId")
	@DynamoDBAutoGeneratedKey
	private String userId;
	@DynamoDBAttribute
	private String name;
	@DynamoDBAttribute
	private int age;
	@DynamoDBAttribute
	private String emailId;
	@DynamoDBAttribute
	private Address address;

}

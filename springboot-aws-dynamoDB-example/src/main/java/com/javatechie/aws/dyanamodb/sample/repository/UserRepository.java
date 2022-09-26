package com.javatechie.aws.dyanamodb.sample.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.javatechie.aws.dyanamodb.sample.entity.User;

@Repository
public class UserRepository {

	@Autowired
	private DynamoDBMapper mapper;
	
	public User addUser(User user) {
		mapper.save(user);
		return user;
	}
	
	public User findUserByUserId(String userId) {
		return mapper.load(User.class, userId);
	}
	
	public String removeUser(User user) {
		mapper.delete(user);
		return "User Deleted Successfully";
	}
	
	public String updateUser(User user) {
		mapper.save(user, saveExpression(user));
		return "Data has been updated for the User - "+user.getUserId()+".";
	}
	
	private DynamoDBSaveExpression saveExpression(User user) {
		
		DynamoDBSaveExpression expression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("userId", new ExpectedAttributeValue(new AttributeValue().withS(user.getUserId())));
		expression.setExpected(expectedMap);
		return expression;
	}
}

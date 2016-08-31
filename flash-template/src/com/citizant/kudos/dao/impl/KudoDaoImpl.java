package com.citizant.kudos.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.citizant.kudos.dao.KudoDao;
import com.citizant.kudos.domain.Kudo;
import com.citizant.kudos.domain.User;

public class KudoDaoImpl extends BaseDaoImpl implements KudoDao {
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		@SuppressWarnings("rawtypes")
		PaginatedScanList result = mapper.scan(User.class, scanExpression);
		if(result!=null){
			@SuppressWarnings("rawtypes")
			Iterator its = result.iterator();
			while(its.hasNext()){
				users.add((User)its.next());
			}			
		}
		return users;	
	}

	@Override
	public User getUserByEmail(String email) {
		User user = mapper.load(User.class, email);
		return user;
	}
	
	@Override
	public List<Kudo> getAllKudos() {
		
		List<Kudo> kudos = new ArrayList<>();
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		@SuppressWarnings("rawtypes")
		PaginatedScanList result = mapper.scan(Kudo.class, scanExpression);
		if(result!=null){
			@SuppressWarnings("rawtypes")
			Iterator its = result.iterator();
			while(its.hasNext()){
				kudos.add((Kudo)its.next());
			}			
		}
		return kudos;
	}

}

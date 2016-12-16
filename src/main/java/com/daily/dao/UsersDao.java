package com.daily.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.daily.domain.Users;
import com.daily.repository.UsersRepository;

@Repository
public class UsersDao {
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Users getOne(String userName){
		Users userResult = usersRepository.findByUserName(userName);
		return userResult;
	}
	
}

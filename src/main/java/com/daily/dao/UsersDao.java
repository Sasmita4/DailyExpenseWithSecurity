package com.daily.dao;

import java.util.List;

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
	public List<Users> getAllUsers(){
		List<Users> userList = usersRepository.findAll();
		return userList;
	}
	public Users registerUser(Users users){
		Users users1 = usersRepository.save(users);
		return users1;
	}
	public Users getUserByKey(String key){
		Users result = usersRepository.findByActivationKey(key);
		return result;
	}
}

package com.daily.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.daily.domain.Users;

public interface UsersRepository extends MongoRepository<Users,String> {
	
	public Users findByUserName(String userName);

	public Users findByActivationKey(String key);
}

package com.daily.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daily.domain.Food;

@RepositoryRestResource
public interface FoodRepository extends MongoRepository<Food, String> {
	

}

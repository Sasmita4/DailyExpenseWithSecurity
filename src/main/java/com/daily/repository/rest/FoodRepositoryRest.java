package com.daily.repository.rest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daily.domain.Food;

@RepositoryRestResource(collectionResourceRel="food",path="foodUrl")
public interface FoodRepositoryRest extends MongoRepository<Food, String> {

}

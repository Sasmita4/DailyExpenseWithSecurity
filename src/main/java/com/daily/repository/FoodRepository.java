package com.daily.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.daily.domain.Food;

public interface FoodRepository extends MongoRepository<Food, String> {
}

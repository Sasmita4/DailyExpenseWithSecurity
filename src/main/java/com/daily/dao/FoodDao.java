package com.daily.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.daily.domain.Food;
import com.daily.repository.FoodRepository;

@Repository
public class FoodDao {

	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Food createFood(Food food){
		Food foodResult = foodRepository.save(food);
		return foodResult;
	}
	public List<Food> findAllFood(){
		List<Food> foodList = foodRepository.findAll();
		return foodList;
	}
	public void delete(String id){
		foodRepository.delete(id);
	}
	public Food getOne(String id){
		Food foodResult = foodRepository.findOne(id);
		return foodResult;
	}
	public List<Food> getFoodBetweenDate(Date startDate, Date endDate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("date").gte(startDate).lte(endDate));
		List<Food> result = mongoTemplate.find(query, Food.class);
		return result;
	}
}

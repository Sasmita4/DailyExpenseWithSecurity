package com.daily.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daily.domain.Food;
import com.daily.repository.FoodRepository;

@Repository
public class FoodDao {
	
	@Autowired
	FoodRepository foodRepository;
	
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
}

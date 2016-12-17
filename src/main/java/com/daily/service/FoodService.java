package com.daily.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dao.FoodDao;
import com.daily.domain.Food;
import com.daily.dto.FoodDto;
import com.daily.mapper.FoodMapper;

@Service
public class FoodService {
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	FoodMapper foodMapper;
	
	/* save food expense and return response entity*/
	public FoodDto saveFood(FoodDto foodDto){
		Food food = foodMapper.foodDtoToFood(foodDto);
		food = foodDao.createFood(food);
		FoodDto result = foodMapper.foodToFoodDto(food);
		return result;
		
	}
	/*delete one record*/
	public void deleteFood(String id){
		foodDao.delete(id);
	}
	
	/* find all food related info*/
    public List<FoodDto> getAllFood(){
       List<Food> result = foodDao.findAllFood();
       List<FoodDto> foodDtoList = new ArrayList<FoodDto>();
       for(Food food : result){
    	   FoodDto foodDto = foodMapper.foodToFoodDto(food);
    	   foodDtoList.add(foodDto);
       }
    	return foodDtoList;
    }
	public List<FoodDto> getFoodBetweenDate(Date startDate, Date endDate) {
		List<Food> result = foodDao.getFoodBetweenDate(startDate,endDate);
		List<FoodDto> foodList = new ArrayList<FoodDto>();
		for(Food food : result){
			FoodDto dto = foodMapper.foodToFoodDto(food);
			foodList.add(dto);
		}
		return foodList;
	}
	public FoodDto getFoodById(String id){
		Food result = foodDao.getOne(id);
		FoodDto foodDto=foodMapper.foodToFoodDto(result);
		return foodDto;
	}

}

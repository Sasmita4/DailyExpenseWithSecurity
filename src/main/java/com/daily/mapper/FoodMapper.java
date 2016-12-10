package com.daily.mapper;

import org.springframework.stereotype.Component;

import com.daily.domain.Food;
import com.daily.dto.FoodDto;

@Component
public class FoodMapper {

	public FoodDto foodToFoodDto(Food food){
    	FoodDto foodDto = new FoodDto();
    	if(food !=null){
    		try{
    		foodDto.setCategory(food.getCategory());
    		foodDto.setDescription(food.getDescription());
    		foodDto.setExpense(food.getExpense());
    		foodDto.setDate(food.getDate());
    	    }
    	catch(Exception ex){
    	   }
    	}
    	return foodDto;
    }
    public Food foodDtoToFood(FoodDto foodDto){
    	Food food = new Food();
    	if(foodDto!=null){
    		try{
    		food.setCategory(foodDto.getCategory());
    		food.setDescription(foodDto.getDescription());
    		food.setExpense(foodDto.getExpense());
    		food.setDate(foodDto.getDate());
    	    }
    	catch(Exception e){
    	}
       }
    	return food;
    }
}

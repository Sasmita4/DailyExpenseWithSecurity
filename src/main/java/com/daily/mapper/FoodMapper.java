package com.daily.mapper;

import org.springframework.stereotype.Component;

import com.daily.domain.Food;
import com.daily.dto.FoodDto;
import com.daily.util.DateConversionUtil;

@Component
public class FoodMapper {

	public FoodDto foodToFoodDto(Food food){
    	FoodDto foodDto = new FoodDto();
    	if(food !=null){
    		try{
    		foodDto.setCategory(food.getCategory());
    		foodDto.setDescription(food.getDescription());
    		foodDto.setExpense(food.getExpense());
    		foodDto.setId(food.getId());
    		foodDto.setDate(DateConversionUtil.dateToString(food.getDate()));
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
    		food.setId(foodDto.getId());
    	    food.setDate(DateConversionUtil.stringToDate(foodDto.getDate()));
    	    }
    	catch(Exception e){
    	}
       }
    	return food;
    }
}

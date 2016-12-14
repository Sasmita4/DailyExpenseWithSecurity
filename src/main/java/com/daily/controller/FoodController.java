package com.daily.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daily.dto.FoodDto;
import com.daily.service.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping(value = "/insertFood", method = RequestMethod.POST)
	public @ResponseBody void addFoodExpense(@RequestBody FoodDto foodDto) {
		try {
			System.out.println("food=="+foodDto.getDescription());
			foodDto.setEmail("rgangadhari@nisum.com");
			foodService.saveFood(foodDto);
	     } catch (Exception ex) {
		
		 }
	  }
		
	@RequestMapping(value = "/updateFood", method = RequestMethod.PUT)
	public @ResponseBody void updateFoodExpense(@RequestBody String id) {
		try {
			foodService.updateFood(id);
		 } catch (Exception ex) {
	  }
    }
	
	@RequestMapping(value = "/deleteFood", method = RequestMethod.DELETE)
	public @ResponseBody void deleteFoodExpense(@RequestBody String id) {
		try {
			foodService.deleteFood(id);
		 } catch (Exception ex) {
	  }
    }
	@RequestMapping(value = "/getAllFood", method = RequestMethod.GET)
	public @ResponseBody List<FoodDto> getAllFood() {
		List<FoodDto> foodList = new ArrayList<FoodDto>();
		try {
			foodList = foodService.getAllFood();
		 } catch (Exception ex) {
	  }
		return foodList;
    }

}

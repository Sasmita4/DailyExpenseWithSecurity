package com.daily.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily.dto.FoodDto;
import com.daily.service.FoodService;

@Controller
public class FoodController {
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping(value = "/insertFood", method = RequestMethod.POST)
	public @ResponseBody void addFoodExpense(@RequestBody FoodDto foodDto) {
		try {
			
			foodDto.setEmail("rgangadhari@nisum.com");
			foodService.saveFood(foodDto);
	     } catch (Exception ex) {
		ex.printStackTrace();
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
	public @ResponseBody void deleteFoodExpense(@RequestParam(value = "id", required = true) Long id) {
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
			 ex.printStackTrace();
	  }
		return foodList;
    }

}

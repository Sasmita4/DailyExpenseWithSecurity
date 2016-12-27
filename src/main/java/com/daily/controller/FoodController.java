package com.daily.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/insertFood", method = RequestMethod.POST)
	public @ResponseBody void addFoodExpense(@RequestBody FoodDto foodDto) {
		try {
			foodService.saveFood(foodDto);
	     } catch (Exception ex) {
		ex.printStackTrace();
		 }
	  }
		
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/updateFood", method = RequestMethod.PUT)
	public @ResponseBody void updateFoodExpense(@Valid @RequestBody FoodDto foodDto) {
		if(foodDto.getId() == null){
		   addFoodExpense(foodDto);
		}
			foodService.saveFood(foodDto);
    }
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/deleteFood", method = RequestMethod.DELETE)
	public @ResponseBody void deleteFoodExpense(@RequestParam(value = "id", required = true) String id) {
		try {
			foodService.deleteFood(id);
		 } catch (Exception ex) {
	  }
    }
	
	@PreAuthorize("hasRole('ROLE_USER')")
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
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/getFoodById", method = RequestMethod.GET)
	public @ResponseBody FoodDto getFoodById(@RequestParam(value = "id", required = true) String id) {
		FoodDto foodDto = null;
		try {
			foodDto = foodService.getFoodById(id);
		 } catch (Exception ex) {
			 ex.printStackTrace();
	  }
		return foodDto;
    }
}

package com.daily.food.Service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.daily.dao.FoodDao;
import com.daily.domain.Food;
import com.daily.dto.FoodDto;
import com.daily.mapper.FoodMapper;
import com.daily.service.FoodService;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceTest {
	@InjectMocks
	FoodService foodService;
	
	@Mock
	FoodDao foodDao;
	@Spy
	FoodMapper foodMapper=new FoodMapper();
	
	@Test
	public void saveFoodTest(){
		FoodDto foodDto=new FoodDto();
		foodDto.setCategory("online");
		foodDto.setExpense("100");
		Food food=foodMapper.foodDtoToFood(foodDto);
		when((foodDao).createFood(foodMapper.foodDtoToFood(foodDto))).thenReturn(food);
		foodService.saveFood(foodDto);
		
	}
	@Test
	public void deleteFoodTest(){
	String id="1";
	doNothing().when(foodDao).delete(Mockito.anyString());
		foodService.deleteFood(id);
		
	}
	@Test
	public void getAllFoodTest(){
		List<Food> li_food=new ArrayList<Food>();
		Mockito.when((foodDao).findAllFood()).thenReturn(li_food);
		foodService.getAllFood();
	
	}
	@Test
	public void getFoodbetweenDateTest(){
	Date startDate=new Date();
	Date endDate=new Date();
	List<Food> li_food=new ArrayList<Food>();
	Mockito.when((foodDao).getFoodBetweenDate(new Date(), new Date())).thenReturn(li_food);
	foodService.getFoodBetweenDate(startDate, endDate);
	
		
	}
	@Test
	public void getFoodByIdTest(){
		String id="11";
		Food food=new Food();
		Mockito.when((foodDao).getOne("1")).thenReturn(food);
		foodService.getFoodById(id);
		
		
	}
	

}

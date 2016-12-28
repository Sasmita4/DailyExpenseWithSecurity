package com.daily.food.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.daily.controller.FoodController;
import com.daily.dto.FoodDto;
import com.daily.service.FoodService;
import com.daily.util.MockTestUtil;

@RunWith(MockitoJUnitRunner.class)
public class FoodControllerTest {

	private MockMvc mockMvc;

	@Resource
	private List<HandlerExceptionResolver> webApplicationContext;
	
	@Mock
	FoodService foodService;
	
	@InjectMocks
	FoodController foodController = new FoodController();
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(foodController).setHandlerExceptionResolvers(webApplicationContext).build();
    }
	@Test
	public void addFoodTest() throws Exception{
		FoodDto foodDto=new FoodDto();
		foodDto.setEmail("rgangadhari@nisum.com");
		foodDto.setCategory("online");
		mockMvc.perform(post("/insertFood").contentType(MediaType.APPLICATION_JSON).content(MockTestUtil.convertToJsonFormat(new FoodDto()))).andExpect(status().isOk());
	}

	@Test
	public void deleteFoodTest() throws Exception{
		 String id = "1";
		 doNothing().when(foodService).deleteFood(id);
		 mockMvc.perform(delete("/deleteFood").param("id", "1")).andExpect(status().isOk());
	}

	@Test
	public void getAllFoodTest() throws Exception{
		FoodDto foodDto = new FoodDto();
		List<FoodDto> li_food = new ArrayList<>();
		foodDto.setExpense("900");
		li_food.add(foodDto);
		Mockito.when((foodService).getAllFood()).thenReturn(li_food);
		mockMvc.perform(get("/getAllFood").contentType(MediaType.APPLICATION_JSON).content(MockTestUtil.convertToJsonFormat(new FoodDto()))).andExpect(status().isOk());
	}

	@Test
	public void getFoodByIdTest() throws Exception{
		String foodId="1";
		FoodDto foodDto=new FoodDto();
		Mockito.when((foodService).getFoodById(foodId)).thenReturn(foodDto);
		mockMvc.perform(get("/getFoodById").param("id", "1")).andExpect(status().isOk());
	}
	
	
	
	
	
	
	
	
	
	
	

}

package com.daily.Miscellaneous.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.daily.controller.MiscellaneousController;
import com.daily.domain.Miscellaneous;
import com.daily.dto.MiscellaneousDto;
import com.daily.mapper.MiscellaneousMapper;
import com.daily.service.MiscellaneousService;
import com.daily.util.MockTestUtil;

@RunWith(MockitoJUnitRunner.class)
public class MiscellaneousControllerTest {
	Logger log = LoggerFactory.getLogger(MiscellaneousControllerTest.class);
	
	private static final String DEFAULT_ID = "1";
	private static final String DEFAULT_DESCRIPTION = "for gift purchase";
	private static final String DEFAULT_CATEGORY = "Online";
	private static final String DEFAULT_EXPENSE = "100";
	private static final String DEFAULT_EMAIL = "smaharana@nisum.com";
	private static final Date DEFAULT_DATE = new Date();
	
	
	private MockMvc mockMvc;
	
	private Miscellaneous miscellaneous;
	
	@Resource
	private List<HandlerExceptionResolver> webApplicationContext;
	
	@InjectMocks
	MiscellaneousController miscellaneousController;
	
	@InjectMocks
	MiscellaneousMapper miscellaneousMapper;
	
	@InjectMocks
	MiscellaneousService miscellaneousService;
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(miscellaneousController).setHandlerExceptionResolvers(webApplicationContext).build();
		miscellaneous = new Miscellaneous();
		miscellaneous.setId(DEFAULT_ID);
		miscellaneous.setDescription(DEFAULT_DESCRIPTION);
		miscellaneous.setCategory(DEFAULT_CATEGORY);
		miscellaneous.setExpense(DEFAULT_EXPENSE);
		miscellaneous.setEmail(DEFAULT_EMAIL);
		miscellaneous.setDate(DEFAULT_DATE);
	}
	
	@Test
	public void addMiscellaneousExpenseTest() throws Exception{
		MiscellaneousDto miscellaneousDto = miscellaneousMapper.miscellaneousToMiscellaneousDto(miscellaneous);
		mockMvc.perform(post("/insertMiscellaneous")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(MockTestUtil.convertToJsonFormat(miscellaneousDto)))
		       .andExpect(status().isOk());
	}
	
	@Test
	public void deleteMiscellaneousExpenseTest() throws Exception{
		doNothing().when(miscellaneousService).deleteMiscellaneous("1");
		mockMvc.perform(delete("/deleteMiscellaneous")
			   .param("id", "1")).andExpect(status().isOk());
	}

}

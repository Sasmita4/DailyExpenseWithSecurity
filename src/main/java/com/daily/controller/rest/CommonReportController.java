package com.daily.controller.rest;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.dto.FoodDto;
import com.daily.dto.MiscellaneousDto;
import com.daily.dto.SearchDto;
import com.daily.dto.TransportationDto;
import com.daily.service.FoodService;
import com.daily.service.MiscellaneousService;
import com.daily.service.TransportationService;
import com.daily.util.DailyExpenseConstants;
import com.daily.util.DateConversionUtil;

@RestController
@RequestMapping("/api")
public class CommonReportController {
	private final Logger log =LoggerFactory.getLogger(CommonReportController.class);
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	TransportationService transportationService;
	
	@Autowired
	MiscellaneousService miscellaneousService;
	
	/*for Getting reports based on date and type*/
    @RequestMapping(value = "/searchExpenses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
     public ResponseEntity<Object> expenseReport(@QueryParam("d1") String d1,@QueryParam("d2") String d2,@QueryParam("report") String report) throws URISyntaxException {
    	//String report = searchDto.getExpenseType();
    	Date startDate = DateConversionUtil.stringToDate(d1);
    	Date endDate = DateConversionUtil.stringToDate(d2);
    	if(DailyExpenseConstants.FOOD_REPORT.equals(report)){
    		List<FoodDto> foodList = foodService.getFoodBetweenDate(startDate,endDate);
    	}
    	else if(DailyExpenseConstants.MISCELLANEOUS_REPORT.equals(report)){
    		List<MiscellaneousDto> miscellaneousList = miscellaneousService.getMiscellaneousBetweenDate(startDate,endDate);
    	}
    	else{
    		List<TransportationDto> transportationList = transportationService.getTransportationBetweenDate(startDate,endDate);
    	}
		return new ResponseEntity<Object>(report, HttpStatus.OK);
    }
}

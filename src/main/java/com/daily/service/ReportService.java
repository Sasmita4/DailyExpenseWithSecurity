package com.daily.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dto.FoodDto;
import com.daily.dto.MiscellaneousDto;
import com.daily.dto.ReportResultDto;
import com.daily.dto.SearchDto;
import com.daily.dto.TransportationDto;
import com.daily.util.DailyExpenseConstants;
import com.daily.util.DateConversionUtil;

@Service
public class ReportService {
	 @Autowired
	 FoodService foodService;
	 
	 @Autowired
	 MiscellaneousService miscellaneousService;
	 
	 @Autowired
	 TransportationService transportationService;
	
	Logger log = LoggerFactory.getLogger(ReportService.class);
	public List<ReportResultDto> reportCommonService(SearchDto searchDto){
		String report = searchDto.getExpenseType();
    	Date startDate = DateConversionUtil.stringToDate(searchDto.getFromDate());
    	Date endDate = DateConversionUtil.stringToDate(searchDto.getToDate());
    	
    	List<ReportResultDto> dto = new ArrayList<ReportResultDto>();
    	
    	if(DailyExpenseConstants.FOOD_REPORT.equals(report)){
    		List<FoodDto> foodList = foodService.getFoodBetweenDate(startDate,endDate);
    		for(FoodDto foodDto : foodList){
    			ReportResultDto oneReport = new ReportResultDto();
    			oneReport.setCategory(foodDto.getCategory());
    			oneReport.setDescription(foodDto.getDescription());
    			oneReport.setExpense(foodDto.getExpense());
    			oneReport.setDate(foodDto.getDate());
    			
    			dto.add(oneReport);
    		}
    	}
    	else if(DailyExpenseConstants.MISCELLANEOUS_REPORT.equals(report)){
    		List<MiscellaneousDto> miscellaneousList = miscellaneousService.getMiscellaneousBetweenDate(startDate,endDate);
    		for(MiscellaneousDto miscellaneousDto : miscellaneousList){
    			ReportResultDto oneReport = new ReportResultDto();
    			oneReport.setCategory(miscellaneousDto.getCategory());
    			oneReport.setDescription(miscellaneousDto.getDescription());
    			oneReport.setExpense(miscellaneousDto.getExpense());
    			oneReport.setDate(miscellaneousDto.getDate());
    			
    			dto.add(oneReport);
    		}
    	}
    	else{
    		List<TransportationDto> transportationList = transportationService.getTransportationBetweenDate(startDate,endDate);
    		for(TransportationDto transportationDto : transportationList){
    			ReportResultDto oneReport = new ReportResultDto();
    			oneReport.setCategory(transportationDto.getCategory());
    			oneReport.setDescription(transportationDto.getDescription());
    			oneReport.setExpense(transportationDto.getExpense());
    			oneReport.setDate(transportationDto.getDate());
    			
    			dto.add(oneReport);
    		}
    	}
    	
		return dto;
	}

}

/*package com.daily.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily.dto.TransportationDto;
import com.daily.service.TransportationService;

@Controller
public class TransportationController {
	@Autowired
	TransportationService transportationService;
	
	@RequestMapping(value = "/insertTransportation", method = RequestMethod.POST)
	public @ResponseBody void addFoodExpense(@RequestBody TransportationDto transportationDto) {
		try {
			transportationService.saveTransportation(transportationDto);
	     } catch (Exception ex) {
		
		 }
	  }
		
	@RequestMapping(value = "/updateTransportation", method = RequestMethod.PUT)
	public @ResponseBody void updateFoodExpense(@RequestBody String id) {
		try {
			transportationService.updateTransportation(id);
		 } catch (Exception ex) {
	  }
    }
	
	@RequestMapping(value = "/deleteTransportation", method = RequestMethod.DELETE)
	public @ResponseBody void deleteFoodExpense(@RequestBody String id) {
		try {
			transportationService.deleteTransportation(id);
		 } catch (Exception ex) {
	  }
    }
	@RequestMapping(value = "/getAllTransportation", method = RequestMethod.GET)
	public @ResponseBody List<TransportationDto> getAllFood() {
		List<TransportationDto> transportationList = new ArrayList<TransportationDto>();
		try {
			transportationList = transportationService.getAllTransportation();
		 } catch (Exception ex) {
	  }
		return transportationList;
    }
	
}
*/
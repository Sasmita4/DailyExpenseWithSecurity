package com.daily.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily.dto.MiscellaneousDto;
import com.daily.service.MiscellaneousService;

@Controller
public class MiscellaneousController {

	@Autowired
	MiscellaneousService miscellaneousService;
	
	@RequestMapping(value = "/insertMiscellaneous", method = RequestMethod.POST)
	public @ResponseBody void addMiscellaneousExpense(@RequestBody MiscellaneousDto miscellaneousDto) {
		try {
			miscellaneousService.saveMiscellaneous(miscellaneousDto);
	     } catch (Exception ex) {
		
		 }
	  }
		
	@RequestMapping(value = "/updateMiscellaneous", method = RequestMethod.PUT)
	public @ResponseBody void updateMiscellaneousExpense(@RequestBody String id) {
		try {
			miscellaneousService.updateMiscellaneous(id);
		 } catch (Exception ex) {
	  }
    }
	
	@RequestMapping(value = "/deleteMiscellaneous", method = RequestMethod.DELETE)
	public @ResponseBody void deleteMiscellaneousExpense(@RequestBody String id) {
		try {
			miscellaneousService.deleteMiscellaneous(id);
		 } catch (Exception ex) {
	  }
    }
	@RequestMapping(value = "/getAllMiscellaneous", method = RequestMethod.GET)
	public @ResponseBody List<MiscellaneousDto> getAllMiscellaneous() {
		List<MiscellaneousDto> miscellaneousList = new ArrayList<MiscellaneousDto>();
		try {
			miscellaneousList = miscellaneousService.getMiscellaneous();
		 } catch (Exception ex) {
	  }
		return miscellaneousList;
    }
}

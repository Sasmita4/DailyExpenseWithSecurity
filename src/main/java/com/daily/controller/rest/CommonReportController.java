package com.daily.controller.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.daily.dto.ReportResultDto;
import com.daily.dto.SearchDto;
import com.daily.service.FoodService;
import com.daily.service.MiscellaneousService;
import com.daily.service.ReportService;
import com.daily.service.TransportationService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/api")
public class CommonReportController {
	private final Logger log =LoggerFactory.getLogger(CommonReportController.class);
	
	 Map<String,Object> parameterMap = new HashMap<String,Object>();
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	TransportationService transportationService;
	
	@Autowired
	MiscellaneousService miscellaneousService;
	
	@Autowired
	ReportService reportService;
	
	/*for Getting reports based on date and type*/
    @RequestMapping(value = "/searchExpenses", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
    //@PreAuthorize("#user.name == principal.name")
    @Transactional(readOnly = true)
     public @ResponseBody ModelAndView expenseReport(@Valid @RequestBody SearchDto searchDto,ModelAndView modelAndView,HttpServletResponse response) throws URISyntaxException {
    	log.info("> expenseReport()");
    	List<ReportResultDto> reportResult = reportService.reportCommonService(searchDto);
    	JRDataSource JRdataSource = new JRBeanCollectionDataSource(reportResult);
    	 parameterMap.put("datasource", JRdataSource);
    	 modelAndView = new ModelAndView("rpt_report", parameterMap);
    	 modelAndView.addObject("format", "pdf");
    	 response.setContentType("application/pdf");
         return modelAndView;
		//return new ResponseEntity<List<ReportResultDto>>(reportResult, HttpStatus.OK);
    }
    
    
}

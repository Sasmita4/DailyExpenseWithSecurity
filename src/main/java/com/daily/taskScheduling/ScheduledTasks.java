package com.daily.taskScheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.daily.dto.ReportResultDto;
import com.daily.dto.SearchDto;
import com.daily.service.FoodService;
import com.daily.service.ReportService;
import com.daily.util.DailyExpenseConstants;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	ReportService reportService;
	
	@Autowired
	FoodService foodService;

	Map<String, Object> parameterMap ;

	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() throws JRException, FileNotFoundException {
		log.info("> reportCurrentTime()");

		Calendar cal= Calendar.getInstance();
		SearchDto searchDto = new SearchDto();
		
		List<String> typesList = new ArrayList<String>();
		typesList.add(DailyExpenseConstants.FOOD_REPORT);
		typesList.add(DailyExpenseConstants.MISCELLANEOUS_REPORT);
		typesList.add(DailyExpenseConstants.TRANSPORTATION_REPORT);
		
		for(String type:typesList){
			searchDto.setExpenseType(type);
			searchDto.setFromDate("2016-10-31T18:30:00.000Z");
			searchDto.setToDate("2017-01-19T18:30:00.000Z");
		
		
		//int lastDate = cal.getActualMaximum(Calendar.DATE);
		//int firstDate = cal.getActualMinimum(Calendar.DATE);
		
//		searchDto.setExpenseType("food");
//		searchDto.setFromDate("2016-10-31T18:30:00.000Z");
//		searchDto.setToDate("2017-01-19T18:30:00.000Z");
		
		
		parameterMap = new HashMap<String, Object>();

		List<ReportResultDto> reportResult = reportService.reportCommonService(searchDto);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(reportResult);
		parameterMap.put("datasource", JRdataSource);
		/*
		 * modelAndView = new ModelAndView("rpt_report", parameterMap);
		 * modelAndView.addObject("format", "pdf");
		 * response.setContentType("application/pdf");
		 */

		JasperCompileManager
				.compileReportToFile("/POC/DailyExpenseTracker/src/main/resources/jasperreports/rpt_report.jrxml");
		// fills compiled report with parameters and a connection
		JasperPrint print = JasperFillManager.fillReport(
				"/POC/DailyExpenseTracker/src/main/resources/jasperreports/rpt_report.jasper", parameterMap,
				JRdataSource);
		// exports report to pdf
		
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
				new FileOutputStream("/POC/DailyExpenseTracker/src/main/resources/jasperreports/"+type+ System.currentTimeMillis() + ".pdf")); // your output
																	// goes here
		exporter.exportReport();
		}
		log.info("< reportCurrentTime()");
	}
}

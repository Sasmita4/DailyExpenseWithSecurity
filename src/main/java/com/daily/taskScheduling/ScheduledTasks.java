package com.daily.taskScheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	Map<String, Object> parameterMap;

	@Scheduled(cron ="0 0 1 * * *")
	public void reportCurrentTime() throws JRException, FileNotFoundException {
		
		log.info("> reportCurrentTime()");
		
		SearchDto searchDto = new SearchDto();
		List<String> typesList = new ArrayList<String>();
		typesList.add(DailyExpenseConstants.FOOD_REPORT);
		typesList.add(DailyExpenseConstants.MISCELLANEOUS_REPORT);
		typesList.add(DailyExpenseConstants.TRANSPORTATION_REPORT);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000'Z'");
		
		// to get first date and last date of the month
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		calendar2.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfMonth = calendar2.getTime();
		 
        Calendar calendar1 = Calendar.getInstance();  
        calendar1.setTime(new Date());  
        calendar1.add(Calendar.MONTH, 1);  
        calendar1.set(Calendar.DAY_OF_MONTH, 1);  
        calendar1.add(Calendar.DATE, -1);  
        Date lastDayOfMonth = calendar1.getTime();
	        
		//to generate reports based on report type
		for(String reportType:typesList){
			searchDto.setExpenseType(reportType);
			searchDto.setFromDate(sdf.format(firstDayOfMonth));
			searchDto.setToDate(sdf.format(lastDayOfMonth));
		
		parameterMap = new HashMap<String, Object>();

		List<ReportResultDto> reportResult = reportService.reportCommonService(searchDto);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(reportResult);
		parameterMap.put("datasource", JRdataSource);

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
				new FileOutputStream("/POC/DailyExpenseTracker/src/main/resources/jasperreports/"+reportType+ System.currentTimeMillis() + ".pdf")); // your output
																	// goes here
		exporter.exportReport();
		}
		log.info("< reportCurrentTime()");
	}
}

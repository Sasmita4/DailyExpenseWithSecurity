package com.daily.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateConversionUtil {
	private final static Logger log =LoggerFactory.getLogger(DateConversionUtil.class);
	
	/* Date to String conversion*/
	public static String dateToString(Date date){
		String dateStirng = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		try{
			dateStirng = dateFormat.format(date);
		}
		catch(Exception ex){
			log.info("Problem dateToString" +ex );
		}
		return dateStirng;
	}
  
	/*String to Date Conversion*/
	public static Date stringToDate(String date){
		Date finalDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		try {
			if(!date.isEmpty()&&date!=null){
			finalDate = dateFormat.parse(date);
			}
		} catch (Exception e) {
			log.info("Problem in stringToDate" +e);
		}
		return finalDate;
	}
	
	
}

package com.daily.mapper;

import org.springframework.stereotype.Component;

import com.daily.domain.Miscellaneous;
import com.daily.dto.MiscellaneousDto;
import com.daily.util.DateConversionUtil;

@Component
public class MiscellaneousMapper {
	
	 public MiscellaneousDto miscellaneousToMiscellaneousDto(Miscellaneous miscellaneous){
		 MiscellaneousDto miscellaneousDto = new MiscellaneousDto();
	    	if(miscellaneous !=null){
	    		try{
	    			miscellaneousDto.setId(miscellaneous.getId());
	    			miscellaneousDto.setCategory(miscellaneous.getCategory());
	    			miscellaneousDto.setDescription(miscellaneous.getDescription());
	    			miscellaneousDto.setExpense(miscellaneous.getExpense());
	    			miscellaneousDto.setEmail(miscellaneous.getEmail());
	    			miscellaneousDto.setDate(DateConversionUtil.dateToString(miscellaneous.getDate()));
	    	    }
	    	catch(Exception ex){
	    	   }
	    	}
	    	return miscellaneousDto;
	 }
	
	public Miscellaneous miscellaneousDtoToMiscellaneous(MiscellaneousDto miscellaneousDto){
		 Miscellaneous miscellaneous = new Miscellaneous();
	    	if(miscellaneousDto!=null){
	    		try{
	    			miscellaneous.setId(miscellaneousDto.getId());
	    			miscellaneous.setCategory(miscellaneousDto.getCategory());
	    			miscellaneous.setDescription(miscellaneousDto.getDescription());
	    			miscellaneous.setExpense(miscellaneousDto.getExpense());
	    			miscellaneous.setDate(DateConversionUtil.stringToDate(miscellaneousDto.getDate()));
	    	    }
	    	catch(Exception e){
	    	}
	       }
	    	return miscellaneous;
	 }
}

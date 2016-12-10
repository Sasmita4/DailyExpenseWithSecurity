package com.daily.mapper;

import org.springframework.stereotype.Component;

import com.daily.domain.Miscellaneous;
import com.daily.dto.MiscellaneousDto;

@Component
public class MiscellaneousMapper {
	
	 public MiscellaneousDto miscellaneousToMiscellaneousDto(Miscellaneous miscellaneous){
		 MiscellaneousDto miscellaneousDto = new MiscellaneousDto();
	    	if(miscellaneous !=null){
	    		try{
	    			miscellaneousDto.setCategory(miscellaneous.getCategory());
	    			miscellaneousDto.setDescription(miscellaneous.getDescription());
	    			miscellaneousDto.setExpense(miscellaneous.getExpense());
	    			miscellaneousDto.setDate(miscellaneous.getDate());
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
	    			miscellaneous.setCategory(miscellaneousDto.getCategory());
	    			miscellaneous.setDescription(miscellaneousDto.getDescription());
	    			miscellaneous.setExpense(miscellaneousDto.getExpense());
	    			miscellaneous.setDate(miscellaneousDto.getDate());
	    	    }
	    	catch(Exception e){
	    	}
	       }
	    	return miscellaneous;
	 }
}

package com.daily.mapper;

import org.springframework.stereotype.Component;

import com.daily.domain.Transportation;
import com.daily.dto.TransportationDto;
import com.daily.util.DateConversionUtil;

@Component
public class TransportationMapper {
	
	public TransportationDto transportationToTransportationDto(Transportation transportation){
		TransportationDto transportationDto = new TransportationDto();
    	if(transportation !=null){
    		try{
    			transportationDto.setId(transportation.getId());
    			transportationDto.setEmail(transportation.getEmail());
    			transportationDto.setCategory(transportation.getCategory());
    			transportationDto.setDescription(transportation.getDescription());
    			transportationDto.setExpense(transportation.getExpense());
    			transportationDto.setDate(DateConversionUtil.dateToString(transportation.getDate()));
    	    }
    	catch(Exception ex){
    	   }
    	}
    	return transportationDto;
	}
	
	public Transportation transportationDtoToTransportation(TransportationDto transportionDto){
		Transportation transportation = new Transportation();
    	if(transportionDto!=null){
    		try{
    			transportation.setId(transportionDto.getId());
    			transportation.setEmail(transportionDto.getEmail());
    			transportation.setCategory(transportionDto.getCategory());
    			transportation.setDescription(transportionDto.getDescription());
    			transportation.setExpense(transportionDto.getExpense());
    			transportation.setDate(DateConversionUtil.stringToDate(transportionDto.getDate()));
    	    }
    	catch(Exception e){
    	}
       }
    	return transportation;
	}
}

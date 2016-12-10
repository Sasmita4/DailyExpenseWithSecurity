package com.daily.mapper;

import org.springframework.stereotype.Component;

import com.daily.domain.Transportation;
import com.daily.dto.TransportationDto;

@Component
public class TransportationMapper {
	
	public TransportationDto transportationToTransportationDto(Transportation transportation){
		TransportationDto transportationDto = new TransportationDto();
    	if(transportation !=null){
    		try{
    			transportationDto.setCategory(transportation.getCategory());
    			transportationDto.setDescription(transportation.getDescription());
    			transportationDto.setExpense(transportation.getExpense());
    			transportationDto.setDate(transportation.getDate());
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
    			transportation.setCategory(transportionDto.getCategory());
    			transportation.setDescription(transportionDto.getDescription());
    			transportation.setExpense(transportionDto.getExpense());
    			transportation.setDate(transportionDto.getDate());
    	    }
    	catch(Exception e){
    	}
       }
    	return transportation;
	}
}

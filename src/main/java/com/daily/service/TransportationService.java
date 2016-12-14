package com.daily.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dao.TransportationDao;
import com.daily.domain.Transportation;
import com.daily.dto.TransportationDto;
import com.daily.mapper.TransportationMapper;

@Service
public class TransportationService {

	@Autowired
	TransportationMapper transportationMapper;
	
	@Autowired
	TransportationDao transportationDao;
	
	public TransportationDto saveTransportation(TransportationDto transportationDto){
		Transportation transportation = transportationMapper.transportationDtoToTransportation(transportationDto);
		transportation = transportationDao.createTransportation(transportation);
		TransportationDto result = transportationMapper.transportationToTransportationDto(transportation);
		return result;
		
	}
	public void deleteTransportation(String id){
		transportationDao.delete(id);
	}
	
    public List<TransportationDto> getAllTransportation(){
       List<Transportation> result = transportationDao.findAllTransportation();
       List<TransportationDto> TransportationDtoList = new ArrayList<TransportationDto>();
       for(Transportation Transportation : result){
    	   TransportationDto TransportationDto = transportationMapper.transportationToTransportationDto(Transportation);
    	   TransportationDtoList.add(TransportationDto);
       }
    	return TransportationDtoList;
    }
    public TransportationDto updateTransportation(String id){
    	TransportationDto updatedTransportation = null;
    	Transportation result = transportationDao.getOne(id);
        if(result != null){
        	updatedTransportation = saveTransportation(transportationMapper.transportationToTransportationDto(result));
        }
    	return updatedTransportation;
    }
    
    public List<TransportationDto> getTransportationBetweenDate(Date startDate, Date endDate) {
		List<Transportation> result = transportationDao.getTransportationBetweenDate(startDate,endDate);
		List<TransportationDto> transportationList = new ArrayList<TransportationDto>();
		for(Transportation transportation : result){
			TransportationDto dto = transportationMapper.transportationToTransportationDto(transportation);
			transportationList.add(dto);
		}
		return transportationList;
	}
	

}

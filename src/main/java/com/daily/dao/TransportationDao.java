package com.daily.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daily.domain.Transportation;
import com.daily.repository.TransportationRepository;

@Repository
public class TransportationDao {
	
	@Autowired
	TransportationRepository transportationRepository;
	
	public Transportation createTransportation(Transportation transportation){
		Transportation foodResult = transportationRepository.save(transportation);
		return foodResult;
	}
	public List<Transportation> findAllTransportation(){
		List<Transportation> transportationList = transportationRepository.findAll();
		return transportationList;
	}
	public void delete(String id){
		transportationRepository.delete(id);
	}
	public Transportation getOne(String id){
		Transportation transportationResult = transportationRepository.findOne(id);
		return transportationResult;
	}
	
}

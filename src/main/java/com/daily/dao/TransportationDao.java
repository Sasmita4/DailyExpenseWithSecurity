package com.daily.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.daily.domain.Transportation;
import com.daily.repository.TransportationRepository;

@Repository
public class TransportationDao {
	
	@Autowired
	TransportationRepository transportationRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
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
	public List<Transportation> getTransportationBetweenDate(Date startDate, Date endDate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("date").gte(startDate).lte(endDate));
		List<Transportation> result = mongoTemplate.find(query, Transportation.class);	
		return result;
	}
}

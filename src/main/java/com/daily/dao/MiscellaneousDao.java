package com.daily.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.daily.domain.Miscellaneous;
import com.daily.repository.MiscellaneousRepository;

@Repository
public class MiscellaneousDao {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	MiscellaneousRepository miscellaneousRepository;
	
	public Miscellaneous createMiscellaneous(Miscellaneous miscellaneous){
		Miscellaneous miscellaneousResult = miscellaneousRepository.save(miscellaneous);
		return miscellaneousResult;
	}
	public List<Miscellaneous> findAllMiscellaneous(){
		List<Miscellaneous> miscellaneousList = miscellaneousRepository.findAll();
		return miscellaneousList;
	}
	public void delete(String id){
		miscellaneousRepository.delete(id);
	}
	public Miscellaneous getOne(String id){
		Miscellaneous miscellaneousResult = miscellaneousRepository.findOne(id);
		return miscellaneousResult;
	}
	public List<Miscellaneous> getMiscellaneousBetweenDate(Date startDate, Date endDate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("date").gte(startDate).lte(endDate));
		List<Miscellaneous> result = mongoTemplate.find(query, Miscellaneous.class);
		return result;
	}

}

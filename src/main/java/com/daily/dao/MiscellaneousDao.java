package com.daily.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daily.domain.Miscellaneous;
import com.daily.repository.MiscellaneousRepository;

@Repository
public class MiscellaneousDao {
	
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

}

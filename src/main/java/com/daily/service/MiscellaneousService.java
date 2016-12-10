package com.daily.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dao.MiscellaneousDao;
import com.daily.domain.Miscellaneous;
import com.daily.dto.MiscellaneousDto;
import com.daily.mapper.MiscellaneousMapper;

@Service
public class MiscellaneousService {
	
	@Autowired
	MiscellaneousMapper miscellaneousMapper;
	
	@Autowired
	MiscellaneousDao miscellaneousDao;
	
	/* save food expense and return response entity*/
	public MiscellaneousDto saveMiscellaneous(MiscellaneousDto miscellaneousDto){
		Miscellaneous miscellaneous = miscellaneousMapper.miscellaneousDtoToMiscellaneous(miscellaneousDto);
		miscellaneous = miscellaneousDao.createMiscellaneous(miscellaneous);
		MiscellaneousDto result = miscellaneousMapper.miscellaneousToMiscellaneousDto(miscellaneous);
		return result;
		
	}
	/*delete one record*/
	public void deleteMiscellaneous(String id){
		miscellaneousDao.delete(id);
	}
	
	/* find all food related info*/
    public List<MiscellaneousDto> getMiscellaneous(){
       List<Miscellaneous> result = miscellaneousDao.findAllMiscellaneous();
       List<MiscellaneousDto> miscellaneousDtoList = new ArrayList<MiscellaneousDto>();
       for(Miscellaneous miscellaneous : result){
    	   MiscellaneousDto miscellaneousDto = miscellaneousMapper.miscellaneousToMiscellaneousDto(miscellaneous);
    	   miscellaneousDtoList.add(miscellaneousDto);
       }
    	return miscellaneousDtoList;
    }
    /* update one record*/
    public MiscellaneousDto updateMiscellaneous(String id){
    	MiscellaneousDto updatedFood = null;
    	Miscellaneous result = miscellaneousDao.getOne(id);
        if(result != null){
        	updatedFood = saveMiscellaneous(miscellaneousMapper.miscellaneousToMiscellaneousDto(result));
        }
    	return updatedFood;
    }
	

}

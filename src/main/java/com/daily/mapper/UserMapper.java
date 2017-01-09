package com.daily.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.daily.domain.Users;
import com.daily.dto.UsersDto;
import com.daily.util.DateConversionUtil;

@Component
public class UserMapper {
	Logger log = LoggerFactory.getLogger(UserMapper.class);
	public UsersDto userToUserDto(Users user){
		UsersDto dto = new UsersDto();
		List<String> roleList = new ArrayList<String>();
		if(user !=null){
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			dto.setEmail(user.getEmail());
			dto.setCreatedDate(DateConversionUtil.dateToString(user.getCreatedDate()));
			for(String role : user.getAuthorities()){
				roleList.add(role);
			}
			dto.setAuthorities(roleList);
		}
		return dto;
	}

}

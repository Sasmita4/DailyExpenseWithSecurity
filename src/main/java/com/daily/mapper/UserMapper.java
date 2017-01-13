package com.daily.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.daily.domain.Users;
import com.daily.dto.UsersDto;
import com.daily.util.DailyExpenseConstants;
import com.daily.util.DateConversionUtil;
import com.daily.util.RandomUtil;

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
			dto.setActivationKey(user.getActivationKey());
			dto.setActivated(user.isActivated());
			dto.setCreatedDate(DateConversionUtil.dateToString(user.getCreatedDate()));
			for(String role : user.getAuthorities()){
				roleList.add(role);
			}
			dto.setAuthorities(roleList);
		}
		return dto;
	}
	
	public Users userDtoToUsers(UsersDto usersDto){
		Users users = new Users();
		List<String> roleList = new ArrayList<String>();
		roleList.add(DailyExpenseConstants.USER);
		users.setEmail(usersDto.getEmail());
		users.setUserName(usersDto.getUserName());
		users.setPassword(usersDto.getPassword());
		users.setAuthorities(roleList);
		users.setActivated(false);
		users.setActivationKey(RandomUtil.generateActivationKey());
		return users;
	}

}

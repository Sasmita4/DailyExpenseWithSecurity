package com.daily.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dao.UsersDao;
import com.daily.domain.Users;
import com.daily.dto.UsersDto;
import com.daily.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UsersDao usersDao;
	
	@Autowired
	UserMapper userMapper;

	public Users loadUserByUsername(String username) {
		Users result = usersDao.getOne(username);
		/*UsersDto dto = new UsersDto();
		dto.setUserName(result.getUserName());
		dto.setPassword(result.getPassword());
		for(String roles : result.getAuthorities()){
			
		}*/
		return result;
	}
	
	public List<UsersDto> getUsers() {
		List<Users> result = usersDao.getAllUsers();
		List<UsersDto> usersDtoList = new ArrayList<UsersDto>();
		for(Users user : result){
			UsersDto userDto = userMapper.userToUserDto(user);
			usersDtoList.add(userDto);
		}
		return usersDtoList;
	}
	
	public UsersDto registerUser(UsersDto usersDto){
		Users user = userMapper.userDtoToUsers(usersDto);
		UsersDto dto = userMapper.userToUserDto(usersDao.registerUser(user));
		return dto;
	}

	public void activateRegistration(String key) {
		Users result = usersDao.getUserByKey(key);
		result.setActivated(true);
		usersDao.registerUser(result);
	}
}

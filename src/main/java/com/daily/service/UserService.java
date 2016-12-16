package com.daily.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dao.UsersDao;
import com.daily.domain.Users;

@Service
public class UserService {

	@Autowired
	UsersDao usersDao;

	public Users loadUserByUsername(String username) {
		Users result = usersDao.getOne(username);
		/*UsersDto dto = new UsersDto();
		dto.setUserName(result.getUserName());
		dto.setPassword(result.getPassword());
		for(String roles : result.getAuthorities()){
			
		}*/
		return result;
	}
}

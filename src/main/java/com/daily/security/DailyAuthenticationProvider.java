package com.daily.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.daily.domain.Users;
import com.daily.error.UserNotActivatedException;
import com.daily.service.UserService;

@Component
public class DailyAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider{
   
	@Autowired
	UserService usersService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		Users user = usersService.loadUserByUsername(username);
		if(!user.isActivated()){
			throw new UserNotActivatedException("user" +username+"was not activated");
		}
		if (user == null || !StringUtils.equalsIgnoreCase(user.getUserName(), username)) {
			throw new BadCredentialsException("Username not found.");
		}
		if (!StringUtils.equals(password, user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : user.getAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(role));
		};
		return new UsernamePasswordAuthenticationToken(user, password,authorities);
	}
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}

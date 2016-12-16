package com.daily.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DailyAuthenticationProvider authenticationProvider;
	
	@Autowired
	DailyExpenseAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable();
			http.authorizeRequests().antMatchers("/", "/login").permitAll().and().formLogin().loginPage("/login")
			.usernameParameter("ssoId").passwordParameter("password").successForwardUrl("/home").and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		  
	      /*http.authorizeRequests()
	        .antMatchers("/", "/home").permitAll() 
	        .antMatchers("/main").permitAll() 
	        .and().formLogin().loginPage("/login")
	        .and().exceptionHandling().accessDeniedPage("/access_Denied");*/
	  
	    }
	
}

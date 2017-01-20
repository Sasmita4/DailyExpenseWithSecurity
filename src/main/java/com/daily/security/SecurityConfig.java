package com.daily.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

//import com.daily.social.SimpleSocialUsersDetailService;

	@Configuration
	@EnableWebSecurity
//	@EnableOAuth2Sso
	@EnableScheduling
	public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DailyAuthenticationProvider authenticationProvider;
		
	@Autowired
	DailyExpenseAccessDeniedHandler accessDeniedHandler;
		

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		//.antMatchers("/", "/login").permitAll()
		//.antMatchers("/oauth/token").permitAll()
		.antMatchers("/swagger").permitAll()
		// .antMatchers("/**").authenticated()
		.and().formLogin().loginPage("/login").failureUrl("/accessDenied")
		.usernameParameter("ssoId").passwordParameter("password").successForwardUrl("/home").and()
        .logout()
        .logoutUrl("/logout")
        .deleteCookies("JSESSIONID").and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
       
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public TokenStore tokenStore() {
      		return new InMemoryTokenStore();
	}

	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
		handler.setTokenStore(tokenStore);
		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		handler.setClientDetailsService(clientDetailsService);
		return handler;
	}

	@Bean
	@Autowired
	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore);
		return store;
	}
//	@Bean
//	public SocialUserDetailsService socialUsersDetailService() {
//		return new SimpleSocialUsersDetailService(userDetailsService());
//	}
}

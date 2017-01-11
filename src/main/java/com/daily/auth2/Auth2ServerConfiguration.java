package com.daily.auth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.daily.util.DailyExpenseConstants;

@Configuration
public class Auth2ServerConfiguration  {
	Logger log = LoggerFactory.getLogger(Auth2ServerConfiguration.class);
	 	
		@Configuration
	    @EnableResourceServer
	    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
			Logger resourseServerLog = LoggerFactory.getLogger(ResourceServerConfiguration.class);
		 private static final String RESOURCE_ID = "my_rest_api";

			@Override
			public void configure(ResourceServerSecurityConfigurer resources) {
				resources.resourceId(RESOURCE_ID).stateless(false);
			}

			@Override
			public void configure(HttpSecurity http) throws Exception {
				http.anonymous().disable().requestMatchers().antMatchers("/home/**").and().authorizeRequests()
						//.antMatchers("/home/**").access("hasRole('ROLE_ADMIN')")
						.antMatchers("/home/**").permitAll()
		                .antMatchers("/swagger").permitAll()
		                .antMatchers("/getAllUsers").access("hasRole('ROLE_ADMIN')")
						.and().exceptionHandling()
						.accessDeniedHandler(new OAuth2AccessDeniedHandler());
			}
	 }
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private static String REALM = "MY_OAUTH_REALM";

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private UserApprovalHandler userApprovalHandler;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient("my-trusted-client")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
				.authorities(DailyExpenseConstants.ADMIN, DailyExpenseConstants.USER).scopes("read", "write").secret("secret")
				.accessTokenValiditySeconds(600).
				refreshTokenValiditySeconds(600);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.realm(REALM + "/client");
	}
	  }
    
}

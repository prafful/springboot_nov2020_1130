package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserPrincipalDetailService userPrincipalDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// authentication - configure in-memory username and password to check if user is authenticated!
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorization - configure roles for the authenticated users!
		http.authorizeRequests()
			.antMatchers("/welcome").authenticated()
			.antMatchers("/friends/get/**").authenticated()
			.antMatchers("/friends/add").authenticated()
			.antMatchers("/friends/update/**").authenticated()
			.antMatchers("/friends/delete/**").hasRole("ADMIN")
			.and()
			.httpBasic();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailService);
		
		return daoAuthenticationProvider;
	}
	

}

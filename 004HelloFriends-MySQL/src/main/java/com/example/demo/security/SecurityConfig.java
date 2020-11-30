package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// authentication - configure in-memory username and password to check if user is authenticated!
		auth.inMemoryAuthentication()
			.withUser("visitor").password("{noop}visitor123").roles("VISITOR")
			.and()
			.withUser("manager").password("{noop}manager123").roles("VISITOR", "MANAGER")
			.and()
			.withUser("admin").password("{noop}admin123").roles("VISITOR", "MANAGER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorization - configure roles for the authenticated users!
		http.authorizeRequests()
			.antMatchers("/welcome").permitAll()
			.antMatchers("/friends/get/**").hasAnyRole("VISITOR", "MANAGER", "ADMIN")
			.antMatchers("/friends/add").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/friends/update/**").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/friends/delete/**").hasAnyRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
	}

}

package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author micha
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/welcome").permitAll()
				.antMatchers("/avengers").hasRole("HERO")
				.antMatchers("/bases").hasRole("DIRECTOR")
//				.anyRequest().authenticated()
				.and()
			.formLogin()
				.and()
			.httpBasic(); // ohne formLogin() wird das Browser-Login-Fenster angezeigt
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("Nick Fury")
					.password(encoder.encode("director_123"))
					.roles("DIRECTOR")
					.and()
				.withUser("Steve Guy")
			        .password(encoder.encode("hero_123"))
			        .roles("HERO")
			        .and()
			    .withUser("Tony Stark")
			    	.password(encoder.encode("hero_456"))
			    	.roles("HERO")
			    ;
	}
	
	

}

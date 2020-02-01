package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author micha
 *
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.
//			authorizeRequests().
//				anyRequest().authenticated().
//				and().
//			formLogin().
//				and().
//			httpBasic();
		
//		http.
//			formLogin().
//				and().
//			httpBasic();

//		http.
//		authorizeRequests().
//			anyRequest().authenticated();
//
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.
			inMemoryAuthentication().
				withUser("user").
					password(encoder.encode("password")).
					roles("").
					and().
				withUser("admin").
					password(encoder.encode("12345678")).
					roles("ADMIN");
	}
	
	

}

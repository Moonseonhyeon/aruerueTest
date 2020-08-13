package com.linda.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.linda.jwt.config.jwt.JwtAuthenticationFilter;
import com.linda.jwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserRepository userRepository;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.formLogin().disable()
			.httpBasic().disable() //jsessionId안쓰거다
			.addFilter(new JwtAuthenticationFilter(authenticationManager()))
			//.addFilter(null)
			.authorizeRequests()
			.antMatchers("/api/vi/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll();
		
	}

}

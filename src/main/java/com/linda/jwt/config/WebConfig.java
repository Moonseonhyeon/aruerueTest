package com.linda.jwt.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.linda.jwt.config.aop.RoleIntercepter;
import com.linda.jwt.config.aop.SessionIntercepter;

public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionIntercepter())
		.addPathPatterns("/user/**");
		registry.addInterceptor(new RoleIntercepter())
		.addPathPatterns("/admin/**");
	}

}

package com.linda.jwt.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.linda.jwt.config.handler.exception.MyRoleException;
import com.linda.jwt.config.handler.exception.MySessionException;
import com.linda.jwt.model.User;

public class RoleIntercepter extends HandlerInterceptorAdapter{	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		if(principal == null) {
			System.out.println("RoleIntercepter : 인증이 안됨.");
			throw new MySessionException();
		} else {
			if(!principal.getRole().equals("ROLE_ADMIN")) {
				System.out.println("RoleIntercepter : 권한이 없음.");
				throw new MyRoleException();
			}
		}
		
		return true;
	}
}

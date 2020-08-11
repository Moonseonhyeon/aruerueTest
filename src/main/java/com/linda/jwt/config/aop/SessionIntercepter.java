package com.linda.jwt.config.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.linda.jwt.model.User;

public class SessionIntercepter extends HandlerInterceptorAdapter{
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	//UserDetails에 User에 principal에서 꺼낼 수도있나요?
	HttpSession session = request.getSession();
	User principal = (User)session.getAttribute("principal");
	if(principal == null) {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('로그인이 필요합니다.');");
		out.print("location.href='/auth/loginForm';");
		out.print("</script>");
		
		return false; //더이상 집입안됨. 바로 response됨.
	}
	System.out.println("인증을 체크 해야함");
	return true;
	}
}

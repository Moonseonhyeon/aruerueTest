package com.linda.jwt.config.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.linda.jwt.config.handler.exception.MyRoleException;
import com.linda.jwt.config.handler.exception.MySessionException;

@ControllerAdvice // IoC등록됨. Exception을 낚아채는 컨트롤러.
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MySessionException.class)
	public String sessionException(Exception e) {
		//인증없음.
		return "<h1>인증 없어요. 나가세요</h1>";
	}
	
	@ExceptionHandler(value = MyRoleException.class)
	public String roleExceString(Exception e) {
		//권한없음.
		return "<h1>권한 없어요. 나가세요</h1>";
	}
}

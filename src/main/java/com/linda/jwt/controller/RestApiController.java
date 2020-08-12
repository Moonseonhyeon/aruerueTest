package com.linda.jwt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.jwt.controller.dto.CommonRespDto;
import com.linda.jwt.model.User;
import com.linda.jwt.service.UserService;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Controller
@RequestMapping("api/v1")
public class RestApiController {

	
	  @Autowired 
	  private BCryptPasswordEncoder bCryptPasswordEncoder;
	  
	  @Autowired 
	  private UserService userService;
	 

	@GetMapping({ "", "/" })
	public String index() {
		return "index";
	}

	@GetMapping("/auth/joinForm")
	public String joinFrom() {
		return "user/joinForm";
	}

	@GetMapping("/login")
	public String loginFrom() {
		return "user/loginForm";
	}

	// 어드민이 접근가능
	@GetMapping("admin/users")
	public List<User> users() {
		return null;
	}


	  @PostMapping("join") 
	  public String join(@RequestBody User user) {
	  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	  user.setRole("ROLE_USER"); userService.회원가입(user); 
	  return "회원가입 완료"; }
	 	

}

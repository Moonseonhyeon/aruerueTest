package com.linda.jwt.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.linda.jwt.controller.dto.CommonRespDto;
import com.linda.jwt.model.User;
import com.linda.jwt.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("api/v1")
public class RestApiController {
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;	
	private final UserService userService;
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}

	@GetMapping("/auth/joinForm")
	public String joinFrom() {
		return "user/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String loginFrom() {
		return "user/loginForm";
	}
	
	@PostMapping("/auth/joinProc")
	public CommonRespDto<?> joinProc(@RequestBody User user) {
		System.out.println("회원가입 진행 : "+user);
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		userService.회원가입(user);
		return new CommonRespDto<String>(1, "회원 가입 결과");
	}
	
	
	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session) { // DI하는 방법 2번. 1번은
																									// 전역에 @AutoWired하기
		User persistUser = userService.로그인(user);

		if (ObjectUtils.isEmpty(persistUser)) { // 스프링이 들고 있는 ObjectUtils객체가 있음.
			System.out.println("없음");
			return new CommonRespDto<String>(-1, "로그인 결과 실패");
		} else {
			System.out.println("있음");
			// 세션 등록해야 함.
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 결과 성공");
		}
	}

}

package com.linda.jwt.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linda.jwt.controller.dto.LoginRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("attemptAuthentication");
		
		//request에 있는 username과 password를 파싱해서 자바 오브젝트로 받기
		ObjectMapper om = new ObjectMapper();
		LoginRequestDto loginRequestDto = null;
		
		//리퀘스트 안에 있는 정보 파싱
		try {
			//InputStream으로 받는 데이터를 Dto로 바꿈
			//useranme, password가 저장됨.
			loginRequestDto = om.readValue(request.getInputStream(), LoginRequestDto.class);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//유저네임 패스워드로 토큰 생성
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
		
		//authenticate함수가 호출되면 인증 프로바이더가 유저 디테일 서비스의
		//loadUserByUsername(토큰의 첫번째 파라메터)를 호출하고
		//UserDetials를 리턴받아서 토큰의 두번째 파라메터(credential)과 -> 사용자로부터 받은값
		//UserDetials(DB값)의 getPassword()함수로 비교해서 동일하면
		//Authentication 객체를 만들어서 필터체인으로 리턴해준다.

		//Tip : 인증프로바이더의 디폴트 서비스는 UserDetailsService 타입
		//Tip : 인증 프로바이더의 디폴트 암호화 방식은 BCriptPassword
		//결론은 인증프로바이더에게 알려줄 필요 없음.
		
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		//provider의 일을 위임하고		
		
		return authentication;
	}
	
	//JWT Token 생성해서 응답해주기 response에 정보만 담아준다는 것. 지금 클라이언트한테 응답한다느게 아님. 다음 필터로 리턴.
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
		super.successfulAuthentication(request, response, chain, authResult);
	}

}

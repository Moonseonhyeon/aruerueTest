package com.linda.jwt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linda.jwt.model.User;
import com.linda.jwt.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user);
	}

	@Transactional(readOnly = true) //데이터 변경을 허용하지 않음 (혹시 이 트랜젝션이 끝나기 전에
	//다른 사용자가 데이터를 변경한 내용 때문에 엉키지않게 하려고)=> 정확성을 위해서
	public User 로그인(User user) {
		System.out.println(user);
			return userRepository.login(user);	
	}
}


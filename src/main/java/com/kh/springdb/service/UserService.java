package com.kh.springdb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.SiteUser;
import com.kh.springdb.model.UserRole;
import com.kh.springdb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	// 회원가입을 할 경우 계정을 생성해주기 위해 service 를 만들어줌
	// 기존 서비스에서 했던 회원가입과 조금 다른 점은
	// 비밀번호를 암호화 처리해서 저장해주는 것이 조금 다름
	
	public SiteUser createUser(String username, String password ,String email, UserRole role) {
		SiteUser user = new SiteUser();
		user.setUserName(username);
		user.setPassword(passwordEncoder.encode(password)); // 암호화
		user.setEmail(email);
		
		// 사용자 역할 설정
		user.setIsRole(role);
		
		userRepository.save(user);
		return user;
	}
	
	
}

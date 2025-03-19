package com.shinnal.memo.user.service;

import org.springframework.stereotype.Service;

import com.shinnal.memo.common.MD5HashingEncoder;
import com.shinnal.memo.user.domain.User;
import com.shinnal.memo.user.repository.UserRepository;

@Service
public class UserService {
	
	
	private final UserRepository userRepository;
	// final 수정 불가능
	
	// 생성자 만들기_ 특수한 메소드 : 사용에 따른 포괄적으로 가능
	// 다른 생성자가 없이 autowired를 위한 생성자가 있는 경우는 @Autowired 생략가능
//	@Autowired
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	
	public boolean addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		
		// 비밀번호를 암호화하여 repository에 메소드로 전달!!!
		 
//		MD5HashingEncoder encoder = new MD5HashingEncoder();
//		String encyptPassword = encoder.encode(password);
		
		String encyptPassword = MD5HashingEncoder.encode(password);
		
		
		int count = userRepository.insertUser(loginId, encyptPassword, name, email);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	public User getUser(String loginId, String password) {
		
		String encyptPassword = MD5HashingEncoder.encode(password);
		
		return userRepository.selectUser(loginId, encyptPassword);
		
		
	}
	
	
}

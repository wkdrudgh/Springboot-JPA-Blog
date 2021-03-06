package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다. 
@Service
public class UserService {
		
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public User 회원찾기(String username) {
		User user = repository.findByUsername(username).orElseGet(()->{
			return new User();
		});		
		return user;
	}
	
	@Transactional // 에러 발생시 자동으로 롤백을 해줌.
	public void 회원가입(User user) {
		user.setPassword(encoder.encode(user.getPassword())); // 1234를 해쉬로 변환해서 user에 set 함.
		user.setRole(RoleType.USER);
		repository.save(user);
	}	
	
	@Transactional
	public void 회원수정(User user) {
		User persistance = repository.findById(user.getId())
				.orElseThrow(()->{
					return new IllegalArgumentException("회원찾기 실패"); 
				});
		
		// Validate 체크 => oauth 필드에 값이 없으면 수정 가능
		if(persistance.getOauth() == null || persistance.getOauth() == "") {
			String rawPassword = user.getPassword();
			String encPassword =  encoder.encode(rawPassword);
			persistance.setPassword(rawPassword);
			persistance.setEmail(user.getEmail());
		}
								
	}
	
}

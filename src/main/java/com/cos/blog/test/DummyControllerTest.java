package com.cos.blog.test;


import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// html 파일이 아니라 data를 리턴해주는 Controller = RestController
@RestController 
public class DummyControllerTest {
		
		@Autowired // 의존성 주입(DI)
		private UserRepository userRepository;
		
		// http://localhost:8000/blog/dummy/user
		@GetMapping("/dummy/users")
		public List<User> List() {
			return userRepository.findAll();
		}
		
		// 한페이지당 2건에 데이터를 리턴받아 볼 예정   
		@GetMapping("/dummy/user")
		public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
			Page<User> pagingUser =  userRepository. findAll(pageable);
			
			List<User> users = pagingUser.getContent();
			return users;
		}
		
		// {id} 주소로 파라메터를 전달 받을 수 있음.
		// http://localhost:8000/blog/dummy/user/3
		@GetMapping("/dummy/user/{id}")
		public User detail(@PathVariable int id) {
			// user/4를 찾을려고 할 때 데이터베이스에 값이 없으면 nulll이 들어오는데 그럼 문제가 생기니까 
			// Optional로 User객체를 감싸서 가져오면 null인지 판단해서 return 해
			
//			   // 람다식
//			   User user = userRepository.findById(id).orElseThrow(()->{
//				   return new IllegalArgumentException("해당 유저는 없습니다. : "+id);
//			   });
			
		
			 User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
				 @Override
				public IllegalArgumentException get() {
					// TODO Auto-generated method stub
					return new IllegalArgumentException("해당 유저는 없습니다. : "+id);
				}
			});
			// 요청 : 웹브라우저
			// user 객체 = 자바오브젝트 
			// 변환 ( 웹 브라우저가 이해할 수 있는 데이터 ) -> json ( Gson 라이브러리 )
			// 스프링부트 = MessageConverter라는 얘가 응답 시 자동 작동
			// 만약에 자바 오브젝트를 리턴하게 되면  MessageConverter 가 Jackson 라이브러리를 호출해서
			// user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다. 
			return user;
		}

		// http://localhost:8000/blog/dummy/join (요청)
		// http의 body에 usernaem, password, email 데이터를 가지고 (요청)
		@PostMapping("/dummy/join")
		public String join(User user) { // key=value (약속된 규칙)
			System.out.println("id : "+user.getId());
			System.out.println("username : "+user.getUsername());
			System.out.println("password : "+user.getPassword());
			System.out.println("email : "+user.getEmail());
			System.out.println("role : "+user.getRole());
			
			user.setRole(RoleType.USER);
			
			userRepository.save(user);
			return "회원가입이 완료되었습니다. ";
		}
}

package com.shinnal.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shinnal.memo.user.domain.User;
import com.shinnal.memo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// API 구성을 위한 Controller
// @ResponseBody

@RequestMapping("/user")
@RestController // @Controller + @ResponseBody
public class UserRestController {
	
	private final UserService userService;
	
	public UserRestController(UserService userService) { // Autowired 역할을 함!!
		this.userService = userService;
	}
	
	
	// 회원가입 API
	
//	@PostMapping("/join")
//	public Map<String, String> join(
//			@RequestParam("loginId") String loginId
//			, @RequestParam("password") String password
//			, @RequestParam("name") String name
//			, @RequestParam("email") String email) {
//		
//		Map<String, String> resultMap = new HashMap<>();
//		
//		
//		if(userService.addUser(loginId, password, name, email)){
//			// 성공
//			resultMap.put("result", "success");
//		} else {
//			// 실패
//			resultMap.put("result", "fail");
//		}
//		
//		return resultMap;
//		
//	}
	
	@PostMapping("/join")
	public Map<String, String> join( // 파라미터 이름에 매칭 - 변수에 적용 = 프로젝트 properties-> Java compiler -> store information about method parameters 체크
			@RequestParam String loginId
			, @RequestParam String password
			, @RequestParam String name
			, @RequestParam String email) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		
		if(userService.addUser(loginId, password, name, email)){
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	
	
	
	// 로그인 API
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		 
		User user = userService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			// 성공
			
			HttpSession session = request.getSession();
			// 로그인 성공 이후 사용자 정보를  session에 저장한다.
			// session은 특정 클라이언트의 정보를 저장한다.
			// 다른 요청에서도 같은 클라이언트라면 해당 값을 사용할 수 있다.
			
			
			System.out.println("" + user.getId());
			
			session.setAttribute("userId", user.getId());
			// 로그인 정보를 저장하여 항상 표시해 줌- 이름 표시
			session.setAttribute("userName", user.getName());
			
						
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	
	
	
}

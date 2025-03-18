package com.shinnal.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shinnal.memo.user.service.UserService;

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
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email) {
		
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
	
}

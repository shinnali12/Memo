package com.shinnal.memo.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shinnal.memo.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {
	
	private final PostService postService;
	
	public PostRestController(PostService postService) {
		this.postService = postService;
	}
	
	
	// 메모등록 API
	
	@PostMapping("/create")
	public Map<String, String> createMemo(
			@RequestParam("title") String title
			, @RequestParam("memo") String memo
			, @RequestParam(required=false) MultipartFile image
			, HttpSession session) {
		
		
		Integer userId = (Integer)session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		
		
		Map<String, String> resultMap = new HashMap<>();
		
		
		if(postService.addPost(userId, userName, title, memo, image)){
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패0
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		
	}

			
	
}

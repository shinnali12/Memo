package com.shinnal.memo.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shinnal.memo.post.domain.PostList;
import com.shinnal.memo.post.service.PostService;

import jakarta.servlet.http.HttpSession;


@RequestMapping("/post")
@Controller
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
		
	}
	
	
	@GetMapping("/list-view")
	public String memoList(
			HttpSession session
			, Model model) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<PostList> postList = postService.getPostList();
		
		model.addAttribute("postList", postList);
		
		return "post/list";
	}
	
	
	@GetMapping("/create-view")
	public String inputMemo() {
		
		return "post/create";
	}
	
	
	@GetMapping("/detail-view")
	public String detailMemo(
			@RequestParam("id") int id
			, Model model) {
		
		PostList post = postService.getPost(id);
		
		model.addAttribute("post", post);
		
		return "/post/detail";
		
	}
	
	
	
	
}

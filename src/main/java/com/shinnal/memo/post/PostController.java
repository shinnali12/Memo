package com.shinnal.memo.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinnal.memo.post.domain.PostList;
import com.shinnal.memo.post.service.PostService;


@RequestMapping("/post")
@Controller
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
		
	}
	
	
	@GetMapping("/list-view")
	public String memoList(Model model) {
		
		List<PostList> postList = postService.getPostList();
		
		model.addAttribute("postList", postList);
		
		return "post/list";
	}
	
}

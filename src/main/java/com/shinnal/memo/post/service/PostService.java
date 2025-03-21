package com.shinnal.memo.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shinnal.memo.post.domain.PostList;
import com.shinnal.memo.post.repository.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	
	public List<PostList> getPostList() {
		
		List<PostList> postList = postRepository.selectPostList();
		
		return postList;
		
	}
	
	
}

package com.shinnal.memo.post.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shinnal.memo.common.FileManager;
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
	
	public boolean addPost(
			int userId
			, String userName
			, String title
			, String memo
			, MultipartFile image) {
		
		String urlPath = FileManager.saveFile(userId, image); 
		
		int count = postRepository.insertPostMemo(userId, userName, title, memo, urlPath);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public PostList getPost(int id) {
		
		PostList post = postRepository.getPostMemo(id);
		
		return post;
		
	}
	
	
	
}

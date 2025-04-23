package com.shinnal.memo.post.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shinnal.memo.common.FileManager;
import com.shinnal.memo.post.domain.PostList;
import com.shinnal.memo.post.repository.PostRepository;

import jakarta.persistence.PersistenceException;

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
			, String title
			, String memo
			, MultipartFile image) {
		
		String urlPath = FileManager.saveFile(userId, image); 
		
		int count = postRepository.insertPostMemo(userId, title, memo, urlPath);
		
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
	
	
//	public boolean updatePost(int id, String title, String contents) {
//		
//		Optional<Post> optionalPost = postRepository.findById(id);
//		
//		if(optionalPost.isPresent()) {
//			
//			Post post = optionalPost.get();
//			
//			post = post.toBuilder()
//			.title(title)
//			.contents(contents)
//			.build();
//			
//			try {				
//				postRepository.save(post);
//			} catch(PersistenceException e) {
//				return false;
//			}
//			
//		} else {
//			return false;
//		}
//		
//		return true;
//		
//	}
//	
//	public boolean deletePost(int id) {
//		
//		Optional<Post> optionalPost = postRepository.findById(id);
//		
//		if(optionalPost.isPresent()) {
//			
//			Post post = optionalPost.get();
//			
//			FileManager.removeFile(post.getImagePath());
//			
//			try {				
//				postRepository.delete(post);
//			} catch(PersistenceException e) {
//				return false;
//			}
//			
//		} else {
//			return false;
//		}
//		
//		return true;
//	}
//	
	
	
}

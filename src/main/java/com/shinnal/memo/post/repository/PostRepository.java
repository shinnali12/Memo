package com.shinnal.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shinnal.memo.post.domain.PostList;

@Mapper
public interface PostRepository {
	
	public List<PostList> selectPostList();

}

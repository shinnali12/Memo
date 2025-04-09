package com.shinnal.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.shinnal.memo.post.domain.PostList;

@Mapper
public interface PostRepository {
	
	public List<PostList> selectPostList();
	
	public int insertPostMemo(
			@Param("userId") int userId
			,@Param("title") String title
			,@Param("memo") String memo
			,@Param("image") String image);
	
	public PostList getPostMemo(@Param("id") int id);

}

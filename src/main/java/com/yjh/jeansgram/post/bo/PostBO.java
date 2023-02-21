package com.yjh.jeansgram.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yjh.jeansgram.common.FileManagerService;
import com.yjh.jeansgram.post.dao.PostDAO;
import com.yjh.jeansgram.post.model.Post;
import com.yjh.jeansgram.post.model.PostDetail;
import com.yjh.jeansgram.user.bo.UserBO;
import com.yjh.jeansgram.user.model.User;

@Service
public class PostBO {

	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private UserBO userBO;
	
	public int addPost(int userId, String content, MultipartFile file) {
		// 파일을 저장하고, 접근 경로를 만든다.
		
		String imagePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, content, imagePath);
	}
	
	public List<PostDetail> getPostList() {
		
		List<Post> postList = postDAO.selectPostList();
		
		// 생성된 postDetail 객체를 리스트로 구성한다.
		List<PostDetail> postDetailList = new ArrayList<>();
		for(Post post:postList) {
			// postDetail 객체를 생성하고, post 객체의 정보를 저장한다.
			PostDetail postDetail = new PostDetail();
			postDetail.setId(post.getId());
			postDetail.setUserId(post.getUserId());
			postDetail.setContent(post.getContent());
			postDetail.setImagePath(post.getImagePath());
			
			User user = userBO.getUserById(post.getUserId());
			
			
			// userName 값을 저장한다. 
			postDetail.setUserName(user.getName());
			
			postDetailList.add(postDetail);
		}
		
		
		return postDetailList;
		
	}
	
}

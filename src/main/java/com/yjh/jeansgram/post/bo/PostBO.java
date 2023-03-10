package com.yjh.jeansgram.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yjh.jeansgram.common.FileManagerService;
import com.yjh.jeansgram.post.comment.bo.CommentBO;
import com.yjh.jeansgram.post.comment.model.CommentDetail;
import com.yjh.jeansgram.post.dao.PostDAO;
import com.yjh.jeansgram.post.like.bo.LikeBO;
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
	
	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private CommentBO commentBO;
	
	public int addPost(int userId, String content, MultipartFile file) {
		// 파일을 저장하고, 접근 경로를 만든다.
		
		String imagePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, content, imagePath);
	}
	
	public List<PostDetail> getPostList(int userId) {
		
		List<Post> postList = postDAO.selectPostList();
		
		// 생성된 postDetail 객체를 리스트로 구성한다.
		List<PostDetail> postDetailList = new ArrayList<>();
		for(Post post:postList) {
			// postDetail 객체를 생성하고, post 객체의 정보를 저장한다.		
			User user = userBO.getUserById(post.getUserId());
			// 좋아요 개수 조회
			int likeCount = likeBO.likeCount(post.getId());			
			// 좋아요 여부 조회
			boolean isLike = likeBO.isLike(post.getId(), userId);
			
			List<CommentDetail> commentList = commentBO.getCommentList(post.getId());
			
			PostDetail postDetail = new PostDetail();
			postDetail.setId(post.getId());
			postDetail.setUserId(post.getUserId());
			postDetail.setContent(post.getContent());
			postDetail.setImagePath(post.getImagePath());
			postDetail.setLike(isLike);
			postDetail.setLikeCount(likeCount);
			// userName 값을 저장한다. 
			postDetail.setUserName(user.getName());
			postDetail.setCommentList(commentList);
			
			postDetailList.add(postDetail);
			
		}
		
		
		return postDetailList;
		
	}
	
	public int addLike(int userId, int postId) {
		return postDAO.insertLike(userId, postId);
	}
	
	public int deletePost(int postId, int userId) {
		
		Post post = postDAO.selectPost(postId);
		
		// 대상 post 삭제 
		int count = postDAO.deletePost(postId, userId); 
		if(count == 1) {
			FileManagerService.removeFile(post.getImagePath());
			
			// post 와 관계된 댓글 삭제 
			commentBO.deleteCommentByPostId(postId);
			
			// 좋아요 삭제
			likeBO.deleteLikeByPostId(postId);
		
		}
		return count;
		
	}
	

}

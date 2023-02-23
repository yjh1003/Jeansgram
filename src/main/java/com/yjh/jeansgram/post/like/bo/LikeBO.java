package com.yjh.jeansgram.post.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjh.jeansgram.post.like.dao.LikeDAO;

@Service
public class LikeBO {

	@Autowired
	private LikeDAO likeDAO;
	
	public int addLike(int userId, int postId) {
		return likeDAO.insertLike(userId, postId);
	}
	
	// post id를 전달 받고, 좋아요 개수를 리턴하는 메소드
	public int likeCount(int postId) {
		return likeDAO.selectLikeCount(postId);
	}
	
	// postId 와 userId를 전달받고 좋아요 여부 리턴하는 메소드
	public boolean isLike(int postId, int userId) {
		int count = likeDAO.selectLikeCountByUseerId(postId, userId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	// postId와 userId를 전달받고 해당 좋아요 행을 삭제한다.
	public int unlike(int postId, int userId) {
		return likeDAO.deleteLike(postId, userId);
	}
	
	public int deleteLikeByPostId(int postId) {
		return likeDAO.deleteLikeByPostId(postId);
	}
	
}

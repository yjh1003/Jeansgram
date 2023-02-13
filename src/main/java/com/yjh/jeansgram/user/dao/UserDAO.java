package com.yjh.jeansgram.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yjh.jeansgram.user.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email);
	
	// loginId 가 일치하는 행이 몇개인지 확인
	public int selectCountByLoginId(String loginId);
	
	
	public User selectUser(
			@Param("loginId")String loginId
			,@Param("password")String password);
}

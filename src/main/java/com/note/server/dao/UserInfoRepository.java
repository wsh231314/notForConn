package com.note.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.note.server.bean.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	
	UserInfo findByName(String name);
	
	@Query("from UserInfo a where a.name = :name ")
	UserInfo findUser(@Param("name") String name);

}

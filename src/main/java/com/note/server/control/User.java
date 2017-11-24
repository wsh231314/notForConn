package com.note.server.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.note.server.bean.UserInfo;
import com.note.server.dao.UserInfoRepository;

@RestController
@RequestMapping(value="/users")
public class User {
	
	@Autowired
	UserInfoRepository userInfoDao;
	
	@RequestMapping(value="/get")
	public String index() {
		
		return "hello!";
	}

	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public String get(@PathVariable String name) {
		UserInfo user = userInfoDao.findByName(name);
		return user.toString();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String put(@PathVariable String id, @ModelAttribute UserInfo userInfo) {
		userInfoDao.save(userInfo);
		return "ok";
	}
	
}

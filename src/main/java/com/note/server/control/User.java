package com.note.server.control;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.note.server.bean.UserInfo;

@RestController
@RequestMapping(value="/users")
public class User {
	
	static Map<String, UserInfo> users = Collections.synchronizedMap(new HashMap<String, UserInfo>());
	
	@RequestMapping(value="/get")
	public String index() {
		
		return "hello!";
	}

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String get(@PathVariable String id) {
		UserInfo user = users.get(id);
		return user.toString();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String put(@PathVariable String id, @ModelAttribute UserInfo userInfo) {
		users.put(id, userInfo);
		return "ok";
	}
	
}

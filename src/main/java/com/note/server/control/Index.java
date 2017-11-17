package com.note.server.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.note.server.common.JsonException;
import com.note.server.common.UserException;

@Controller
public class Index {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("errorTest")
	public String errorTest() throws Exception {
		
		throw new Exception("I have an error");
	}

	@RequestMapping("userErrorTest")
	public String userErrorTest() throws Exception {
		
		throw new UserException("I have an user defined error!");
	}
	
	@RequestMapping("jsonError")
	public String jsonErrorTest() throws Exception {
		
		throw new JsonException("I have an user defined error!");
	}
	
}

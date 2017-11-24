package com.note.server.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.note.server.bean.UrlInfo;
import com.note.server.bean.UserInfo;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		
		mav.setViewName("error");
		
		return mav;
	}
	
	@ExceptionHandler(value = UserException.class)
	public ModelAndView userExceptionHandler(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", e);
		mav.addObject("url", "THE URL:" + request.getRequestURL());
		
		mav.setViewName("error");
		
		return mav;
	}
	
	@ExceptionHandler(value = JsonException.class)
	@ResponseBody
	public UrlInfo<UserInfo> jsonExceptionHandler(HttpServletRequest request, Exception e) {
		
		UrlInfo<UserInfo> urlInfo = new UrlInfo<UserInfo>();
		
		urlInfo.setUrl(request.getRequestURL().toString());
		urlInfo.setMessage(e.getMessage());
		
		UserInfo user = new UserInfo();
		user.setId(1L);
		user.setName("wsh");
		user.setAge("30");
		
		urlInfo.setData(user);
		
		return urlInfo;
	}
	

}

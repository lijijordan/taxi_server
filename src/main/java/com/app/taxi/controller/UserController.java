package com.app.taxi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.taxi.po.Guest;
import com.app.taxi.service.UserService;



@Controller
@RequestMapping("/user/")
public class UserController{

	
	private UserService userService;
	
	@RequestMapping(value = "/registered.do", method = RequestMethod.GET)
	public void registered(HttpServletRequest request, HttpServletResponse response){
		String phoneNum = request.getParameter("phone");
		Guest guest = new Guest();
		guest.setPhone(phoneNum);
		getUserService().registeredGuest(guest);
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

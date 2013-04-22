package com.app.taxi.service;

import org.springframework.stereotype.Service;

import com.app.taxi.po.Guest;
import com.app.taxi.po.User;

@Service
public interface UserService {
	
	void registeredGuest(Guest guest);
	
	User getUser(String id);
	
	Guest getGuest(String phone);
	
}

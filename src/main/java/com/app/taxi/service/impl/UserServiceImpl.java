package com.app.taxi.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.app.taxi.dao.GuestDao;
import com.app.taxi.po.Guest;
import com.app.taxi.po.User;
import com.app.taxi.service.UserService;

public class UserServiceImpl implements UserService{

	
	private GuestDao guestDao; 
	
	@Transactional
	
	public void registeredGuest(Guest guest) {
		guestDao.saveGuest(guest);
	}

	/**
	 * @return the guestDao
	 */
	public GuestDao getGuestDao() {
		return guestDao;
	}

	/**
	 * @param guestDao the guestDao to set
	 */
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	
	public User getUser(String id) {
		return guestDao.getGuest(id);
	}

	@Override
	public Guest getGuest(String phone) {
		return guestDao.getGuestByPhone(phone);
	}


}

package com.app.taxi.dao;

import com.app.taxi.po.Guest;
import java.util.List;

public interface GuestDao {

	void saveGuest(Guest paramGuest);

	List<Guest> getGuests();
	
	Guest getGuest(String id);
	
	Guest getGuestByPhone(String phoneNum);

}
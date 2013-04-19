package com.app.taxi.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.app.taxi.po.Guest;

@ContextConfiguration(locations = { "classpath:DBTest-context.xml" })
public class GuestDaoImplTest extends AbstractJUnit4SpringContextTests {
	private GuestDao dao;

	@Before
	public void init() {
		this.dao = ((GuestDao) this.applicationContext.getBean("guestDao"));
	}

	@Test
	public void testSave() {
		Guest guest = new Guest();
		guest.setId("1");
		guest.setPhone("18665887300");
		this.dao.saveGuest(guest);
	}

	@Test
	public void testGet() {
		List<Guest> list = this.dao.getGuests();
		Assert.isTrue(list.size() > 0);
	}
}
package com.app.taxi.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.app.taxi.po.Guest;


@ContextConfiguration(locations={"classpath:DBTest-context.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests{

	private UserService userService;
	
	@Before
	public void init(){
		userService = (UserService)this.applicationContext.getBean("userService");
	}
	
	public void asave(){
		System.out.println("test user registered");
		Guest guest1 = new Guest();
		guest1.setPhone("123456789");
		userService.registeredGuest(guest1);
	}
	
	public void get(){
		System.out.println(userService.getUser("2f187f2d6-c541-4943-9f27-97977364d8d0"));
	}
	
	@Test
	public void getGuest(){
		Guest guest = userService.getGuest("18665887300");
		Assert.isTrue(guest != null);
	}
}

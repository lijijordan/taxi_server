package com.app.taxi.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.app.taxi.po.Coordinate;
import com.app.taxi.po.Driver;
import com.app.taxi.po.Guest;
import com.app.taxi.po.Order;
import com.app.taxi.po.OrderState;

@ContextConfiguration(locations={"classpath:DBTest-context.xml"})
public class OrderDaoTest extends AbstractJUnit4SpringContextTests{

	private OrderDao orderDao;
	
	@Before
	public void init(){
		orderDao = (OrderDao)this.applicationContext.getBean("orderDao");
	}
	
	@Test
	public void saveOrder(){
		Order o = new Order();
		Guest g = new Guest();
		g.setId("7e26e598-2ebd-406d-a888-6ba66c98906b");
		Driver d = new Driver();
		d.setId("");
		o.setDriver(d);
		Coordinate c = new Coordinate();
		c.setLan(30.657701576863584);
		c.setLon(104.09013748168945);
		o.setStartAddress("中国成都市锦江区东安南路");
		
		o.setCoordinate(c);
		o.setEndAddress("中国成都市金牛区通锦桥");
		o.setGuest(g);
		o.setState(OrderState.VALID);
		
		orderDao.saveOrder(o);
	}
	
	@Test
	public void query(){
		List<Order> list = orderDao.queryOrders(OrderState.VALID, 5);
		for (Order order : list) {
			System.out.println(order.getCreateDate());
		}
		Assert.isTrue(list.size() > 0);
		System.out.println(list.size());
	}
	
}

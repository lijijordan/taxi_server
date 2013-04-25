package com.app.taxi.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.app.taxi.po.Coordinate;
import com.app.taxi.po.Driver;
import com.app.taxi.po.Order;
import com.app.taxi.po.OrderState;

@ContextConfiguration(locations={"classpath:DBTest-context.xml"})
public class OrderServiceTest extends AbstractJUnit4SpringContextTests{

	private OrderService orderService;
	private static final Logger log = Logger.getLogger(OrderServiceTest.class);
	
	@Before
	public void init(){
		orderService = ((OrderService)this.applicationContext.getBean("orderService"));
	}

	@Test
	public void query(){
		Coordinate coordinate = new Coordinate();
		coordinate.setLan(30.559008994915494);
		coordinate.setLon(104.07966613769531);
		List<Order> list = orderService.queryOrder(OrderState.VALID, 100, 20, coordinate);
		for (Order order : list) {
			System.out.println(order.getDistance() + " address : " + order.getStartAddress());
		}
		log.info(list.size());
	}
	
	public void replyOrder(){
		Order order = new Order();
		order.setId("a558d8ee-133b-4919-aff9-4299191a2706");
		Driver driver = new Driver();
		driver.setId("3642c591-9675-4a46-98ff-287246a1e0b9");
		orderService.replyOrder(order, driver);
	}
	
	public void updateState(){
		Order order = new Order();
		order.setState(OrderState.EXPIRED);
		order.setId("9120bb35-7ace-4c61-8b38-797341601bec");
		orderService.updateOrderState(order);
	}
	
}

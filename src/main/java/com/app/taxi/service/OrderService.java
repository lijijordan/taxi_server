package com.app.taxi.service;

import java.util.List;

import com.app.taxi.po.Coordinate;
import com.app.taxi.po.Driver;
import com.app.taxi.po.Order;
import com.app.taxi.po.OrderState;

public interface OrderService {

	List<Order> queryOrder(OrderState state, int min, double km, Coordinate coordinate);
	
	boolean replyOrder(Order order, Driver driver);
	
	/**
	 * update guest's order
	 * @param order
	 * @param guest
	 */
	void updateOrderState(Order order);
	
	void createOrder(Order order);
	
	
	
}

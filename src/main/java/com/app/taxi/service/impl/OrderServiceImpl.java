package com.app.taxi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.taxi.dao.OrderDao;
import com.app.taxi.po.Coordinate;
import com.app.taxi.po.Driver;
import com.app.taxi.po.Order;
import com.app.taxi.po.OrderState;
import com.app.taxi.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	
	
	public List<Order> queryOrder(OrderState state, int min, double km, Coordinate coordinate) {
		List<Order> r = new ArrayList<Order>();
		List<Order> list = orderDao.queryOrders(state, min);
		for (Order order : list) {
			double distance = DistanceAlgorithm.DistanceBetweenPlaces(coordinate.getLon(), coordinate.getLan(), 
					order.getCoordinate().getLon(), order.getCoordinate().getLan ());
			// computing distance 
			order.setDistance(distance);
			if(order.getDistance() < km){
				r.add(order);
			}
		}
		return r;
	}

	/**
	 * @return the orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * @param orderDao the orderDao to set
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
	public void createOrder(Order order) {
		orderDao.saveOrder(order);
	}

	
	public boolean replyOrder(Order order, Driver driver) {
		Order o1 = orderDao.queryOrder(order.getId());
		// order is valid
		if(o1 != null && o1.getState() == OrderState.VALID){
			order.setDriver(driver);
			orderDao.updateDriver(order);
			return true;
		}else{
			return false;
		}
	}

	
	public void updateOrderState(Order order) {
		orderDao.updateOrderState(order);
	}
	
}

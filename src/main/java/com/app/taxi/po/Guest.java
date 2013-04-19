package com.app.taxi.po;

import java.util.List;

/**
 * 乘客
 * @author lijib
 *
 */
public class Guest extends User{
	
	private List<Order> orders;

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}

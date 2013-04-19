package com.app.taxi.po;

import java.util.List;

/**
 * 司机
 * @author lijib
 *
 */
public class Driver extends User{


	private List<Order> orders;
	
	/**
	 * 车牌
	 */
	private String license;


	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}

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

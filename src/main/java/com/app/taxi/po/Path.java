package com.app.taxi.po;

import java.util.List;

public class Path extends BaseBean {

	private User user;
	
	private List<PathPoint> points;
	
	private Order order;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the points
	 */
	public List<PathPoint> getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(List<PathPoint> points) {
		this.points = points;
	}
	
	
}

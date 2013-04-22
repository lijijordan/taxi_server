package com.app.taxi.po;

/**
 * 坐标
 * @author lijib
 *
 */
public class Coordinate {
	
	
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}
	
	public Coordinate(double lan, double lon) {
		this.lon = lon;
		this.lan = lan;
	}
	/**
	 * 经度
	 */
	private double lon;
	
	/**
	 * 纬度
	 */
	private double lan;

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLan() {
		return lan;
	}

	public void setLan(double lan) {
		this.lan = lan;
	}
	
	

}

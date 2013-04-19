package com.app.taxi.po;

public class Star {

	/*
	 * 总体满意度评级  1-5
	 */
	private int totalStar;
	
	/*
	 * 接待速度 1-5 
	 */
	private int speedStar;
	
	/*
	 * 服务态度 1-5
	 */
	private int attitudeStar;

	public int getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(int totalStar) {
		this.totalStar = totalStar;
	}

	public int getSpeedStar() {
		return speedStar;
	}

	public void setSpeedStar(int speedStar) {
		this.speedStar = speedStar;
	}

	public int getAttitudeStar() {
		return attitudeStar;
	}

	public void setAttitudeStar(int attitudeStar) {
		this.attitudeStar = attitudeStar;
	}
	
	
}

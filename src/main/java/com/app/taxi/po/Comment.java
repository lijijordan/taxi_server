package com.app.taxi.po;


/**
 * 评论
 * @author lijib
 *
 */
public class Comment extends BaseBean {
	
	
	private Order order;
	/*
	 * 满意度评级 1-5
	 */
	private Star star;
	
	/*
	 * 评论内容 
	 */
	private String text;
	
	/*
	 * 评论人
	 */
	private User from;
	
	/*
	 * 被评论人
	 */
	private User to;
	
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	/**
	 * @return the star
	 */
	public Star getStar() {
		return star;
	}

	/**
	 * @param star the star to set
	 */
	public void setStar(Star star) {
		this.star = star;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
}

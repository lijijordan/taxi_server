package com.app.taxi.dao;

import java.util.List;

import com.app.taxi.po.Order;
import com.app.taxi.po.OrderState;

/**
 * 订单Dao接口
 * @author lijib
 *
 */
public interface OrderDao {
	
	/**
	 * 更新订单状态
	 * @param order
	 */
	void updateOrderState(Order order);

	void updateDriver(Order order);
	
	/**
	 * 保存一个订单
	 * @param order
	 */
	void saveOrder(Order order);
	
	/**
	 * 根据订单ID查询订单详情
	 * @param id
	 * @return
	 */
	Order queryOrder(String id);
	
	/**
	 * 根据客户ID查询订单信息
	 * @param customId
	 * @return
	 */
	List<Order> queryOrdersByCustomId(String customId);
	
	/**
	 * 根据司机ID查询订单信息
	 * @param driverId
	 * @return
	 */
	List<Order> queryOrdersByDriverId(String driverId);
	
	/**
	 * 查询订单
	 * @param state 订单状态
	 * @param min 最近几分钟的订单
	 * @param km  最近距离的订单
	 * @return
	 */
	List<Order> queryOrders(OrderState state, int min);
	
}

package com.app.taxi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.taxi.po.Coordinate;
import com.app.taxi.po.Guest;
import com.app.taxi.po.Order;
import com.app.taxi.po.OrderState;
import com.app.taxi.service.OrderService;
import com.app.taxi.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController{

	
	private UserService userService;
	private OrderService orderService;
	
	private Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/registered.do", method = RequestMethod.GET)
	public void registered(HttpServletRequest request, HttpServletResponse response){
		String phoneNum = request.getParameter("phone");
		Guest guest = new Guest();
		guest.setPhone(phoneNum);
		getUserService().registeredGuest(guest);
	}
	
	@RequestMapping(value = "/calltaxi.do", method = RequestMethod.POST)
	public void callTaxi(HttpServletResponse response,String startAddress, String endAddress, String phone, double lat, double lng){
		Guest guest = userService.getGuest(phone);
		if(guest != null){
			Order order = new Order();
			order.setGuest(guest);
			Coordinate coordinate = new Coordinate();
			coordinate.setLan(lat);
			coordinate.setLon(lng);
			order.setCoordinate(coordinate);
			order.setState(OrderState.VALID);
			order.setStartAddress(startAddress);
			order.setEndAddress(endAddress);
			orderService.createOrder(order);
			try {
				response.getWriter().write("Send a message successful! Please be patient");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/addpath.do", method = RequestMethod.POST)
	public void addPathPoint(HttpServletResponse response, double lat, double lng, String orderId){
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryOrder.do", method = RequestMethod.POST)
	public void queryOrder(HttpServletResponse response, double radius, double lat, double lng, int min){
		Coordinate coordinate = new Coordinate(lat, lng); 
		List<Order> list = orderService.queryOrder(OrderState.VALID, min, radius, coordinate);
		JSONArray jsonArray = new JSONArray();
		for (Order order : list) {
			JSONObject object = new JSONObject();
			object.put("lat", String.valueOf(order.getCoordinate().getLan()));
			object.put("lng", String.valueOf(order.getCoordinate().getLon()));
			object.put("phone", order.getGuest().getPhone());
			object.put("startAddress", order.getStartAddress());
			object.put("endAddress", order.getEndAddress());
			object.put("createTime", String.valueOf(order.getCreateDate()));
			jsonArray.add(object);
		}
		String msg = jsonArray.toJSONString();
		log.info(msg);
		try {
			response.setHeader("ContentType", "text/json");  
            response.setCharacterEncoding("utf-8");  
			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the orderService
	 */
	public OrderService getOrderService() {
		return orderService;
	}

	/**
	 * @param orderService the orderService to set
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}

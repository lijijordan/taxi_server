package com.app.taxi.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.taxi.dao.OrderDao;
import com.app.taxi.po.Coordinate;
import com.app.taxi.po.Driver;
import com.app.taxi.po.Guest;
import com.app.taxi.po.Order;
import com.app.taxi.po.OrderState;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

	
	public void saveOrder(Order order) {
		String sql = "insert into taxi_order (id, start_address, end_address, guest_id, driver_id, lon, lan, state, create_time) " +
				" values(?,?,?,?,?,?,?,?,?)";
		super.getJdbcTemplate().update(sql, new Object[]{
				getUUID(), order.getStartAddress(), order.getEndAddress(), order.getGuest().getId(), order.getDriver().getId(),
				order.getCoordinate().getLon(), order.getCoordinate().getLan(), order.getState().toString(), super.getDateTime(0)
		});
		order.setId(getUUID());
	}

	
	public Order queryOrder(String id) {
		String sql = "SELECT id, start_address, end_address, guest_id, driver_id, lon, lan, state, create_time " +
				"FROM taxi.taxi_order where id = ?";
		Map<String, Object> map = getJdbcTemplate().queryForMap(sql, new Object[]{id});
		Order o = new Order();
		Coordinate coordinate = new Coordinate();
		coordinate.setLan((Double)map.get("lan"));
		coordinate.setLon((Double)map.get("lon"));
		o.setCoordinate(coordinate);
		o.setCreateDate((Timestamp)map.get("create_time"));
		Driver driver = new Driver();
		driver.setId((String)map.get("driver_id"));
		o.setDriver(driver);
		Guest guest = new Guest();
		guest.setId((String)map.get("guest_id"));
		o.setGuest(guest);
		o.setId((String)map.get("id"));
		o.setStartAddress((String)map.get("start_address"));
		o.setEndAddress((String)map.get("end_address"));
		o.setState(OrderState.valueOf((String)map.get("state")));
		return o;
	}

	
	public List<Order> queryOrdersByCustomId(String guestId) {
		List<Order> r = new ArrayList<Order>();
		String sql = "SELECT id, start_address, end_address, guest_id, driver_id, lon, lan, state, create_time " +
				"FROM taxi.taxi_order where guest_id = ?";
		List<Map<String, Object>> list = super.getJdbcTemplate().queryForList(sql, new Object[]{guestId});
		for (Map<String, Object> map : list) {
			Order o = new Order();
			Coordinate coordinate = new Coordinate();
			coordinate.setLan((Double)map.get("lan"));
			coordinate.setLon((Double)map.get("lon"));
			o.setCoordinate(coordinate);
			o.setCreateDate((Timestamp)map.get("create_time"));
			Driver driver = new Driver();
			driver.setId((String)map.get("driver_id"));
			o.setDriver(driver);
			Guest guest = new Guest();
			guest.setId((String)map.get("guest_id"));
			o.setGuest(guest);
			o.setId((String)map.get("id"));
			o.setStartAddress((String)map.get("start_address"));
			o.setEndAddress((String)map.get("end_address"));
			o.setState(OrderState.valueOf((String)map.get("state")));
			r.add(o);
		}
		return r;
	}

	
	public List<Order> queryOrdersByDriverId(String driverId) {
		List<Order> r = new ArrayList<Order>();
		String sql = "SELECT id, start_address, end_address, guest_id, driver_id, lon, lan, state, create_time " +
				"FROM taxi.taxi_order where driver_id = ?";
		List<Map<String, Object>> list = super.getJdbcTemplate().queryForList(sql, new Object[]{driverId});
		for (Map<String, Object> map : list) {
			Order o = new Order();
			Coordinate coordinate = new Coordinate();
			coordinate.setLan((Double)map.get("lan"));
			coordinate.setLon((Double)map.get("lon"));
			o.setCoordinate(coordinate);
			o.setCreateDate((Timestamp)map.get("create_time"));
			Driver driver = new Driver();
			driver.setId((String)map.get("driver_id"));
			o.setDriver(driver);
			Guest guest = new Guest();
			guest.setId((String)map.get("guest_id"));
			o.setGuest(guest);
			o.setId((String)map.get("id"));
			o.setStartAddress((String)map.get("start_address"));
			o.setEndAddress((String)map.get("end_address"));
			o.setState(OrderState.valueOf((String)map.get("state")));
			r.add(o);
		}
		return r;
	}

	
	public List<Order> queryOrders(OrderState state, int min) {
		List<Order> r = new ArrayList<Order>();
		String sql = "SELECT id, start_address, end_address, guest_id, driver_id, lon, lan, state, create_time " +
				"FROM taxi.taxi_order where create_time > ? and state = ?";
		List<Map<String, Object>> list = super.getJdbcTemplate().queryForList(sql, new Object[]{getDateTime(min), state.toString()});
		for (Map<String, Object> map : list) {
			Order o = new Order();
			Coordinate coordinate = new Coordinate();
			coordinate.setLan((Double)map.get("lan"));
			coordinate.setLon((Double)map.get("lon"));
			o.setCoordinate(coordinate);
			o.setCreateDate((Timestamp)map.get("create_time"));
			Driver driver = new Driver();
			driver.setId((String)map.get("driver_id"));
			o.setDriver(driver);
			Guest guest = new Guest();
			guest.setId((String)map.get("guest_id"));
			o.setGuest(guest);
			o.setId((String)map.get("id"));
			o.setStartAddress((String)map.get("start_address"));
			o.setEndAddress((String)map.get("end_address"));
			o.setState(OrderState.valueOf((String)map.get("state")));
			r.add(o);
		}
		return r;
	}

	
	public void updateDriver(Order order) {
		String sql = "update taxi_order set driver_id = ?, state = ? where id = ?";
		getJdbcTemplate().update(sql, new Object[]{order.getDriver().getId(),OrderState.SUCCESS.toString(), order.getId()});
	}

	
	public void updateOrderState(Order order) {
		String sql = "update taxi_order set state = ? where id = ?";
		getJdbcTemplate().update(sql, new Object[]{order.getState().toString(), order.getId()});
	}

}

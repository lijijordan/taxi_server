package com.app.taxi.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.taxi.dao.PathDao;
import com.app.taxi.po.Order;
import com.app.taxi.po.Path;
import com.app.taxi.po.PathPoint;
import com.app.taxi.po.User;

public class PathDaoImpl extends BaseDaoImpl implements PathDao{

	@Override
	public void savePath(Path path) {
		String sql = "insert into taxi_path (id, driver_id, order_id, create_time) values(?,?,?,?)";
		super.getJdbcTemplate().update(sql, new Object[]{getUUID(), path.getUser() == null ? "":path.getUser().getId(),
				path.getOrder() == null ? "":path.getOrder().getId(), getDateTime(0)});
	}

	@Override
	public List<Path> getPath(String orderId) {
		List<Path> r = new ArrayList<Path>();
		String sql = "SELECT id, driver_id, order_id, create_time FROM taxi.taxi_path where order_id = ?";
		List<Map<String, Object>> list = super.getJdbcTemplate().queryForList(sql, orderId);
		for (Map<String, Object> map : list) {
			Path p = new Path();
			p.setCreateDate((Timestamp)map.get("create_time"));
			Order order = new Order();
			order.setId((String)map.get("order_id"));
			User user = new User();
			user.setId((String)map.get("driver_id"));
			p.setOrder(order);
			p.setUser(user);
			r.add(p);
		}
		return r;
	}

	@Override
	public void addPoint(Path path, PathPoint point) {
		// TODO Auto-generated method stub
		
	}

}

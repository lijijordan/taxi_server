package com.app.taxi.dao.impl;

import com.app.taxi.dao.DriverDao;
import com.app.taxi.po.Driver;

public class DriverDaoImpl extends BaseDaoImpl implements DriverDao {

	public void saveDriver(Driver driver) {
		String sql = "insert into taxi_driver (id, license, phone_num, create_time) values(?,?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{getUUID(),
				driver.getLicense(), driver.getPhone(), getDateTime(0)});
	}

	
}

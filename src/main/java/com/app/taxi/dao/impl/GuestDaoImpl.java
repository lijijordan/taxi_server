package com.app.taxi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.taxi.dao.GuestDao;
import com.app.taxi.po.Guest;

public class GuestDaoImpl extends BaseDaoImpl implements GuestDao {
	
	@Override
	public void saveGuest(Guest guest) {
		String sql = "insert into taxi_guest (id, phone_num) values(?,?)";
		super.getJdbcTemplate().update(sql,
				new Object[] { getUUID(), guest.getPhone() });
	}

	@Override
	public List<Guest> getGuests() {
		List<Guest> guests = new ArrayList<Guest>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(
				"SELECT id, phone_num FROM taxi_guest ");
		for (Map<String, Object> map : list) {
			Guest g = new Guest();
			g.setId((String) map.get("id"));
			g.setPhone((String) map.get("phone_num"));
			guests.add(g);
		}
		return guests;
	}

	@Override
	public Guest getGuest(String id) {
		String sql = "select id, phone_num, create_time from taxi_guest where id = ?";
		try{
			return super.getJdbcTemplate().queryForObject(sql, new RowMapper<Guest>(){
				@Override
				public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
					Guest guest = new Guest();
					guest.setId(rs.getString("id"));
					guest.setPhone(rs.getString("phone_num"));
					guest.setCreateDate(rs.getTimestamp("create_time"));
					return guest;
				}
			}, id);
		}catch (EmptyResultDataAccessException e) {
		}
		return null;
	}

	@Override
	public Guest getGuestByPhone(String phoneNum) {
		String sql = "select id, phone_num, create_time from taxi_guest where phone_num = ?";
		try{
			return super.getJdbcTemplate().queryForObject(sql, new RowMapper<Guest>(){
				@Override
				public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
					Guest guest = new Guest();
					guest.setId(rs.getString("id"));
					guest.setPhone(rs.getString("phone_num"));
					guest.setCreateDate(rs.getTimestamp("create_time"));
					return guest;
				}
			}, phoneNum);
		}catch (EmptyResultDataAccessException e) {
		}
		return null;
	}

}
package com.app.taxi.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDaoImpl {

	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	protected JdbcTemplate getJdbcTemplate(){
		if(this.jdbcTemplate == null){
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}
	
	protected String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	protected String getDateTime(int min){
		Date dt = new Date(System.currentTimeMillis() - (min * 60 * 1000));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dt);
	}
	
	protected Date toDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		BaseDaoImpl dao = new BaseDaoImpl();
		System.out.println(dao.getDateTime(0));
	}
	
}

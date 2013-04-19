package com.app.taxi.dao;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath:DBTest-context.xml"})
public class DaoTestHelper extends AbstractJUnit4SpringContextTests{

	private DataSource ds;
	
	private JdbcTemplate template;
	
	@Before
	public void init(){
		ds = (DataSource)this.applicationContext.getBean("dataSource");
		template = new JdbcTemplate(ds);
	}
	
	@Test
	public void clearTableOrder(){
		String sql = "delete from taxi_order where id <> ''";
		template.update(sql);
	}
	
	@Test
	public void clearTableGuest(){
		String sql = "delete from taxi_guest where id <> ''";
		template.update(sql);
	}
	
	@Test
	public void clearTableDriver(){
		String sql = "delete from taxi_driver where id <> ''";
		template.update(sql);
	}
	
	@Test
	public void clearTableComment(){
		String sql = "delete from taxi_comment where id <> ''";
		template.update(sql);
	}
	
}

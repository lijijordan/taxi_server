package com.db.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;


@ContextConfiguration(locations={"classpath:DBTest-context.xml"})
public class TestConnection extends AbstractJUnit4SpringContextTests{
	
	@Test
	public void testConnection(){
		System.out.println("test connection");
		DataSource dataSource = (DataSource)this.applicationContext.getBean("dataSource");
		Assert.notNull(dataSource);
	}
	
}

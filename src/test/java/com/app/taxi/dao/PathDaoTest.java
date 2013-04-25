package com.app.taxi.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.app.taxi.po.Path;

@ContextConfiguration(locations={"classpath:DBTest-context.xml"})
public class PathDaoTest extends AbstractJUnit4SpringContextTests{

	private PathDao pathDao;
	
	@Before
	public void init(){
		this.pathDao = (PathDao)this.applicationContext.getBean("pathDao");
	}
	
	@Test
	public void save(){
		Path path = new Path();
		pathDao.savePath(path);
	}
	
	@Test
	public void get(){
		List<Path> list = pathDao.getPath("");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCreateDate());
		}
	}
	
}

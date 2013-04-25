package com.app.taxi.dao;

import java.util.List;

import com.app.taxi.po.Path;
import com.app.taxi.po.PathPoint;

public interface PathDao {

	void savePath(Path path);
	
	List<Path> getPath(String orderId);
	
	void addPoint(Path path, PathPoint point);
}

package com.unfoldhappiness_admin.dao;

import java.util.List;

import com.unfoldhappiness_admin.model.Area;


public interface AreaDao extends GenericDAO<Area> {
	public List<Area> getAll();

}

package com.unfoldhappiness_user.dao;

import java.util.List;

import com.unfoldhappiness_user.model.Area;



public interface AreaDao extends GenericDAO<Area> {

	public List<Area> getAll();
}

package com.unfoldhappiness_ngo.dao;

import java.util.List;

import com.unfoldhappiness_ngo.model.Area;




public interface AreaDao extends GenericDAO<Area> {
	public List<Area> getAll();

}

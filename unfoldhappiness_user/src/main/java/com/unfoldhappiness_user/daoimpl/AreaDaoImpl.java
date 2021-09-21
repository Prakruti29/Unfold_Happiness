package com.unfoldhappiness_user.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.unfoldhappiness_user.dao.AreaDao;
import com.unfoldhappiness_user.model.Area;

@Repository("areaDao")
public class AreaDaoImpl extends GenericDaoImpl<Area> implements AreaDao {

	public List<Area> getAll() {
		List<Area> list=(List<Area>) super.getByQuery("FROM Area a WHERE a.isdelete = 0");
		return list;	
		}
	}



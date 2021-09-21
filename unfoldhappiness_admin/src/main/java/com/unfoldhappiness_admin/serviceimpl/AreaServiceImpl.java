package com.unfoldhappiness_admin.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unfoldhappiness_admin.dao.AreaDao;
import com.unfoldhappiness_admin.model.Area;
import com.unfoldhappiness_admin.service.AreaService;

@Service("areaService")
@Transactional

public class AreaServiceImpl implements AreaService {
	@Autowired
	AreaDao areaDao;

	@Override
	public List<Area> getAll() {
	
		return areaDao.getAll();
	}
	

}

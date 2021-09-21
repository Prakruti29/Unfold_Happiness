package com.unfoldhappiness_user.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.unfoldhappiness_user.dao.AreaDao;
import com.unfoldhappiness_user.model.Area;
import com.unfoldhappiness_user.service.AreaService;

@Service("areaService")
@Transactional
public class AreaServiceImpl  implements AreaService{

	@Autowired
	AreaDao areaDao;
	
	public List<Area> getAll() {
		// TODO Auto-generated method stub
		return areaDao.getAll();
	}

}

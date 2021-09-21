package com.unfoldhappiness_admin.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.unfoldhappiness_admin.dao.ProductTypeDao;
import com.unfoldhappiness_admin.model.ProductType;
import com.unfoldhappiness_admin.service.ProductTypeService;

@Service("productTypeService")
@Transactional


public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	ProductTypeDao productTypeDao;
	@Override
	public List<ProductType> getAll() {
		return productTypeDao.getAll();	
		}

}

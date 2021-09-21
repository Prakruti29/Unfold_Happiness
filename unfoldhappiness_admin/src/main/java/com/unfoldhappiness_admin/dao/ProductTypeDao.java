package com.unfoldhappiness_admin.dao;

import java.util.List;

import com.unfoldhappiness_admin.model.ProductType;

public interface ProductTypeDao extends GenericDAO<ProductType> {
	public List<ProductType> getAll();

}

package com.unfoldhappiness_ngo.dao;

import java.util.List;

import com.unfoldhappiness_ngo.model.Product;
import com.unfoldhappiness_ngo.model.ProductType;



public interface ProductTypeDao extends GenericDAO<ProductType> {
	public List<ProductType> getAll();

}

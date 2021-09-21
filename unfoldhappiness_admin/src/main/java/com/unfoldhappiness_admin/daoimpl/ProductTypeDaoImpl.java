package com.unfoldhappiness_admin.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_admin.dao.ProductTypeDao;
import com.unfoldhappiness_admin.model.ProductType;

@Repository("productTypeDao")
public class ProductTypeDaoImpl extends GenericDaoImpl<ProductType> implements ProductTypeDao {

	@Override
	public List<ProductType> getAll() {
		List<ProductType> list=(List<ProductType>) super.getByQuery("FROM ProductType a WHERE a.isdelete = 0");
		return list;
		}

}

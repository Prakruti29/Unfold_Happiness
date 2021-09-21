package com.unfoldhappiness_ngo.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


import com.unfoldhappiness_ngo.dao.ProductDao;
import com.unfoldhappiness_ngo.model.Product;
import com.unfoldhappiness_ngo.util.FileUtils;
@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

	@Override
	public long addProduct(Product product) {
		Product newProduct=new Product();
		if(product.getId()>0)
		{
			newProduct=super.updateObject(product);
		}
		else
		{	
			newProduct = super.saveObject(product);
		}
		return newProduct.getId();
	}

	@Override
	public Product editProduct(int id) {
		
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> list=(List<Product>) super.getByQuery("FROM Product a WHERE a.isdelete = 0");
		return list;	
		}

	@Override
	public Product getById(int id) {
		return super.getById(Product.class, id);
	}

	@Override
	public Boolean deleteProduct(long id) {
		Product product = super.getById(Product.class, id);
		product.setIsdelete(1);
		return super.updateObject(product).getId()>0;
		
	}

	@Override
	public long updateProduct(Product product, MultipartFile file1, MultipartFile file2) {
		product.setPhoto1(FileUtils.getFileName(file1.getOriginalFilename()));
		product.setPhoto2(FileUtils.getFileName(file2.getOriginalFilename()));
		super.updateObject(product);
		FileUtils.uploadFile1(file1, "H://testFiles//");
		FileUtils.uploadFile1(file2, "H://testFiles//");
		return 0;
	}

}

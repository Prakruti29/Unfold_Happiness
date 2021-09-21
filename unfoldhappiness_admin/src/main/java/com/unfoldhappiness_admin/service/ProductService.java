package com.unfoldhappiness_admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.unfoldhappiness_admin.model.Product;

public interface ProductService {
	public long addProduct(Product product, MultipartFile file1,MultipartFile file2);

	public Product editProduct(int id);

	public List<Product> getAll();

	public Product getById(int id);

	public Boolean deleteProduct(long id);

	public long updateProduct(Product product, MultipartFile file1,MultipartFile file2);


}

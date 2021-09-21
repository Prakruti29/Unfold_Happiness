package com.unfoldhappiness_ngo.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.unfoldhappiness_ngo.dao.ProductDao;
import com.unfoldhappiness_ngo.model.Ngo;
import com.unfoldhappiness_ngo.model.Product;
import com.unfoldhappiness_ngo.service.ProductService;
import com.unfoldhappiness_ngo.util.FTPUtils;
import com.unfoldhappiness_ngo.util.FileUtils;

@Service("productService")
@SessionAttributes("ngo")
public class ProductServiceImpl implements ProductService {

	@Autowired
	HttpSession session;
	
	@Autowired
	ProductDao productDao;
	
	private static String UPLOADED_FOLDER1 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_ngo\\resources\\images\\product\\photo1"+File.separator; 
	private static String UPLOADED_FOLDER2 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_ngo\\resources\\images\\product\\photo2"+File.separator;
	
	public long addProduct(Product product, MultipartFile file1, MultipartFile file2) {
		String newP1 = FileUtils.getFileName(file1.getOriginalFilename());
		String newP2 = FileUtils.getFileName(file2.getOriginalFilename());
		product.setPhoto1(newP1);
		product.setPhoto2(newP2);
		product.setImage1(file1);
		product.setImage2(file2);
		Ngo ngo = (Ngo) session.getAttribute("ngo");
		product.setCreatedBy(ngo.getId());
		product.setModifyBy(ngo.getId());
		product.setNgo_id(ngo.getId());
		product.setCreatedDate(new Date(System.currentTimeMillis()));
		product.setModifyDate(new Date(System.currentTimeMillis()));
		long id = productDao.addProduct(product);
		FileUtils.uploadFile1(file1, UPLOADED_FOLDER1+newP1);
		FileUtils.uploadFile1(file2, UPLOADED_FOLDER2+newP2);
		FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newP1, newP1);
		FTPUtils.uploadOnFTP(UPLOADED_FOLDER2+newP2, newP2);
		return id;

	}

	@Override
	public Product editProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> productList = productDao.getAll();
		for(Product p : productList)
		{
			String newP1 = p.getPhoto1();
			String newP2 = p.getPhoto2();
			File Image1 = new File(UPLOADED_FOLDER1+newP1);
			File Image2 = new File(UPLOADED_FOLDER2+newP2);
			DiskFileItem fileItem1 = new DiskFileItem("Image1", "text/plain", false, Image1.getName(), (int) Image1.length() , Image1.getParentFile());
			DiskFileItem fileItem2 = new DiskFileItem("Image2", "text/plain", false, Image2.getName(), (int) Image2.length() , Image2.getParentFile());
		   try {
				fileItem1.getOutputStream();
				fileItem2.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    MultipartFile MPImage1 = new CommonsMultipartFile(fileItem1);
		    MultipartFile MPImage2 = new CommonsMultipartFile(fileItem2);
			if(!Image1.exists())
			{
				FTPUtils.download(newP1, UPLOADED_FOLDER1+newP1);
				p.setImage1(MPImage1);
			}
			if(!Image2.exists())
			{
				FTPUtils.download(newP2, UPLOADED_FOLDER2+newP2);
				p.setImage2(MPImage2);
			}
		}
		return  productList;
	
	}

	@Override
	public Product getById(int id) {
		Product product = productDao.getById(Product.class, id);
		String newP1 = product.getPhoto1();
		String newP2 = product.getPhoto2();
		File Image1 = new File(UPLOADED_FOLDER1+newP1);
		File Image2 = new File(UPLOADED_FOLDER2+newP2);
		DiskFileItem fileItem1 = new DiskFileItem("Image1", "text/plain", false, Image1.getName(), (int) Image1.length() , Image1.getParentFile());
		DiskFileItem fileItem2 = new DiskFileItem("Image2", "text/plain", false, Image2.getName(), (int) Image2.length() , Image2.getParentFile());
	   try {
			fileItem1.getOutputStream();
			fileItem2.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    MultipartFile MPImage1 = new CommonsMultipartFile(fileItem1);
	    MultipartFile MPImage2 = new CommonsMultipartFile(fileItem2);
		if(!Image1.exists())
		{
			FTPUtils.download(newP1, UPLOADED_FOLDER1+newP1);
			product.setImage1(MPImage1);
		}
		if(!Image2.exists())
		{
			FTPUtils.download(newP2, UPLOADED_FOLDER2+newP2);
			product.setImage2(MPImage2);
		}
	
		return product;

	}

	@Override
	public Boolean deleteProduct(long id) {
		return productDao.deleteProduct(id);
	}

	@Override
	public long updateProduct(Product product, MultipartFile file1, MultipartFile file2) {
		product.setPhoto1(FileUtils.getFileName(file1.getOriginalFilename()));
		product.setPhoto2(FileUtils.getFileName(file2.getOriginalFilename()));
		Ngo ngo = (Ngo) session.getAttribute("ngo");
		product.setModifyBy(ngo.getId());
		product.setModifyDate(new Date(System.currentTimeMillis()));
		productDao.updateObject(product);
		String newP1 = FileUtils.getFileName(file1.getOriginalFilename());
		String newP2 = FileUtils.getFileName(file2.getOriginalFilename());
		FileUtils.uploadFile1(file1, UPLOADED_FOLDER1+newP1);
		FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newP1, newP1);
		FileUtils.uploadFile1(file2, UPLOADED_FOLDER1+newP2);
		FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newP2, newP2);
		return 0;
	}

}

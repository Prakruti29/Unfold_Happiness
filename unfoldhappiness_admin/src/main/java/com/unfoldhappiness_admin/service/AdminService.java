package com.unfoldhappiness_admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unfoldhappiness_admin.model.Admin;

public interface AdminService {
	
	public long addAdmin(Admin admin, MultipartFile file);

	public Admin editAdmin(int id);

	public List<Admin> getAll();

	public Admin getById(long id);

	public Boolean deleteAdmin(long id);

	public long updateAdmin(Admin admin, MultipartFile file1);

}

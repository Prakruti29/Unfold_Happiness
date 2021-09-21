package com.unfoldhappiness_admin.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unfoldhappiness_admin.model.Admin;

public interface AdminDao extends GenericDAO<Admin> {
	
	public long addAdmin(Admin admin);

	public Admin editAdmin(int id);

	public Boolean deleteAdmin(long id);

	public List<Admin> getAll();

	public int updateAdmin(Admin st,MultipartFile file);

	public Admin getById(long id);

	public Admin loginCheck(Admin admin);

	int emailCheck(Admin admin);

	Admin forgotpassword(Admin admin);

	Admin changepassword(Admin admin);

	List<Admin> getActive();

	void updatepassword(Admin admin);

	void updatepass(Admin a);



}

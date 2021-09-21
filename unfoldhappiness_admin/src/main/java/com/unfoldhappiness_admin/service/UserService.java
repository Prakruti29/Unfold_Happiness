package com.unfoldhappiness_admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.unfoldhappiness_admin.model.User;

public interface UserService {
	public int addUser(User user);
	public List<User> getAll();
	public void editUser(User user); 
	public Boolean deleteUser(long id);
	public User getById(long id);
	
}

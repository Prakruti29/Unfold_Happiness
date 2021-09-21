package com.unfoldhappiness_admin.dao;

import java.util.List;

import com.unfoldhappiness_admin.model.User;

public interface UserDao extends GenericDAO<User>{
	public int saveuser(User user);
	public Boolean deleteUser(long id);
	public List<User> getAll();
	public void editUser(User user);
	public User getById(long id);
	public int emailCheck(User user);
	
}

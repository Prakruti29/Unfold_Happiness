package com.unfoldhappiness_user.dao;



import com.unfoldhappiness_user.model.User;

public interface UserDao extends GenericDAO<User> {

	public int saveUser(User user);
	public int emailCheck(User user);
	public User loginCheck(User user);
}

package com.unfoldhappiness_user.service;


import com.unfoldhappiness_user.model.Ngo;
import com.unfoldhappiness_user.model.User;
import com.unfoldhappiness_user.model.Volunteer;

public interface LoginService {

	public Ngo login(Ngo ngo);
	Ngo forgotPassword(Ngo ngo);

	public Ngo changePass(Ngo ngo);
	public User login(User user);
	public Volunteer login(Volunteer vol);

}

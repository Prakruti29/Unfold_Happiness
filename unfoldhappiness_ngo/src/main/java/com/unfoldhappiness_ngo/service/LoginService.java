package com.unfoldhappiness_ngo.service;


import com.unfoldhappiness_ngo.model.Ngo;

public interface LoginService {
	public Ngo login(Ngo ngo);
	Ngo forgotPassword(Ngo ngo);

	public Ngo changePass(Ngo ngo);

	
}

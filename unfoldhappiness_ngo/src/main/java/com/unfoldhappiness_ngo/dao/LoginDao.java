package com.unfoldhappiness_ngo.dao;

import com.unfoldhappiness_ngo.model.Ngo;





public interface LoginDao extends GenericDAO<Ngo>{

	public Ngo loginCheck(Ngo ngo);
	Ngo forgotpassword(Ngo admin);

	Ngo changepassword(Ngo admin);

}

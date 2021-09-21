package com.unfoldhappiness_user.dao;




import com.unfoldhappiness_user.model.Ngo;



public interface NgoDao extends GenericDAO<Ngo> {

	public int saveNgo(Ngo ngo);
	public int emailCheck(Ngo ngo);
	public Ngo loginCheck(Ngo ngo);
	Ngo forgotpassword(Ngo ngo);

	Ngo changepassword(Ngo ngo);
	void updatepassword(Ngo ngo);
}

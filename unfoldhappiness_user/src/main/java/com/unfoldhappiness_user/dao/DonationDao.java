package com.unfoldhappiness_user.dao;

import java.util.List;

import com.unfoldhappiness_user.model.Donation;

public interface DonationDao extends GenericDAO<Donation>{

	List<Donation> getAll(long id);

	Donation getVol(long id);

}

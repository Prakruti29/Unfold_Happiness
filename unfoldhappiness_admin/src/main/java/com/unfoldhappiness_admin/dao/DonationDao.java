package com.unfoldhappiness_admin.dao;

import java.util.List;

import com.unfoldhappiness_admin.model.Donation;

public interface DonationDao extends GenericDAO<Donation>{

	public List<Donation> getAll();

	public Donation getdetails(long id);

}

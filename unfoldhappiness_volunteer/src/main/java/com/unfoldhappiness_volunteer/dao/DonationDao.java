package com.unfoldhappiness_volunteer.dao;

import java.util.List;

import com.unfoldhappiness_volunteer.model.Donation;

public interface DonationDao extends GenericDAO<Donation>{

	List<Donation> getAllDonations(int area_id);

}

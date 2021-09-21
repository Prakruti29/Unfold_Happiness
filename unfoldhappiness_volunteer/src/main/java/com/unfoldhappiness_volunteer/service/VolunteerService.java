package com.unfoldhappiness_volunteer.service;

import java.util.List;

import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.model.User;
import com.unfoldhappiness_volunteer.model.Volunteer;

public interface VolunteerService {
	public Volunteer login(Volunteer vol);

	public List<Donation> getAllDonations(int area_id);

	public Donation getById(long id);

	public void updateDonation(Donation donation);

	public Donation getUser(long user_id);
}

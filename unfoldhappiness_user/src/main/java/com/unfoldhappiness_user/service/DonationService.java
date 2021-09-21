package com.unfoldhappiness_user.service;

import java.util.List;

import com.unfoldhappiness_user.model.Donation;

public interface DonationService {

	int addDonation(Donation donation);

	List<Donation> getAll(long id);

	Donation getVol(long id);

}

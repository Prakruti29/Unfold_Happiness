package com.unfoldhappiness_admin.service;

import java.util.List;

import com.unfoldhappiness_admin.model.Donation;

public interface DonationService {

public List<Donation> getAll();

public Donation getDetails(long id);

}

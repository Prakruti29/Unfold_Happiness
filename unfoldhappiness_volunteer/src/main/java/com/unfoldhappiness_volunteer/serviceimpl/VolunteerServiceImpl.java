package com.unfoldhappiness_volunteer.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unfoldhappiness_volunteer.dao.DonationDao;
import com.unfoldhappiness_volunteer.dao.UserDao;
import com.unfoldhappiness_volunteer.dao.VolunteerDao;
import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.model.User;
import com.unfoldhappiness_volunteer.model.Volunteer;
import com.unfoldhappiness_volunteer.service.VolunteerService;
import com.unfoldhappiness_volunteer.util.PasswordEncode;

@Service("volservice")
@Transactional
public class VolunteerServiceImpl implements VolunteerService {
	
	@Autowired
	VolunteerDao volDao;
	
	@Autowired
	DonationDao donationDao;
	
	@Autowired
	UserDao userDao;

	public Volunteer login(Volunteer vol) {
		String password = vol.getPassword();
		vol.setPassword(PasswordEncode.passwordEncode(password));
		return volDao.loginCheck(vol);	}

	public List<Donation> getAllDonations(int area_id) {
		return donationDao.getAllDonations(area_id);
	}

	public Donation getById(long id) {
		
		return donationDao.getById(Donation.class, id);
	}

	public void updateDonation(Donation donation) {
		donationDao.updateObject(donation);
		
	}

	public Donation getUser(long user_id) {
		
		return userDao.getUser(user_id);
	}

}

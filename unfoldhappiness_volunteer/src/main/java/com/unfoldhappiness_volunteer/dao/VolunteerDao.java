package com.unfoldhappiness_volunteer.dao;

import java.util.List;

import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.model.Volunteer;

public interface VolunteerDao extends GenericDAO<Volunteer>{
	Volunteer loginCheck(Volunteer vol);

	

}

package com.unfoldhappiness_user.dao;


import java.util.List;

import com.unfoldhappiness_user.model.Volunteer;

public interface VolunteerDao extends GenericDAO<Volunteer> {

	public Volunteer loginCheck(Volunteer vol);
	public long addVol(Volunteer volunteer);
	public int emailCheck(Volunteer volunteer);
	public List<Volunteer> getAll(int area_id);
}

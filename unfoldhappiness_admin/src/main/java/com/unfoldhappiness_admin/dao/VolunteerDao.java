package com.unfoldhappiness_admin.dao;

import java.util.List;


import com.unfoldhappiness_admin.model.Volunteer;

public interface VolunteerDao extends GenericDAO<Volunteer> {

	public long addVol(Volunteer volunteer);

	public List<Volunteer> getAll();

	public Volunteer getById(long id);

	public Volunteer updateVolunteer(Volunteer volunteer);

	public int deleteVolunteer(long id);

	public int emailCheck(Volunteer volunteer);

}

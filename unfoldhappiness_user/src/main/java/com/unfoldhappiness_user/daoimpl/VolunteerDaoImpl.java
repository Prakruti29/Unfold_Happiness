package com.unfoldhappiness_user.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_user.dao.VolunteerDao;

import com.unfoldhappiness_user.model.Volunteer;

@Repository("voldao")
@SessionAttributes("volunteer")
public class VolunteerDaoImpl extends GenericDaoImpl<Volunteer> implements VolunteerDao{

	public Volunteer loginCheck(Volunteer vol) {
		String query = "FROM Volunteer where isdelete=0 and email='"+vol.getEmail()+"' and password='"+vol.getPassword()+"'";
		List<Volunteer> list = super.getByQuery(query);
		if(list.size()==0)
			return null;
		return list.get(0);
	}

	public long addVol(Volunteer volunteer) {
		super.saveObject(volunteer);
		return 0;
	}

	public int emailCheck(Volunteer volunteer) {
		String query = "FROM Volunteer where email='"+volunteer.getEmail()+"' and isdelete=0";
		List<Volunteer> list = super.getByQuery(query);
		return list.size();	
	}

	public List<Volunteer> getAll(int area_id) {
		List<Volunteer> list=(List<Volunteer>)super.getByQuery("FROM Volunteer v WHERE v.isdelete = 0 and area_name='"+area_id+"'");
		return list; 
	}

}

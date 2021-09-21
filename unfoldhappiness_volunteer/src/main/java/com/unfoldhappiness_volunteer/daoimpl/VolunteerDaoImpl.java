package com.unfoldhappiness_volunteer.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_volunteer.dao.VolunteerDao;
import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.model.Volunteer;

@Repository("volDao")
public class VolunteerDaoImpl  extends GenericDaoImpl<Volunteer> implements VolunteerDao {

	public Volunteer loginCheck(Volunteer vol) {
			String query = "FROM Volunteer where isdelete=0 and email='"+vol.getEmail()+"' and password='"+vol.getPassword()+"'";
			List<Volunteer> list = super.getByQuery(query);
			if(list.size()==0)
				return null;
			return list.get(0);
		}

		
	}



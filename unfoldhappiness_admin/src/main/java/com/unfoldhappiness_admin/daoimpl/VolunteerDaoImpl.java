package com.unfoldhappiness_admin.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.unfoldhappiness_admin.dao.VolunteerDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Ngo;
import com.unfoldhappiness_admin.model.Volunteer;
import com.unfoldhappiness_admin.util.DbUtility;


@Repository("voldao")
public class VolunteerDaoImpl extends GenericDaoImpl<Volunteer> implements VolunteerDao{

	@Override
	public long addVol(Volunteer volunteer) {
		// TODO Auto-generated method stub
		
		super.saveObject(volunteer);
		return 0;
	}

	@Override
	public List<Volunteer> getAll() {
		List<Volunteer> list=(List<Volunteer>)super.getByQuery("FROM Volunteer v WHERE v.isdelete = 0");
		return list; 
	}

	@Override
	public Volunteer getById(long id) {
		String query="select a.vol_id as vol_id,a.name as name,a.email as email,a.gender as gender,a.mobileno as mobileno,"
				+ "a.address as address,a.dob as dob,a.photo as photo,a.proof as proof,"
				+ "a.area_name as area_name,ar.area_name as area "
				+ "From volunteer a inner join area_master ar ON "
				+ "a.area_name=ar.area_id "
				+ "WHERE a.isdelete=0 AND a.vol_id="+id;
		List<Volunteer> list = DbUtility.getListData(query, Volunteer.class);
		return list.get(0);
		
	}
	@Override
	public Volunteer updateVolunteer(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return super.updateObject(volunteer);
	}

	@Override
	public int deleteVolunteer(long id) {
		// TODO Auto-generated method stub
		Volunteer volunteer =super.getById(Volunteer.class, id); 
		volunteer.setIsdelete(1);  
		super.updateObject(volunteer);
		return 0;
	}

	@Override
	public int emailCheck(Volunteer volunteer) {
		String query = "FROM Volunteer where email='"+volunteer.getEmail()+"' and isdelete=0";
		List<Volunteer> list = super.getByQuery(query);
		return list.size();	}
				  

}

package com.unfoldhappiness_volunteer.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_volunteer.dao.UserDao;
import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.model.User;
import com.unfoldhappiness_volunteer.util.DbUtility;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public Donation getUser(long user_id) {
		String query="select u.name as user_name ,u.mobileno as mobileno,d.donation_type as donation_type,"
				+ "d.donation_address as donation_address,a.area_name as area_name,"
				+ "d.donation_date as donation_date,d.donation_time as donation_time,u.email as email "
				+ "From donation d inner join "
				+ "area_master a ON d.donation_area=a.area_id inner join user u ON d.user_id=u.user_id"
				+ " WHERE d.isdelete=0 "
				+ "AND d.user_id="+user_id;
		List<Donation> list = DbUtility.getListData(query, Donation.class);

		return list.get(0);
	}

}

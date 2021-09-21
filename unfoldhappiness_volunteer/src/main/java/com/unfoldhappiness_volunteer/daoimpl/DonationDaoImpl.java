package com.unfoldhappiness_volunteer.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.unfoldhappiness_volunteer.dao.DonationDao;
import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.util.DbUtility;

@Repository("donationDao")
public class DonationDaoImpl extends GenericDaoImpl<Donation> implements DonationDao {

	public List<Donation> getAllDonations(int area_id) {
		String query="select d.user_id as user_id,d.id as id ,u.mobileno as mobileno,d.donation_qty as donation_qty,"
				+ "d.donation_address as donation_address,a.area_name as area_name,"
				+ "d.donation_date as donation_date,d.donation_time as donation_time,"
				+ "d.status as status "
				+ "From donation d inner join "
				+ "area_master a ON d.donation_area=a.area_id inner join user u ON d.user_id=u.user_id"
				+ " WHERE d.isdelete=0 "
				+ "AND d.donation_area="+area_id;
				
		List<Donation> list = DbUtility.getListData(query, Donation.class);		
		//List<Donation> list=(List<Donation>)super.getByQuery("FROM Donation d WHERE d.isdelete = 0 and d.donation_area='"+area_id+"'");
		//List<Donation> list=(List<Donation>)
		return list;
	}
	
}


package com.unfoldhappiness_admin.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_admin.dao.DonationDao;
import com.unfoldhappiness_admin.model.Donation;
import com.unfoldhappiness_admin.util.DbUtility;


@Repository("donationdao")
public class DonationDaoImpl extends GenericDaoImpl<Donation> implements DonationDao {

	@Override
	public List<Donation> getAll() {
		String query="select d.id as id,u.name as uname,donation_type as donation_type,v.name as vol_name,"
				+ "donation_qty as donation_qty,donation_date as donation_date,d.status as status,"
				+ "donation_address as donation_address "
				+ "From donation d inner join user u ON d.user_id=u.user_id inner join"
				+ " volunteer v ON d.vol_id=v.vol_id";
		
		List<Donation> list=DbUtility.getListData(query, Donation.class);
		return list;
	}

	@Override
	public Donation getdetails(long id) {
		String query="select v.name as vol_name,v.mobileno as v_mobileno,v.email as v_email,"
				+ "d.id as id,d.donation_qty as donation_qty,d.donation_date "
				+ "as donation_date,d.donation_type as donation_type,v.photo as photo,"
				+ "u.name as uname,u.mobileno as u_mobileno,u.email as u_email "
				+ "From donation d inner join user u ON d.user_id=u.user_id inner join"
				+ " volunteer v ON d.vol_id=v.vol_id "
				+ "WHERE d.isdelete=0 "
				+ "AND d.id="+id;
		List<Donation> list=DbUtility.getListData(query, Donation.class);
		return list.get(0);
	}

}

package com.unfoldhappiness_user.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_user.dao.DonationDao;
import com.unfoldhappiness_user.model.Donation;
import com.unfoldhappiness_user.util.DbUtility;
@Repository("donationdao")
public class DonationDaoImpl extends GenericDaoImpl<Donation> implements DonationDao {

	public List<Donation> getAll(long id) {
		String query="select d.id as id,v.name as vol_name,d.donation_qty as donation_qty,"
				+ "d.donation_address as donation_address,d.status as status,"
				+ "d.donation_date as donation_date,d.donation_type as donation_type "
				+ "From donation d inner join "
				+ "volunteer v ON d.vol_id=v.vol_id"
				+ " WHERE d.isdelete=0 "
				+ "AND d.user_id="+id;
		List<Donation> list=DbUtility.getListData(query, Donation.class);		
		return list;
	}

	public Donation getVol(long id) {
		String query="select v.name as vol_name,v.mobileno as mobileno,v.photo as photo,d.status as status "
				+ "From volunteer v inner join "
				+ "donation d ON d.vol_id=v.vol_id"
				+ " WHERE d.isdelete=0 "
				+ "AND d.id="+id;
		List<Donation> list=DbUtility.getListData(query, Donation.class);
		return list.get(0);
	}

}




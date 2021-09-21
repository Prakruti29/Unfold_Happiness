package com.unfoldhappiness_admin.daoimpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_admin.dao.NgoDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Event;
import com.unfoldhappiness_admin.model.Ngo;
import com.unfoldhappiness_admin.util.DbUtility;

@Repository("ngoDao")
public class NgoDaoImpl extends GenericDaoImpl<Ngo> implements NgoDao {

	@Override
	public int saveNgo(Ngo ngo) {
		//ngo.setService_id(1);
		super.saveObject(ngo);
		return 0;
	}

	@Override
	public List<Ngo> getAll() {
		List<Ngo> list = (List<Ngo>) super.getByQuery("FROM Ngo n WHERE n.isdelete = 0");
		return list;
	}

	@Override
	public Ngo getById(long id) {
		String query="select n.id as id,n.name as name,n.email as email,"
				+ "n.address as address,n.mobileno as mobileno,n.do_establish as do_establish,"
				+ "n.service as service,n.website as website,n.area_name as area_name,ar.area_name as area "
				+ "From ngo n inner join area_master ar ON "
				+ " n.area_name=ar.area_id WHERE n.isdelete=0 AND n.id="+id;
		
		List<Ngo> list=DbUtility.getListData(query, Ngo.class);
		 return list.get(0); 
	}
	@Override
	public void editngo(Ngo ngo) {
		// TODO Auto-generated method stub
		super.updateObject(ngo);
	}

	@Override
	public Boolean deleteNgo(long id) {
		// TODO Auto-generated method stub
		Ngo ngo =super.getById(Ngo.class, id); 
		  ngo.setIsdelete(1); 
		  return super.updateObject(ngo).getId()>0;
	}

	@Override
	public int emailCheck(Ngo ngo) {
		String query = "FROM Ngo where email='"+ngo.getEmail()+"' and isdelete=0";
		List<Ngo> list = super.getByQuery(query);
		return list.size();
	}

	

}

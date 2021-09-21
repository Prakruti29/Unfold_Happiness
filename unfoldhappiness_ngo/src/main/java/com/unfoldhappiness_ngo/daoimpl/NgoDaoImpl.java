package com.unfoldhappiness_ngo.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_ngo.dao.NgoDao;
import com.unfoldhappiness_ngo.model.Ngo;


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
		// TODO Auto-generated method stub
		 return super.getById(Ngo.class, id); 
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

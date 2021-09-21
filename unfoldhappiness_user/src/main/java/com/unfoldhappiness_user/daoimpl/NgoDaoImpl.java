package com.unfoldhappiness_user.daoimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.unfoldhappiness_user.dao.NgoDao;
import com.unfoldhappiness_user.model.Ngo;


@Repository("ngoDao")
@SessionAttributes("user")
public class NgoDaoImpl extends GenericDaoImpl<Ngo> implements NgoDao {

	@Autowired
	HttpSession session;
	
	public int saveNgo(Ngo ngo) {
		//ngo.setService_id(1);
		super.saveObject(ngo);
		return 0;
	}
	public int emailCheck(Ngo ngo) {
		String query = "FROM Ngo where email='"+ngo.getEmail()+"' and isdelete=0";
		List<Ngo> list = super.getByQuery(query);
		return list.size();
	}
	public Ngo loginCheck(Ngo ngo) {
		String query = "FROM Ngo where isdelete=0 and email='"+ngo.getEmail()+"' and password='"+ngo.getPassword()+"'";
		List<Ngo> list = super.getByQuery(query);
		if(list.size()==0)
			return null;
		return list.get(0);
	}
	public Ngo forgotpassword(Ngo ngo) {
		Criteria criteria = getSession().createCriteria(Ngo.class);
		criteria.add(Restrictions.eq("email", ngo.getEmail()));
		Ngo us = (Ngo) criteria.uniqueResult();
		return us;
	}
	public Ngo changepassword(Ngo ngo) {
		Ngo sNgo = (Ngo) session.getAttribute("user");
		String query = "FROM Ngo where email='"+sNgo.getEmail()+"'";
		List<Ngo> list = super.getByQuery(query);
		if(list.size()==0)
			return null;
		return list.get(0);
	}
	public void updatepassword(Ngo ngo) {
		getSession().saveOrUpdate(ngo);
		
	}

	
	

}

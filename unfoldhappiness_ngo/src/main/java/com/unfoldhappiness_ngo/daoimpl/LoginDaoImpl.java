package com.unfoldhappiness_ngo.daoimpl;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.unfoldhappiness_ngo.dao.LoginDao;
import com.unfoldhappiness_ngo.model.Ngo;

@Repository("loginDao")
@SessionAttributes("ngo")
public class LoginDaoImpl extends GenericDaoImpl<Ngo> implements LoginDao   {

		@Autowired
		HttpSession session;
		
		public Ngo loginCheck(Ngo ngo) {
		String query = "FROM Ngo where isdelete=0 and email='"+ngo.getEmail()+"' and password='"+ngo.getPassword()+"'";
		List<Ngo> list = super.getByQuery(query);
		if(list.size()==0)
			return null;
		return list.get(0);
	}

		@Override
		public Ngo forgotpassword(Ngo ngo) {
			Criteria criteria = getSession().createCriteria(Ngo.class);
			criteria.add(Restrictions.eq("email", ngo.getEmail()));
			Ngo us = (Ngo) criteria.uniqueResult();
			return us;
		}

		@Override
		public Ngo changepassword(Ngo ngo) {
			Ngo sNgo = (Ngo) session.getAttribute("ngo");
			String query = "FROM Admin where email='"+sNgo.getEmail()+"'";
			List<Ngo> list = super.getByQuery(query);
			if(list.size()==0)
				return null;
			return list.get(0);
		}
		

}

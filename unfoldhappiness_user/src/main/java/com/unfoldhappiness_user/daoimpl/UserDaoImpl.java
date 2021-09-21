package com.unfoldhappiness_user.daoimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_user.dao.UserDao;

import com.unfoldhappiness_user.model.User;

@Repository("userDao")
@SessionAttributes("user")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{

	@Autowired
	HttpSession session;
	
	public int saveUser(User user) {
		User sUser = (User) session.getAttribute("user");
		user.setCreatedBy(user.getId());
		
	
		super.saveObject(user);
		return 0;
	}

	public int emailCheck(User user) {
		String query = "FROM User where email='"+user.getEmail()+"' and isdeleted=0";
		List<User> list = super.getByQuery(query);
		return list.size();
	}

	public User loginCheck(User user) {
		String query = "FROM User where isdeleted=0 and email='"+user.getEmail()+"' and password='"+user.getPassword()+"'";
		List<User> list = super.getByQuery(query);
		if(list.size()==0)
			return null;
		return list.get(0);
	}

}

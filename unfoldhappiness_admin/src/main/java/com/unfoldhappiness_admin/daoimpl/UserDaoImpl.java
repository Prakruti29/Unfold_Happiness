package com.unfoldhappiness_admin.daoimpl;

import java.util.List;

import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import com.unfoldhappiness_admin.dao.UserDao;
import com.unfoldhappiness_admin.model.Ngo;
import com.unfoldhappiness_admin.model.User;

@Repository("userdao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Override
	public List<User> getAll() {
		
		List<User> list=(List<User>)super.getByQuery("FROM User u WHERE u.isdeleted=0");
		return list;
		
	}
	@Override
	public int saveuser(User user) {
		super.saveObject(user);
		return 0;
	}
	
	@Override
	public Boolean deleteUser(long id) {
		
		User user = super.getById(User.class, id);
		user.setIsdeleted(1);
		return super.updateObject(user).getId()>0;
	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		super.updateObject(user);
	}

	@Override
	public User getById(long id) {
		// TODO Auto-generated method stub
		return super.getById(User.class, id);
	}
	@Override
	public int emailCheck(User user) {
		String query = "FROM User where email='"+user.getEmail()+"' and isdeleted=0";
		List<User> list = super.getByQuery(query);
		return list.size();
	}
	


	

	

	
}

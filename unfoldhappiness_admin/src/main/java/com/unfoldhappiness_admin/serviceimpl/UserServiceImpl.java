package com.unfoldhappiness_admin.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.unfoldhappiness_admin.dao.UserDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Ngo;
import com.unfoldhappiness_admin.model.User;
import com.unfoldhappiness_admin.service.UserService;
import com.unfoldhappiness_admin.util.Mailer;
import com.unfoldhappiness_admin.util.PasswordEncode;
import com.unfoldhappiness_admin.util.RandomString;

@Service("userservice")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userdao;
	
	@Autowired
	HttpSession session;
	
	
	@Override
	public int addUser(User user) {
		String password = RandomString.getAlphaNumericString(8);
		Admin ad = (Admin) session.getAttribute("admin");
		user.setCreatedBy(ad.getId());
		user.setModifyBy(ad.getId());
		user.setCreatedDate(new Date(System.currentTimeMillis()));
		user.setModifyDate(new Date(System.currentTimeMillis()));
		
        int result = userdao.emailCheck(user);
		if(result!=0)
		{
			return 1;
		}
		
		if (user != null) {
			//admin.setPassword(password);
			String pass=PasswordEncode.passwordEncode(password);
			user.setPassword(pass);
		}
		User u = userdao.saveObject(user);
		
		  if(u!=null) {
			  Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234",user.getEmail(), "Hello,How r u?", 
					  password); 
			  }
		  return 0;
	}
	@Override
	public List<User> getAll() {
		return userdao.getAll();
	}
	@Override
	public Boolean deleteUser(long id) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(id);
	}
	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		 userdao.editUser(user);
	}
	@Override
	public User getById(long id) {
		// TODO Auto-generated method stub
		return userdao.getById(id);
	}
	
	
}

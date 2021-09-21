package com.unfoldhappiness_user.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_user.dao.UserDao;

import com.unfoldhappiness_user.model.User;
import com.unfoldhappiness_user.service.UserService;
import com.unfoldhappiness_user.util.Mailer;
import com.unfoldhappiness_user.util.PasswordEncode;
import com.unfoldhappiness_user.util.RandomString;

@Service("userservice")
@Transactional
@SessionAttributes("user")
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao userDao;
	
	@Autowired
	HttpSession session;
	
	public int addUser(User user) {
		String password = RandomString.getAlphaNumericString(8);
        int result =userDao.emailCheck(user);
		if(result!=0)
		{
			return 1;
		}
		
		if (user != null) {
			//admin.setPassword(password);
			String pass=PasswordEncode.passwordEncode(password);
			user.setPassword(pass);
		}
		User u = userDao.saveObject(user);
		
		  if(u!=null) {
			  Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234",user.getEmail(), "Hello,How r u?", 
					  password); 
			  }
		
		return 0;
	}


	}


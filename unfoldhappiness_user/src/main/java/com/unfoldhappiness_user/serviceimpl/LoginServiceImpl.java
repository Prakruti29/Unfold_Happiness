package com.unfoldhappiness_user.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_user.dao.NgoDao;
import com.unfoldhappiness_user.dao.UserDao;
import com.unfoldhappiness_user.dao.VolunteerDao;
import com.unfoldhappiness_user.model.Ngo;
import com.unfoldhappiness_user.model.User;
import com.unfoldhappiness_user.model.Volunteer;
import com.unfoldhappiness_user.service.LoginService;
import com.unfoldhappiness_user.util.Mailer;
import com.unfoldhappiness_user.util.PasswordEncode;
import com.unfoldhappiness_user.util.RandomString;

@Service("loginService")
@Transactional
@SessionAttributes("user")
public class LoginServiceImpl implements LoginService{

	@Autowired
	NgoDao ngoDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	VolunteerDao volDao;
	
	@Autowired
	HttpSession session;
	
	public Ngo login(Ngo ngo) {
		String password = ngo.getPassword();
		ngo.setPassword(PasswordEncode.passwordEncode(password));
		return ngoDao.loginCheck(ngo);
	}

	public Ngo forgotPassword(Ngo ngo) {
		Ngo n = ngoDao.forgotpassword(ngo);
		if (n.getPassword() != null) 
		{
			int n1 = 8;
			String password = RandomString.getAlphaNumericString(n1);
			n.setPassword(PasswordEncode.passwordEncode(password));
			ngoDao.updateObject(n);
			Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234", ngo.getEmail(), "Hello,How r u?", password);
		}
		return n;
	}

	public Ngo changePass(Ngo ngo) {
		if(ngo.getConpassword().equals(ngo.getNpassword()))
		{	
			ngo.setPassword(PasswordEncode.passwordEncode(ngo.getPassword()));
			Ngo sNgo = (Ngo) session.getAttribute("ngo");
			if (!(sNgo.getPassword().equals(ngo.getNpassword()))) 
			{
				sNgo.setPassword(PasswordEncode.passwordEncode(ngo.getNpassword()));
				ngoDao.updateObject(sNgo);
				return sNgo;
			}
		}
		return null;
	}

	public User login(User user) {
		String password = user.getPassword();
		user.setPassword(PasswordEncode.passwordEncode(password));
		return userDao.loginCheck(user);
	}

	public Volunteer login(Volunteer vol) {
		String password = vol.getPassword();
		vol.setPassword(PasswordEncode.passwordEncode(password));
		return volDao.loginCheck(vol);
	}

}

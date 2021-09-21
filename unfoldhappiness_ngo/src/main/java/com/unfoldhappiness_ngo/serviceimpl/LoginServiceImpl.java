package com.unfoldhappiness_ngo.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.unfoldhappiness_ngo.dao.LoginDao;
import com.unfoldhappiness_ngo.model.Ngo;
import com.unfoldhappiness_ngo.service.LoginService;
import com.unfoldhappiness_ngo.util.Mailer;
import com.unfoldhappiness_ngo.util.PasswordEncode;
import com.unfoldhappiness_ngo.util.RandomString;


@Service("loginService")
@Transactional
@SessionAttributes("ngo")
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	@Autowired
	HttpSession session;
	
	public Ngo login(Ngo ngo) {
		String password = ngo.getPassword();
		ngo.setPassword(PasswordEncode.passwordEncode(ngo.getPassword()));
		return loginDao.loginCheck(ngo);
	}


	@Override
	public Ngo forgotPassword(Ngo ngo) {
		Ngo n= loginDao.forgotpassword(ngo);
		if (n.getPassword() != null) 
		{
			int no = 8;
			String password = RandomString.getAlphaNumericString(no);
			n.setPassword(PasswordEncode.passwordEncode(password));
			loginDao.updateObject(n);
			Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234", ngo.getEmail(), "Hello,How r u?", password);
		}
		return n;
	}


	@Override
	public Ngo changePass(Ngo ngo) {
		if(ngo.getConpassword().equals(ngo.getNpassword()))
		{	
			ngo.setPassword(PasswordEncode.passwordEncode(ngo.getPassword()));
			Ngo sNgo = (Ngo) session.getAttribute("ngo");
			if (!(sNgo.getPassword().equals(ngo.getNpassword()))) 
			{
				sNgo.setPassword(PasswordEncode.passwordEncode(ngo.getNpassword()));
				loginDao.updateObject(sNgo);
				//Mailer.send("maidinindia03@gmail.com", "unfoldhappiness_admin@41926", admin.getEmailId(), "Hello,How r u?", a.getPassword());
				return sNgo;
			}
		}
		return null;
	}
}

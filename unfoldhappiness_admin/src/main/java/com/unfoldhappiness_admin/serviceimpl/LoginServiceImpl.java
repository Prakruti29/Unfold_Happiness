package com.unfoldhappiness_admin.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_admin.dao.AdminDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.service.LoginService;
import com.unfoldhappiness_admin.util.Mailer;
import com.unfoldhappiness_admin.util.PasswordEncode;
import com.unfoldhappiness_admin.util.PasswordEncrypt;
import com.unfoldhappiness_admin.util.RandomString;

@Service("loginService")
@Transactional
@SessionAttributes("admin")
public class LoginServiceImpl implements LoginService{

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	HttpSession session;
	
	@Override
	public Admin login(Admin admin) {
		String password = admin.getPassword();
		admin.setPassword(PasswordEncode.passwordEncode(admin.getPassword()));
		return adminDao.loginCheck(admin);
		
	}
	@Override
	public Admin forgotPassword(Admin admin) 
	{
		Admin a = adminDao.forgotpassword(admin);
		if (a.getPassword() != null) 
		{
			int n = 8;
			String password = RandomString.getAlphaNumericString(n);
			a.setPassword(PasswordEncode.passwordEncode(password));
			adminDao.updateObject(a);
			Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234", admin.getEmail(), "Hello,How r u?", password);
		}
		return a;

	}
	@Override
	public Admin changePass(Admin admin) 
	{
		if(admin.getConpassword().equals(admin.getNpassword()))
		{	
			admin.setPassword(PasswordEncode.passwordEncode(admin.getPassword()));
//			Admin a = adminDao.changepassword(admin);
//			if(a==null)
//				return null;
			Admin sAdmin = (Admin) session.getAttribute("admin");
			if (!(sAdmin.getPassword().equals(admin.getNpassword()))) 
			{
				sAdmin.setPassword(PasswordEncode.passwordEncode(admin.getNpassword()));
				adminDao.updateObject(sAdmin);
				//Mailer.send("maidinindia03@gmail.com", "unfoldhappiness_admin@41926", admin.getEmailId(), "Hello,How r u?", a.getPassword());
				return sAdmin;
			}
		}
		return null;
	}
}

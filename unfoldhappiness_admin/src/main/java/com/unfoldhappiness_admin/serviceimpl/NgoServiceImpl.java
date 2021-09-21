package com.unfoldhappiness_admin.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_admin.dao.NgoDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Ngo;
import com.unfoldhappiness_admin.service.NgoService;
import com.unfoldhappiness_admin.util.Mailer;
import com.unfoldhappiness_admin.util.PasswordEncode;
import com.unfoldhappiness_admin.util.RandomString;

@Service("ngoservice")
@Transactional
@SessionAttributes("admin")
public class NgoServiceImpl implements NgoService {

	@Autowired
	NgoDao ngoDao;

	@Autowired
	HttpSession session;
	
	@Override
	public int addNgo(Ngo ngo) {
		String password = RandomString.getAlphaNumericString(8);
        int result = ngoDao.emailCheck(ngo);
		if(result!=0)
		{
			return 1;
		}
		
		if (ngo != null) {
			//admin.setPassword(password);
			Admin ad = (Admin) session.getAttribute("admin");
			ngo.setCreatedBy(ad.getId());
			ngo.setModifyBy(ad.getId());
			ngo.setCreatedDate(new Date(System.currentTimeMillis()));
			ngo.setModifyDate(new Date(System.currentTimeMillis()));
			
			String pass=PasswordEncode.passwordEncode(password);
			ngo.setPassword(pass);
		}
		Ngo n = ngoDao.saveObject(ngo);
		
		  if(n!=null) {
			  Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234",ngo.getEmail(), "Hello,How r u?", 
					  password); 
			  }
		
		return 0;
	}

	@Override
	public List<Ngo> getAll() {
		// TODO Auto-generated method stub
		return ngoDao.getAll();
	}

	@Override
	public Ngo getById(long id) {
		// TODO Auto-generated method stub
		return ngoDao.getById(id);
	}

	@Override
	public void editngo(Ngo ngo) {
		// TODO Auto-generated method stub
		Admin ad = (Admin) session.getAttribute("admin");
		ngo.setModifyBy(ad.getId());
		ngo.setModifyDate(new Date(System.currentTimeMillis()));
		ngoDao.editngo(ngo);
	}

	@Override
	public Boolean deleteNgo(long id) {
		// TODO Auto-generated method stub
		return ngoDao.deleteNgo(id);
	}



}

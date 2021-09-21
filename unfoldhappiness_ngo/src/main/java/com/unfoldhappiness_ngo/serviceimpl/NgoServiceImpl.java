package com.unfoldhappiness_ngo.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_ngo.dao.NgoDao;
import com.unfoldhappiness_ngo.model.Ngo;
import com.unfoldhappiness_ngo.service.NgoService;
import com.unfoldhappiness_ngo.util.Mailer;
import com.unfoldhappiness_ngo.util.PasswordEncode;
import com.unfoldhappiness_ngo.util.RandomString;


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
			Ngo ngo1 = (Ngo) session.getAttribute("ngo");
			ngo1.setCreatedBy(ngo.getId());
			ngo1.setModifyBy(ngo.getId());
			ngo1.setCreatedDate(new Date(System.currentTimeMillis()));
			ngo1.setModifyDate(new Date(System.currentTimeMillis()));
			
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
		Ngo ngo1 = (Ngo) session.getAttribute("ngo");
		ngo1.setModifyBy(ngo1.getId());
		ngo1.setModifyDate(new Date(System.currentTimeMillis()));
		ngoDao.editngo(ngo1);
	}

	@Override
	public Boolean deleteNgo(long id) {
		// TODO Auto-generated method stub
		return ngoDao.deleteNgo(id);
	}



}

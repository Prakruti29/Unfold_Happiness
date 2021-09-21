package com.unfoldhappiness_user.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unfoldhappiness_user.dao.NgoDao;
import com.unfoldhappiness_user.model.Ngo;
import com.unfoldhappiness_user.service.NgoService;
import com.unfoldhappiness_user.util.Mailer;
import com.unfoldhappiness_user.util.PasswordEncode;
import com.unfoldhappiness_user.util.RandomString;


@Service("ngoservice")
@Transactional
public class NgoServiceImpl implements NgoService {

	@Autowired
	NgoDao ngoDao;

	public int addNgo(Ngo ngo) {
		String password = RandomString.getAlphaNumericString(8);
        int result = ngoDao.emailCheck(ngo);
		if(result!=0)
		{
			return 1;
		}
		
		if (ngo != null) {
			//admin.setPassword(password);
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

	


}

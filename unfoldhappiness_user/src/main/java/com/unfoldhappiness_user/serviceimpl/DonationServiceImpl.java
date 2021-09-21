package com.unfoldhappiness_user.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.unfoldhappiness_user.dao.DonationDao;
import com.unfoldhappiness_user.model.Donation;
import com.unfoldhappiness_user.model.User;
import com.unfoldhappiness_user.model.Volunteer;
import com.unfoldhappiness_user.service.DonationService;
import com.unfoldhappiness_user.service.VolunteerService;
import com.unfoldhappiness_user.util.FTPUtils;
import com.unfoldhappiness_user.util.Mailer;


@Service("donationservice")
@Transactional
@SessionAttributes("user")

public class DonationServiceImpl implements DonationService {
	private static String UPLOADED_FOLDER1 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_user\\resources\\images\\volunteer\\profileImage"+File.separator;
	
	@Autowired
	DonationDao donationdao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	VolunteerService volservice;

	public int addDonation(Donation donation) {
		int area_id=donation.getDonation_area();
		donationdao.saveObject(donation);
		List<Volunteer> volList=volservice.getAll(area_id);
		User u =(User) session.getAttribute("user");
		String msg="Hello Volunteer!! There is one request by the following user:\n\n";
		String name=u.getName();
		String address=u.getAddress();
		String msg1="If you are willing to accept click the link below\n\n";
		String link="http://localhost:8081/unfoldhappiness_volunteer/volunteer/vollogin";
		String finalmsg=msg+"Name:"+name+"\n"+"Address:"+address+"\n"+msg1+link;
		for(Volunteer v : volList){
			Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234", v.getEmail(), "Hello,How r u?", finalmsg);
		}
		return 0;
	}

	public List<Donation> getAll(long id) {
		
		return donationdao.getAll(id);
	}

	public Donation getVol(long id) {
		Donation donation=donationdao.getVol(id);
		String newPP = donation.getPhoto();
		File ProfileImage = new File(UPLOADED_FOLDER1+newPP);
		DiskFileItem fileItem1 = new DiskFileItem("ProfileImage", "text/plain", false, ProfileImage.getName(), (int) ProfileImage.length() , ProfileImage.getParentFile());
		
	    try {
			fileItem1.getOutputStream();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    MultipartFile MPProfileImage = new CommonsMultipartFile(fileItem1);
	    if(!ProfileImage.exists())
		{
			FTPUtils.download(newPP, UPLOADED_FOLDER1+newPP);
			donation.setProfileImage(MPProfileImage);
		}

		return donation;
	}

}

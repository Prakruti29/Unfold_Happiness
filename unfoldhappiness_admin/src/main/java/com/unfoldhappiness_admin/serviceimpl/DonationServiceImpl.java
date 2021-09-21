package com.unfoldhappiness_admin.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unfoldhappiness_admin.dao.DonationDao;
import com.unfoldhappiness_admin.model.Donation;
import com.unfoldhappiness_admin.service.DonationService;
import com.unfoldhappiness_admin.util.FTPUtils;


@Service("donationservice")
@Transactional
public class DonationServiceImpl implements DonationService {

	@Autowired
	DonationDao donationdao;
	
	private static String UPLOADED_FOLDER1 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_admin\\resources\\images\\volunteer\\profileImage"+File.separator;
	
	@Override
	public List<Donation> getAll() {
		
		return donationdao.getAll();
	}

	@Override
	public Donation getDetails(long id) {
		// TODO Auto-generated method stub
		Donation donation= donationdao.getdetails(id);
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



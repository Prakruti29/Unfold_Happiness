package com.unfoldhappiness_admin.serviceimpl;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unfoldhappiness_admin.dao.VolunteerDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Volunteer;
import com.unfoldhappiness_admin.service.VolunteerService;
import com.unfoldhappiness_admin.util.FTPUtils;
import com.unfoldhappiness_admin.util.FileUtils;
import com.unfoldhappiness_admin.util.Mailer;
import com.unfoldhappiness_admin.util.PasswordEncode;
import com.unfoldhappiness_admin.util.RandomString;

@Service("volservice")
@SessionAttributes("admin")
public class VolunteerServiceImpl implements VolunteerService{

	@Autowired
	VolunteerDao voldao;
	
	@Autowired
	HttpSession session;
	
	
	private static String UPLOADED_FOLDER1 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_admin\\resources\\images\\volunteer\\profileImage"+File.separator; 
	private static String UPLOADED_FOLDER2 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_admin\\resources\\images\\volunteer\\idProof"+File.separator;
	
	@Override
	public long addVol(Volunteer volunteer, MultipartFile file1, MultipartFile file2) {
		
		String newPP = FileUtils.getFileName(file1.getOriginalFilename());
		String newIP = FileUtils.getFileName(file2.getOriginalFilename());
		volunteer.setPhoto(newPP);
		volunteer.setProof(newIP);
		volunteer.setProfileImage(file1);
		volunteer.setIdProof(file2);
		Admin ad = (Admin) session.getAttribute("admin");
		volunteer.setCreatedBy(ad.getId());
		volunteer.setModifyBy(ad.getId());
		volunteer.setCreatedDate(new Date(System.currentTimeMillis()));
		volunteer.setModifyDate(new Date(System.currentTimeMillis()));
		
		String password = RandomString.getAlphaNumericString(8);
        int result = voldao.emailCheck(volunteer);
		if(result!=0)
		{
			return 1;
		}
		if (volunteer != null) {
			//admin.setPassword(password);
			String pass=PasswordEncode.passwordEncode(password);
			volunteer.setPassword(pass);
		}
		Volunteer v = voldao.saveObject(volunteer);
		
		  if(v!=null) {
			  Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234",volunteer.getEmail(), "Hello,How r u?", 
					  password);
			  FileUtils.uploadFile1(file1, UPLOADED_FOLDER1+newPP);
			  FileUtils.uploadFile1(file2, UPLOADED_FOLDER2+newIP);
			  FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newPP, newPP);
			  FTPUtils.uploadOnFTP(UPLOADED_FOLDER2+newIP, newIP);
			  }
		 
		return 0;
	}


	@Override
	public List<Volunteer> getAll() {
		List<Volunteer> volunteerList = voldao.getAll();
		for(Volunteer v : volunteerList)
		{
			String newP1 = v.getPhoto();
			String newP2 = v.getProof();
			File Image1 = new File(UPLOADED_FOLDER1+newP1);
			File Image2 = new File(UPLOADED_FOLDER2+newP2);
			DiskFileItem fileItem1 = new DiskFileItem("Image1", "text/plain", false, Image1.getName(), (int) Image1.length() , Image1.getParentFile());
			DiskFileItem fileItem2 = new DiskFileItem("Image2", "text/plain", false, Image2.getName(), (int) Image2.length() , Image2.getParentFile());
		   try {
				fileItem1.getOutputStream();
				fileItem2.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    MultipartFile MPImage1 = new CommonsMultipartFile(fileItem1);
		    MultipartFile MPImage2 = new CommonsMultipartFile(fileItem2);
			if(!Image1.exists())
			{
				FTPUtils.download(newP1, UPLOADED_FOLDER1+newP1);
				v.setProfileImage(MPImage1);
			}
			if(!Image2.exists())
			{
				FTPUtils.download(newP2, UPLOADED_FOLDER2+newP2);
				v.setIdProof(MPImage2);
			}
		}
		return  volunteerList;
	
		
	}


	@Override
	public Volunteer getById(long id) {
		Volunteer vol = voldao.getById(id);
		String newPP = vol.getPhoto();
		String newIP = vol.getProof();
		File ProfileImage = new File(UPLOADED_FOLDER1+newPP);
		File IdProofImage = new File(UPLOADED_FOLDER2+newIP);
		DiskFileItem fileItem1 = new DiskFileItem("ProfileImage", "text/plain", false, ProfileImage.getName(), (int) ProfileImage.length() , ProfileImage.getParentFile());
		DiskFileItem fileItem2 = new DiskFileItem("IdProofImage", "text/plain", false, IdProofImage.getName(), (int) IdProofImage.length() , IdProofImage.getParentFile());
	    try {
			fileItem1.getOutputStream();
			fileItem2.getOutputStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    MultipartFile MPProfileImage = new CommonsMultipartFile(fileItem1);
	    MultipartFile MPIdProofImage = new CommonsMultipartFile(fileItem2);



		if(!ProfileImage.exists())
		{
			FTPUtils.download(newPP, UPLOADED_FOLDER1+newPP);
			vol.setProfileImage(MPProfileImage);
		}
		if(!IdProofImage.exists())
		{
			FTPUtils.download(newIP, UPLOADED_FOLDER2+newIP);
			vol.setIdProof(MPIdProofImage);
		}
		return vol;

	}


	@Override
	public long updateVolunteer(Volunteer volunteer, MultipartFile file1, MultipartFile file2) {
		volunteer.setPhoto(FileUtils.getFileName(file1.getOriginalFilename()));
		volunteer.setProof(file2.getOriginalFilename());
		Admin ad = (Admin) session.getAttribute("admin");
		volunteer.setModifyBy(ad.getId());
		volunteer.setModifyDate(new Date(System.currentTimeMillis()));
		voldao.updateObject(volunteer);
		String newPP = FileUtils.getFileName(file1.getOriginalFilename());
		FileUtils.uploadFile1(file1, UPLOADED_FOLDER1+newPP);
		FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newPP, newPP);
		return 0; 
		}


	@Override
	public int deleteVolunteer(long id) {
		// TODO Auto-generated method stub
		return voldao.deleteVolunteer(id);
	}

}

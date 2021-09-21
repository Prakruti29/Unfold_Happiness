package com.unfoldhappiness_user.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unfoldhappiness_user.dao.VolunteerDao;
import com.unfoldhappiness_user.model.Volunteer;
import com.unfoldhappiness_user.service.VolunteerService;
import com.unfoldhappiness_user.util.FTPUtils;
import com.unfoldhappiness_user.util.FileUtils;
import com.unfoldhappiness_user.util.Mailer;
import com.unfoldhappiness_user.util.PasswordEncode;
import com.unfoldhappiness_user.util.RandomString;

@Service("volservice")
@SessionAttributes("volunteer")
public class VolunteerServiceImpl implements VolunteerService {

	@Autowired
	VolunteerDao voldao;
	
	@Autowired
	HttpSession session;
	
	private static String UPLOADED_FOLDER1 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_user\\resources\\images\\volunteer\\profileImage"+File.separator; 
	private static String UPLOADED_FOLDER2 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_user\\resources\\images\\volunteer\\idProof"+File.separator;
	
	public long addVol(Volunteer volunteer, MultipartFile file1, MultipartFile file2) {
		String newPP = FileUtils.getFileName(file1.getOriginalFilename());
		String newIP = FileUtils.getFileName(file2.getOriginalFilename());
		volunteer.setPhoto(newPP);
		volunteer.setProof(newIP);
		volunteer.setProfileImage(file1);
		volunteer.setIdProof(file2);
		session.setAttribute("vol", volunteer);
		
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

	public List<Volunteer> getAll(int area_id) {
		List<Volunteer> volunteerList = voldao.getAll(area_id);
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

}

package com.unfoldhappiness_admin.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unfoldhappiness_admin.dao.AdminDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Product;
import com.unfoldhappiness_admin.service.AdminService;
import com.unfoldhappiness_admin.util.FTPUtils;
import com.unfoldhappiness_admin.util.FileUtils;
import com.unfoldhappiness_admin.util.Mailer;
import com.unfoldhappiness_admin.util.PasswordEncode;
import com.unfoldhappiness_admin.util.PasswordEncrypt;
import com.unfoldhappiness_admin.util.RandomString;

@Service("service")
@Transactional
@SessionAttributes("admin")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	HttpSession session;
	
	private static String UPLOADED_FOLDER1 ="H:\\Tools\\Tomcat 9.0\\webapps\\unfoldhappiness_admin\\resources\\images\\admin\\profileImage"+File.separator;

	@Override
	public long addAdmin(Admin admin, MultipartFile file) {
		
		String newPP = FileUtils.getFileName(file.getOriginalFilename());
		admin.setPhoto(newPP);
		admin.setProfileImage(file);
		Admin ad = (Admin) session.getAttribute("admin");
		admin.setCreatedBy(ad.getId());
		admin.setModifyBy(ad.getId());
		admin.setCreatedDate(new Date(System.currentTimeMillis()));
		admin.setModifyDate(new Date(System.currentTimeMillis()));
		String password = RandomString.getAlphaNumericString(8);
        int result = adminDao.emailCheck(admin);
		if(result!=0)
		{
			return 1;
		}
		
		if (admin != null) {
			//admin.setPassword(password);
			String pass=PasswordEncode.passwordEncode(password);
			admin.setPassword(pass);
		}
		Admin a = adminDao.saveObject(admin);
		
		  if(a!=null) {
			  Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234",admin.getEmail(), "Hello,How r u?", 
					  password);
			  FileUtils.uploadFile1(file, UPLOADED_FOLDER1+newPP);
			  FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newPP, newPP);
			  
			  
		  }
		 
		
		return 0;
	}

	@Override
	public Admin editAdmin(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Admin> getAll() {
		List<Admin> adminList = adminDao.getAll();
		for(Admin a : adminList)
		{
			String newPP = a.getPhoto();
			File ProfileImage = new File(UPLOADED_FOLDER1+newPP);
			DiskFileItem fileItem1 = new DiskFileItem("ProfileImage", "text/plain", false, ProfileImage.getName(), (int) ProfileImage.length() , ProfileImage.getParentFile());
			
		   try {
				fileItem1.getOutputStream();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    MultipartFile MPProfileImage = new CommonsMultipartFile(fileItem1);
		   
			if(!ProfileImage.exists())
			{
				FTPUtils.download(newPP, UPLOADED_FOLDER1+newPP);
				a.setProfileImage(MPProfileImage);
			}
			
		}
		return adminList;

	}

	@Override
	public long updateAdmin(Admin admin, MultipartFile file1) {
		admin.setPhoto(FileUtils.getFileName(file1.getOriginalFilename()));
		Admin ad = (Admin) session.getAttribute("admin");
		admin.setModifyBy(ad.getId());
		admin.setModifyDate(new Date(System.currentTimeMillis()));
		adminDao.updateObject(admin);
		String newP1 = FileUtils.getFileName(file1.getOriginalFilename());
		FileUtils.uploadFile1(file1, UPLOADED_FOLDER1+newP1);
		FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newP1, newP1);
		return 0;	
		}

	@Override
	public Admin getById(long id) {
		Admin admin = adminDao.getById(id);
		String newPP = admin.getPhoto();
		File ProfileImage = new File(UPLOADED_FOLDER1+newPP);
		DiskFileItem fileItem1 = new DiskFileItem("ProfileImage", "text/plain", false, ProfileImage.getName(), (int) ProfileImage.length() , ProfileImage.getParentFile());
		
	    try {
			fileItem1.getOutputStream();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    MultipartFile MPProfileImage = new CommonsMultipartFile(fileItem1);
	    if(!ProfileImage.exists())
		{
			FTPUtils.download(newPP, UPLOADED_FOLDER1+newPP);
			admin.setProfileImage(MPProfileImage);
		}

		
		return admin;
	}

	@Override
	public Boolean deleteAdmin(long id) {
		
		return adminDao.deleteAdmin(id);
	}

	
}

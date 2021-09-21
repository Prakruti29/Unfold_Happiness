package com.unfoldhappiness_admin.daoimpl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.unfoldhappiness_admin.dao.AdminDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.util.DbUtility;
import com.unfoldhappiness_admin.util.FileUtils;
@Repository("adminDao")
@SessionAttributes("admin")
public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao {
	
	@Override
	public long addAdmin(Admin admin) {
		Admin newAdmin=new Admin();
		if(admin.getId()>0)
		{
			newAdmin=super.updateObject(admin);
		}
		else
		{	
			newAdmin = super.saveObject(admin);
		}
		return newAdmin.getId();
	}

	@Override
	public Admin editAdmin(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean deleteAdmin(long id) {
		
		Admin user = super.getById(Admin.class, id);
		user.setIsdelete(1);
		return super.updateObject(user).getId()>0;
		
		
		
	}
	@Override
	public List<Admin> getAll() {
		List<Admin> list=(List<Admin>) super.getByQuery("FROM Admin a WHERE a.isdelete = 0");
		
		return list;
	}
	@Autowired
	HttpSession session;
	
	@Override
	public Admin loginCheck(Admin admin) {
		String query = "FROM Admin where isdelete=0 and email='"+admin.getEmail()+"' and password='"+admin.getPassword()+"'";
		List<Admin> list = super.getByQuery(query);
		if(list.size()==0)
			return null;
		return list.get(0);
	}

	@Override
	public int updateAdmin(Admin admin,MultipartFile file1) {
		// TODO Auto-generated method stub
		admin.setPhoto(FileUtils.getFileName(file1.getOriginalFilename()));
		super.updateObject(admin);
		//FileUtils.uploadFile1(file1, "H://testFiles//");
		return 0;
	}
	
	@Override
	public Admin getById(long id) {
		String query="select a.id as id,a.name as name,a.email as email,a.gender as gender,a.mobileno as mobileno,"
				+ "a.address as address,a.dob as dob,a.photo as photo,a.area_name as area_name,ar.area_name as area "
				+ "From admintable a inner join area_master ar ON "
				+ "a.area_name=ar.area_id "
				+ "WHERE a.isdelete=0 AND a.id="+id;
		List<Admin> list = DbUtility.getListData(query, Admin.class);
		return list.get(0);
		
	}
	@Override
	public int emailCheck(Admin admin) {
		String query = "FROM Admin where email='"+admin.getEmail()+"' and isdelete=0";
		List<Admin> list = super.getByQuery(query);
		return list.size();
	}
	@Override
	public Admin forgotpassword(Admin admin) {
		Criteria criteria = getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.eq("email", admin.getEmail()));
		Admin us = (Admin) criteria.uniqueResult();
		return us;
	}
	@Override
	public Admin changepassword(Admin admin) {
		
		Admin sAdmin = (Admin) session.getAttribute("admin");
		String query = "FROM Admin where email='"+sAdmin.getEmail()+"'";
		List<Admin> list = super.getByQuery(query);
		if(list.size()==0)
			return null;
		return list.get(0);
	}
	@Override
	public List<Admin> getActive() {
		return (List<Admin>) super.getByQuery("FROM Admin a WHERE a.isdelete=0");
	}
	
	@Override
	public void updatepassword(Admin admin) {
		getSession().saveOrUpdate(admin);
		
	}
	@Override
	public void updatepass(Admin a) {
		// TODO Auto-generated method stub
		
	}
}

	




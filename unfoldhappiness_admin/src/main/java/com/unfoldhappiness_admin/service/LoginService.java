package com.unfoldhappiness_admin.service;

import com.unfoldhappiness_admin.model.Admin;

public interface LoginService {
	public Admin login(Admin admin);

	Admin forgotPassword(Admin admin);

	public Admin changePass(Admin admin);
}

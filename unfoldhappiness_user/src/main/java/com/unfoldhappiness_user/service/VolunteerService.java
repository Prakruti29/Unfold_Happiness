package com.unfoldhappiness_user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unfoldhappiness_user.model.Volunteer;

public interface VolunteerService {

	public long addVol(Volunteer volunteer, MultipartFile file1, MultipartFile file2);
	public List<Volunteer> getAll(int area_id); 
}

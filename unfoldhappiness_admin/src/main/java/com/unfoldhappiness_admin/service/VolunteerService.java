package com.unfoldhappiness_admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unfoldhappiness_admin.model.Volunteer;

public interface VolunteerService {

	public long addVol(Volunteer volunteer, MultipartFile file1, MultipartFile file2);

	public List<Volunteer> getAll();

	public Volunteer getById(long id);

	public long updateVolunteer(Volunteer volunteer, MultipartFile file1, MultipartFile file2);

	public int deleteVolunteer(long id);

}

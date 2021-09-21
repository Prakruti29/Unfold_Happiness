package com.unfoldhappiness_ngo.service;

import java.util.List;

import com.unfoldhappiness_ngo.model.Ngo;



public interface NgoService {
	
	public int addNgo(Ngo ngo);
	public List<Ngo> getAll();
	public Ngo getById(long id);
	public void editngo(Ngo ngo);
	public Boolean deleteNgo(long id);

	
}

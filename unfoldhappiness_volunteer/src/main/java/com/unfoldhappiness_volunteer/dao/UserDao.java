package com.unfoldhappiness_volunteer.dao;

import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.model.User;

public interface UserDao extends GenericDAO<User> {

	Donation getUser(long user_id);

}

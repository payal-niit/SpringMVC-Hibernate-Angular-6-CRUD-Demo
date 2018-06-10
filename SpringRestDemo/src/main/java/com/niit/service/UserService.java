package com.niit.service;

import java.util.List;

import com.niit.model.User;

public interface UserService {
	
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	
	public List<User> userList();
	public User getUserById(int userId);
	public User getUserByEmail(String email);

}

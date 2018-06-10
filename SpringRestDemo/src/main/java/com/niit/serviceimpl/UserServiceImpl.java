package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.model.User;
import com.niit.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;

	public boolean addUser(User user) {
		userDAO.addUser(user);
		return true;
	}

	public boolean updateUser(User user) {
		userDAO.updateUser(user);
		return true;
	}

	public boolean deleteUser(User user) {
		userDAO.deleteUser(user);
		return true;
	}

	public List<User> userList() {
		
		return userDAO.userList();
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(userId);
	}

	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.getUserByEmail(email);
	}

}

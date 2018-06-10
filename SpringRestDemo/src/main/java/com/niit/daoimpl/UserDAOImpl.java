package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	public boolean deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<User> userList() {		
		return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
	}

	public User getUserById(int userId) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userId = "+userId).uniqueResult();
	}

	public User getUserByEmail(String email) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where email = "+"'"+email+"'").uniqueResult();
	}

}

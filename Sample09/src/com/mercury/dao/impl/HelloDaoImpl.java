package com.mercury.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

public class HelloDaoImpl implements HelloDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return (User)template.load(User.class, name);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		template.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		template.update(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		template.delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from User";
		return template.find(hql);
	}

}

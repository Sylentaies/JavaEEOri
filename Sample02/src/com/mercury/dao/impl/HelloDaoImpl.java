package com.mercury.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.utils.HibernateUtil;

public class HelloDaoImpl implements HelloDao {
	
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		return (User)session.load(User.class, name);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from User";
		Session session = HibernateUtil.currentSession();
		return session.createQuery(hql).list();
	}

}

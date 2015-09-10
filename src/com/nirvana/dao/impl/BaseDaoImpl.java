package com.nirvana.dao.impl;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nirvana.dao.BaseDao;
import com.nirvana.util.HibernateUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class clazz;
	private SessionFactory sessionFactory;

	public BaseDaoImpl() {
		clazz = (Class) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public T load(T entity) {
		
		return null;
	}
	
	public T load(String hql, Object... args) {
		Session s = getSession();
		s.beginTransaction();
		Query query = s.createQuery(hql);
		for(int i=0; i<args.length; i++) {
			query.setParameter(i, args[i]);
		}
		//s.getTransaction().commit();
		return (T) query.uniqueResult();
	}
	
	public T loadLists(String hql, Object... args) {
		return null;
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
}

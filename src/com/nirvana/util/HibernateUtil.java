package com.nirvana.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration con = new AnnotationConfiguration();
			con.configure();
			ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
					con.getProperties()).buildServiceRegistry();
			sessionFactory = con.buildSessionFactory(sr);
		} catch (Throwable t) {
			throw new ExceptionInInitializerError(t);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

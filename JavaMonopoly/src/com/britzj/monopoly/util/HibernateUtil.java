package com.britzj.monopoly.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 
 * @author Jean
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * 
	 * @return
	 */
	private static SessionFactory buildSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			return sessionFactory;
		} catch (Throwable ex) {
			ex.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 
	 */
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
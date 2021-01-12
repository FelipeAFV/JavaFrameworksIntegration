package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryProvider {

	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {
			Configuration conf = new Configuration().configure("hibernate.cfg.xml");
			conf.addAnnotatedClass(Employee.class);
			conf.addAnnotatedClass(Department.class);
			ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			sf = conf.buildSessionFactory(sreg);
		}

		return sf;

	}
}

package sv.saraviasrenacar.www.login;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberneteUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration cfg = new

					Configuration().configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



public class HibernateUtilTest {

	@Test
	public void conectar() {
		
		// Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		// sessao.close();
		// HibernateUtil.getFabricaDeSessoes().close();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction();
		
		
	}
}

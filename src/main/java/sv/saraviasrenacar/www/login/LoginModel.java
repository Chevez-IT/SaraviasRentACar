package sv.saraviasrenacar.www.login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import sv.saraviasrenacar.www.entities.UsuariosEntity;

@Component
public class LoginModel {
	private static final SessionFactory factory = HiberneteUtil.getSessionFactory();

	public static UsuariosEntity findByUsername(String username) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			UsuariosEntity usuario = session.createQuery("FROM UsuariosEntity WHERE username = :username", UsuariosEntity.class)
									  .setParameter("username", username)
									  .uniqueResult();
			session.getTransaction().commit();
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
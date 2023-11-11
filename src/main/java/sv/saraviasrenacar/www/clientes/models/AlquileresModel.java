package sv.saraviasrenacar.www.clientes.models;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class AlquileresModel {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public List<ArquileresEntity> obtenerAlquileresDisponibles() {
		Session session = factory.openSession();
		try {
			Query<ArquileresEntity> query = session.createQuery("FROM ArquileresEntity WHERE estadoArquiler = 'Disponible'",
					ArquileresEntity.class);
			return query.list();
		} catch (Exception e) {
			session.close();
			return null;
		}
	}


}

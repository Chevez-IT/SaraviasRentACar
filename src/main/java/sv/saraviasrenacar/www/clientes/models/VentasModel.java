package sv.saraviasrenacar.www.clientes.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

import java.util.List;

public class VentasModel {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public List<VentasEntity> obtenerVentasDisponibles() {
		Session session = factory.openSession();
		try {
			Query<VentasEntity> query = session.createQuery("FROM VentasEntity WHERE estadoVenta = 'Disponible'",
					VentasEntity.class);
			return query.list();
		} catch (Exception e) {
			session.close();
			return null;
		}
	}
}

package sv.saraviasrenacar.www.clientes.models;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.entities.ImgVehiculosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

import sv.saraviasrenacar.www.entities.VehiculosEntity;

public class VehiculosModel {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	public VehiculosEntity obtenerPorId(String idVehiculo) {
		try (Session session = factory.openSession()) {
			return session.get(VehiculosEntity.class, idVehiculo);
		} catch (Exception e) {
			return null;
		}
	}

	public List<ImgVehiculosEntity> obtenerImagenesPorIdVehiculo(String idVehiculo) {
		try (Session session = factory.openSession()) {
			Query<ImgVehiculosEntity> query = session.createQuery(
					"SELECT i FROM ImgVehiculosEntity i " +
							"WHERE i.vehiculosByVehiculoId.id = :idVehiculo ",
					ImgVehiculosEntity.class
			);
			query.setParameter("idVehiculo", idVehiculo);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}


}

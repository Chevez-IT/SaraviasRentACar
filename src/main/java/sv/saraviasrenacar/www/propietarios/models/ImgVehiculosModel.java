package sv.saraviasrenacar.www.propietarios.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sv.saraviasrenacar.www.tools.HibernateUtil;
import sv.saraviasrenacar.www.entities.ImgVehiculosEntity;

import java.util.List;

public class ImgVehiculosModel {

	private final SessionFactory factory = HibernateUtil.getSessionFactory();

	public int insertar(ImgVehiculosEntity imgVehiculo) {
		try (Session ses = factory.openSession()) {
			Transaction tran = ses.beginTransaction();
			ses.save(imgVehiculo);
			tran.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int modificar(ImgVehiculosEntity imgVehiculo) {
		try (Session ses = factory.openSession()) {
			Transaction transaction = ses.beginTransaction();
			ses.update(imgVehiculo);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int eliminar(int idImgVehiculo) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			ImgVehiculosEntity imgVehiculo = session.get(ImgVehiculosEntity.class, idImgVehiculo);
			if (imgVehiculo != null) {
				session.delete(imgVehiculo);
				transaction.commit();
				return 1;
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public ImgVehiculosEntity obtener(int idImgVehiculo) {
		try (Session session = factory.openSession()) {
			return session.get(ImgVehiculosEntity.class, idImgVehiculo);
		} catch (Exception e) {
			return null;
		}
	}

	public List<ImgVehiculosEntity> listarPorVehiculo(int idVehiculo) {
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


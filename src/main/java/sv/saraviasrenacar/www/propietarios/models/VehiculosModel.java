package sv.saraviasrenacar.www.propietarios.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sv.saraviasrenacar.www.tools.HibernateUtil;
import sv.saraviasrenacar.www.entities.VehiculosEntity;
import sv.saraviasrenacar.www.entities.ImgVehiculosEntity;

import java.util.List;

public class VehiculosModel {

	private final SessionFactory factory = HibernateUtil.getSessionFactory();

	public int insertar(VehiculosEntity vehiculo) {
		try (Session ses = factory.openSession()) {
			Transaction tran = ses.beginTransaction();
			ses.save(vehiculo);
			tran.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int modificar(VehiculosEntity vehiculo) {
		try (Session ses = factory.openSession()) {
			Transaction transaction = ses.beginTransaction();
			ses.update(vehiculo);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int eliminar(int idVehiculo) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			VehiculosEntity vehiculo = session.get(VehiculosEntity.class, idVehiculo);
			if (vehiculo != null) {
				session.delete(vehiculo);
				transaction.commit();
				return 1;
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public VehiculosEntity obtener(int idVehiculo) {
		try (Session session = factory.openSession()) {
			return session.get(VehiculosEntity.class, idVehiculo);
		} catch (Exception e) {
			return null;
		}
	}

	public List<VehiculosEntity> listarPorPropietario(int idPropietario) {
		try (Session session = factory.openSession()) {
			Query<VehiculosEntity> query = session.createQuery(
					"SELECT v FROM VehiculosEntity v " +
							"WHERE v.propietariosByPropietarioVehiculo.id = :idPropietario ",
					VehiculosEntity.class
			);
			query.setParameter("idPropietario", idPropietario);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<VehiculosEntity> listarPorPropietarioYEstado(String idPropietario, String estado) {
		try (Session session = factory.openSession()) {
			Query<VehiculosEntity> query = session.createQuery(
					"SELECT v FROM VehiculosEntity v " +
							"WHERE v.propietariosByPropietarioVehiculo.id = :idPropietario " +
							"AND v.estadoVehiculo = :estado",
					VehiculosEntity.class
			);
			query.setParameter("idPropietario", idPropietario);
			query.setParameter("estado", estado);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}


}


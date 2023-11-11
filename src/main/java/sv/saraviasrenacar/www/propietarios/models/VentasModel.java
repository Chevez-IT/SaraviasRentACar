package sv.saraviasrenacar.www.propietarios.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sv.saraviasrenacar.www.tools.HibernateUtil;
import sv.saraviasrenacar.www.entities.VentasEntity;

import java.util.List;

public class VentasModel {

	private final SessionFactory factory = HibernateUtil.getSessionFactory();

	public int insertar(VentasEntity venta) {
		try (Session ses = factory.openSession()) {
			Transaction tran = ses.beginTransaction();
			ses.save(venta);
			tran.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int modificar(VentasEntity venta) {
		try (Session ses = factory.openSession()) {
			Transaction transaction = ses.beginTransaction();
			ses.update(venta);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int eliminar(int idVenta) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			VentasEntity venta = session.get(VentasEntity.class, idVenta);
			if (venta != null) {
				session.delete(venta);
				transaction.commit();
				return 1;
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public VentasEntity obtener(int idVenta) {
		try (Session session = factory.openSession()) {
			return session.get(VentasEntity.class, idVenta);
		} catch (Exception e) {
			return null;
		}
	}

	public List<VentasEntity> listarPorPropietario(int idPropietario) {
		try (Session session = factory.openSession()) {
			Query<VentasEntity> query = session.createQuery(
					"SELECT v FROM VentasEntity v " +
							"JOIN v.vehiculosByVehiculoId vehiculo " +
							"WHERE vehiculo.propietariosByPropietarioVehiculo.id = :idPropietario ",
					VentasEntity.class
			);
			query.setParameter("idPropietario", idPropietario);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<VentasEntity> listarPorPropietarioYEstado(String idPropietario, String estado) {
		try (Session session = factory.openSession()) {
			Query<VentasEntity> query = session.createQuery(
					"SELECT v FROM VentasEntity v " +
							"JOIN v.vehiculosByVehiculoId vehiculo " +
							"WHERE vehiculo.propietariosByPropietarioVehiculo.id = :idPropietario " +
							"AND v.estadoVenta = :estado",
					VentasEntity.class
			);
			query.setParameter("idPropietario", idPropietario);
			query.setParameter("estado", estado);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}
}


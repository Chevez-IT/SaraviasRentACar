package sv.saraviasrenacar.www.propietarios.models;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import sv.saraviasrenacar.www.tools.HibernateUtil;
import sv.saraviasrenacar.www.entities.ArquileresEntity;

import java.util.List;

public class AlquileresModel {

	private final SessionFactory factory = HibernateUtil.getSessionFactory();

	public int insertar(ArquileresEntity alquiler){
		Session ses = factory.openSession();
		try {
			Transaction tran = ses.beginTransaction();
			ses.save(alquiler);
			tran.commit();
			ses.close();
			return 1;
		} catch (Exception e) {
			ses.close();
			return 0;

		}
	}

	public int modificar(ArquileresEntity alquiler) {
		Session ses = factory.openSession();
		try {
			Transaction transaction = ses.beginTransaction();
			ses.update(alquiler);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			ses.close();
			return 0;
		}
	}

	public int eliminar(String idArquiler) {
		Session session = factory.openSession();
		try  {
			Transaction transaction = session.beginTransaction();
			ArquileresEntity alquiler = session.get(ArquileresEntity.class, idArquiler);
			if (alquiler != null) {
				session.delete(idArquiler);
				transaction.commit();
				return 1;
			}
			return 0;
		} catch (Exception e) {
			session.close();
			return 0;
		}
	}

	public ArquileresEntity obtener(String idAlquiler) {
		Session session = factory.openSession();
		try {
			return session.get(ArquileresEntity.class, idAlquiler);
		} catch (Exception e) {
			session.close();
			return null;
		}
	}

	public List<ArquileresEntity> listarPorPropietario(String idPropietario) {
		Session session = factory.openSession();
		try {
			Query<ArquileresEntity> query = session.createQuery("SELECT a FROM ArquileresEntity a " +
												"JOIN a.vehiculosByVehiculoId v " +
												"WHERE v.propietariosByPropietarioVehiculo.id = :idPropietario ",
												ArquileresEntity.class);
			query.setParameter("idPropietario", idPropietario);
			List<ArquileresEntity> lista = query.list();
			return lista;
		} catch (Exception e) {
			session.close();
			return null;
		}
	}

	public List<ArquileresEntity> listarPorPropietarioYEstado(String idPropietario, String estado) {
		Session session = factory.openSession();
		try {
			Query<ArquileresEntity> query = session.createQuery("SELECT a FROM ArquileresEntity a " +
												"JOIN a.vehiculosByVehiculoId v " +
												"WHERE v.propietariosByPropietarioVehiculo.id = :idPropietario " +
												"AND a.estadoArquiler = :estado", ArquileresEntity.class);
			query.setParameter("idPropietario", idPropietario);
			query.setParameter("estado", estado);
			List<ArquileresEntity> lista = query.list();
			return lista;

		} catch (Exception e) {
			session.close();
			return null;
		}
	}

}

package sv.saraviasrenacar.www.propietarios.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.saraviasrenacar.www.entities.PropietariosEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class UsuariosModel {

	private final SessionFactory factory = HibernateUtil.getSessionFactory();

	// Obtener un usuario por su ID
	public UsuariosEntity obtenerUsuarioPorId(int idUsuario) {
		try (Session session = factory.openSession()) {
			return session.get(UsuariosEntity.class, idUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	// Modificar usuario
	public int modificarUsuario(UsuariosEntity usuario) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	// Obtener propietario por su ID
	public PropietariosEntity obtenerPropietarioPorId(int idPropietario) {
		try (Session session = factory.openSession()) {
			return session.get(PropietariosEntity.class, idPropietario);
		} catch (Exception e) {
			return null;
		}
	}

	// Modificar propietario
	public int modificarPropietario(PropietariosEntity propietario) {
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(propietario);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}


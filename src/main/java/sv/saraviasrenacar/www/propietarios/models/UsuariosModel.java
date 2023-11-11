package sv.saraviasrenacar.www.propietarios.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.saraviasrenacar.www.entities.PropietariosEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class UsuariosModel {

	private final SessionFactory factory = HibernateUtil.getSessionFactory();
	private final Logger logger = LoggerFactory.getLogger(UsuariosModel.class);

	// Obtener un usuario por su ID de tabla
	public UsuariosEntity obtenerUsuarioPorId(String idUsuario) {
		try (Session session = factory.openSession()) {
			return session.get(UsuariosEntity.class, idUsuario);
		} catch (Exception e) {
			logger.error("Error al obtener usuario por ID de tabla", e);
			return null;
		}
	}

	// Obtener propietario por su ID de tabla
	public PropietariosEntity obtenerPropietarioPorId(String idPropietario) {
		try (Session session = factory.openSession()) {
			return session.get(PropietariosEntity.class, idPropietario);
		} catch (Exception e) {
			logger.error("Error al obtener propietario por ID de tabla", e);
			return null;
		}
	}


	public void actualizarInformacionUsuario(UsuariosEntity usuario) {
		Session ses = factory.openSession();
		try {
			Transaction tran = ses.beginTransaction();
			ses.update(usuario);
			tran.commit();
			ses.close();
		} catch (Exception e) {
			ses.close();
		}
	}

	public void actualizarInformacionPropietario(PropietariosEntity propietario) {
		Session ses = factory.openSession();
		try {
			Transaction tran = ses.beginTransaction();
			ses.update(propietario);
			tran.commit();
			ses.close();
		} catch (Exception e) {
			ses.close();
		}
	}

	public void actualizarNombreImagenPropietario(String propietarioId, String nombreImagen) {
		Session ses = factory.openSession();
		try {
			Transaction tran = ses.beginTransaction();

			PropietariosEntity propietario = ses.get(PropietariosEntity.class, propietarioId);

			if (propietario != null) {
				propietario.setFotoProp(nombreImagen);
				ses.update(propietario);
				tran.commit();
				ses.close();
			} else {
				ses.close();
			}
		} catch (Exception e) {
			ses.close();
		}
	}

}


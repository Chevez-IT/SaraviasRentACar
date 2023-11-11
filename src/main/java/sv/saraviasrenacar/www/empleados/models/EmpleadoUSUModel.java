package sv.saraviasrenacar.www.empleados.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;

public class EmpleadoUSUModel {
    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public int cambiarEstadoUsuario(String usuarioId, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            UsuariosEntity usuario = ses.get(UsuariosEntity.class, usuarioId);

            if (usuario != null) {
                usuario.setEstadoUser(nuevoEstado);
                ses.update(usuario);
                tran.commit();
                ses.close();
                return 1;
            } else {
                ses.close();
                return 0;
            }
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
}

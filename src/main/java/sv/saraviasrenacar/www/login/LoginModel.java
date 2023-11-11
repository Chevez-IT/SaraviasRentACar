package sv.saraviasrenacar.www.login;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.PropietariosEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class LoginModel {
    private static final SessionFactory factory = HibernateUtil.getSessionFactory();

    public static UsuariosEntity findByUsername(String username) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            UsuariosEntity usuario = session.createQuery("FROM UsuariosEntity WHERE username = :username", UsuariosEntity.class)
                    .setParameter("username", username)
                    .uniqueResult();

            // Carga explícitamente la propiedad "RolesEntity" para evitar LazyInitializationException
            if (usuario != null) {
                Hibernate.initialize(usuario.getRolesByRolId());
            }

            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static int insertarUsuario(UsuariosEntity usuario) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(usuario);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }
    public static int insertarCliente(ClientesEntity cliente) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(cliente);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public static int insertarProp(PropietariosEntity propietario) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(propietario);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public static int updateCont(UsuariosEntity usuario, String correo) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();

            // Realiza la actualización
            String hql = "UPDATE UsuariosEntity SET contrasenaUser = :contrasena WHERE correoUser = :correo";
            org.hibernate.query.Query<?> query = ses.createQuery(hql);
            query.setParameter("contrasena", usuario.getContrasenaUser());
            query.setParameter("correo", correo);
            int rowCount = query.executeUpdate();

            tran.commit(); // Confirma la transacción

            return rowCount; // Devuelve la cantidad de filas afectadas
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Retorna 0 para indicar error
        } finally {
            ses.close();
        }
    }
}
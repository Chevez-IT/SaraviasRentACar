package sv.saraviasrenacar.www.login;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
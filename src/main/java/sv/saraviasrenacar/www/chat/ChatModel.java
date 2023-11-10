package sv.saraviasrenacar.www.chat;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.MensajesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ChatModel {

    private static final SessionFactory factory = HibernateUtil.getSessionFactory();

    public static List<MensajesEntity> listarMensajes(String emisor, String receptor) {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session session = sesFac.openSession();

        ArrayList<MensajesEntity> listarMensajes = new ArrayList<MensajesEntity>();

        session.beginTransaction();

        String hql = "FROM MensajesEntity WHERE " +
                "((usuariosByEmisorMensaje.usuarioId = :emisor AND usuariosByReceptorMensaje.usuarioId = :receptor) " +
                "OR " +
                "(usuariosByEmisorMensaje.usuarioId = :receptor AND usuariosByReceptorMensaje.usuarioId = :emisor))";

        List<MensajesEntity> mensajes = session.createQuery(hql, MensajesEntity.class)
                .setParameter("emisor", emisor)
                .setParameter("receptor", receptor)
                .list();

        session.getTransaction().commit();

        listarMensajes = (ArrayList<MensajesEntity>) mensajes;
        return listarMensajes;
    }


    public static List<MensajesEntity> findByIds(String emisor, String receptor) {
        UsuariosEntity emisorI = new UsuariosEntity();
        emisorI.setUsuarioId(emisor);

        UsuariosEntity receptorI = new UsuariosEntity();
        receptorI.setUsuarioId(receptor);

        try (Session session = factory.openSession()) {
            session.beginTransaction();

            String hql = "FROM MensajesEntity " +
                    "WHERE ((usuariosByEmisorMensaje = :emisorI AND usuariosByReceptorMensaje = :receptorI) " +
                    "OR " +
                    "(usuariosByEmisorMensaje = :receptorI AND usuariosByReceptorMensaje = :emisorI)) " +
                    "ORDER BY fechaCreacion ASC ";

            List<MensajesEntity> mensajes = session.createQuery(hql, MensajesEntity.class)
                    .setParameter("emisorI", emisorI)
                    .setParameter("receptorI", receptorI)
                    .list();

            session.getTransaction().commit();

            return mensajes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static int insertarMensaje(MensajesEntity mensajes) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(mensajes);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }


}

package sv.saraviasrenacar.www.admins.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.EmpleadosEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class UsuarioModel {
    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public UsuarioModel(SessionFactory factory) {
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

    public List<UsuariosEntity> listarUsuarios(){
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<UsuariosEntity> listarUsuarios = new ArrayList<UsuariosEntity>();
        String sql = "from UsuariosEntity";
        listarUsuarios = (ArrayList<UsuariosEntity>) ses.createQuery(sql).list();
        return listarUsuarios;
    }

    public UsuariosEntity obtenerUsuario(String codigo) {
        Session ses= factory.openSession();
        try{
            UsuariosEntity usuario= (UsuariosEntity) ses.get(UsuariosEntity.class, codigo);
            ses.close();
            return usuario;
        }
    catch(Exception e){
            ses.close();
            return null;
        }
    }

    public int modificarUsuario(UsuariosEntity usuario) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(usuario);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

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

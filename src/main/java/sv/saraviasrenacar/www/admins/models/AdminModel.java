package sv.saraviasrenacar.www.admins.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.AdministradoresEntity;
import sv.saraviasrenacar.www.entities.EmpleadosEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;
public class AdminModel {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static int insertarAdministrador(AdministradoresEntity admin) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(admin);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public List<AdministradoresEntity> listarAdministrador() {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<AdministradoresEntity> listarAdministrador = new ArrayList<AdministradoresEntity>();
        String sql = "from AdministradoresEntity ";
        listarAdministrador = (ArrayList<AdministradoresEntity>) ses.createQuery(sql).list();
        return listarAdministrador;
    }

    public AdministradoresEntity obtenerAdministrador(String codigo) {
        Session ses = factory.openSession();
        try {
            AdministradoresEntity admin = (AdministradoresEntity) ses.get(AdministradoresEntity.class, codigo);
            ses.close();
            return admin;
        } catch (Exception e) {
            ses.close();
            return null;
        }


    }

    public int modificarAdmin(AdministradoresEntity admin) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(admin);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int cambiarEstadoAdministrador(String adminId, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            AdministradoresEntity admin = ses.get(AdministradoresEntity.class, adminId);

            if (admin != null) {
                admin.setEstadoAdmin(nuevoEstado);
                ses.update(admin);
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
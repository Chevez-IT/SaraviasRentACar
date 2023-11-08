package sv.saraviasrenacar.www.admins.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.EmpleadosEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class EmpleadoModel {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public EmpleadoModel(SessionFactory factory) {
    }

    public static int insertarEmpleado(EmpleadosEntity empleado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(empleado);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public static List<EmpleadosEntity> listarEmpleado(){
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<EmpleadosEntity> listarEmpleado = new ArrayList<EmpleadosEntity>();
        String sql = "from EmpleadosEntity";
        listarEmpleado = (ArrayList<EmpleadosEntity>) ses.createQuery(sql).list();
        return listarEmpleado;
    }

    public EmpleadosEntity obtenerEmpleado(String codigo) {
        Session ses= factory.openSession();
        try{
            EmpleadosEntity empleado= (EmpleadosEntity) ses.get(EmpleadosEntity.class, codigo);
            ses.close();
            return empleado;
        }
        catch(Exception e){
            ses.close();
            return null;
        }
    }

    public int modificarEmpleado(EmpleadosEntity empleado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(empleado);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int cambiarEstadoEmpleado(String empleadoId, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            EmpleadosEntity empleado = ses.get(EmpleadosEntity.class, empleadoId);

            if (empleado != null) {
                empleado.setEstadoEmp(nuevoEstado);
                ses.update(empleado);
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

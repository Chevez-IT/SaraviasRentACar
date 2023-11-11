package sv.saraviasrenacar.www.admins.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.PropietariosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PropietariosModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<PropietariosEntity> listarPropietarios() {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<PropietariosEntity> listarPropietarios = new ArrayList<PropietariosEntity>();
        String sql = "from PropietariosEntity ";
        listarPropietarios = (ArrayList<PropietariosEntity>) ses.createQuery(sql).list();
        return listarPropietarios;
    }


    public int cambiarEstadoPropietario(String propietarioId, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            PropietariosEntity propietarios = ses.get(PropietariosEntity.class, propietarioId);

            if (propietarios != null) {
                propietarios.setEstadoProp(nuevoEstado);
                ses.update(propietarios);
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

    public PropietariosEntity obtenerPropietarios(String codigo) {
        Session ses= factory.openSession();
        try{
            PropietariosEntity propietarios= (PropietariosEntity) ses.get(PropietariosEntity.class, codigo);
            ses.close();
            return propietarios;
        }
        catch(Exception e){
            ses.close();
            return null;
        }
    }
}
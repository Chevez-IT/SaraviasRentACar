package sv.saraviasrenacar.www.empleados.models;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.PropietariosEntity;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPROModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();


    public List<PropietariosEntity> listarPropietarios() {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<PropietariosEntity> listaPropietarios = new ArrayList<PropietariosEntity>();
        String sql = "from PropietariosEntity";
        listaPropietarios = (ArrayList<PropietariosEntity>)
                ses.createQuery(sql).list();
        return listaPropietarios;
        
    }



}
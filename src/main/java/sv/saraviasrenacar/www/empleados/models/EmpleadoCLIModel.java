package sv.saraviasrenacar.www.empleados.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ClientesEntity;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoCLIModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();


    public List<ClientesEntity> listarClientes() {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<ClientesEntity> listaClientes = new ArrayList<ClientesEntity>();
        String sql = "from ClientesEntity";
        listaClientes = (ArrayList<ClientesEntity>)
                ses.createQuery(sql).list();
        return listaClientes;


}

    public int cambiarEstadoEmpleado(String clienteId, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ClientesEntity clientes = ses.get(ClientesEntity.class, clienteId);

            if (clientes != null) {
                clientes.setEstadoCli(nuevoEstado);
                ses.update(clientes);
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

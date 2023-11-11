package sv.saraviasrenacar.www.admins.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.AdministradoresEntity;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientesModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();


    public List<ClientesEntity> listarClientes() {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<ClientesEntity> listarClientes = new ArrayList<ClientesEntity>();
        String sql = "from ClientesEntity ";
        listarClientes = (ArrayList<ClientesEntity>) ses.createQuery(sql).list();
        return listarClientes;
    }

    public int cambiarEstadoCliente(String clienteId, String nuevoEstado) {
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

    public ClientesEntity obtenerCliente(String codigo) {
        Session ses= factory.openSession();
        try{
            ClientesEntity clientes= (ClientesEntity) ses.get(ClientesEntity.class, codigo);
            ses.close();
            return clientes;
        }
        catch(Exception e){
            ses.close();
            return null;
        }
    }
}
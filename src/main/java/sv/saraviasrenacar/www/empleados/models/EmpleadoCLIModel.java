package sv.saraviasrenacar.www.empleados.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoCLIModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();


    public static List<ClientesEntity> listarClientesEstado(String estado) {
        SessionFactory sesFac = sv.saraviasrenacar.www.tools.HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<ClientesEntity> listaCliente = new ArrayList<ClientesEntity>();

        // Modificamos la consulta HQL para filtrar por el estado deseado
        String sql = "FROM ClientesEntity WHERE estadoCli = :estado";
        listaCliente = (ArrayList<ClientesEntity>) ses.createQuery(sql)
                .setParameter("estado", estado)
                .list();

        ses.close();
        return listaCliente;
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

    public List<VentasEntity> obtenerVentasPorCliente(String clienteId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            String hql = "SELECT v FROM VentasEntity v " +
                    "JOIN v.clientesByCompradorVenta c " +
                    "WHERE v.estadoVenta = 'Vendido' " +
                    "AND c.clienteId = :clienteId";

            List<VentasEntity> ventas = session.createQuery(hql, VentasEntity.class)
                    .setParameter("clienteId", clienteId)
                    .getResultList();

            return ventas;
        } finally {
            session.close();
        }
    }

    }



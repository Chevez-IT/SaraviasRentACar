package sv.saraviasrenacar.www.empleados.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.*;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoPROModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    public static List<PropietariosEntity> listarPropietarioEstado(String estado) {
        SessionFactory sesFac = sv.saraviasrenacar.www.tools.HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<PropietariosEntity> listaPropietarios = new ArrayList<PropietariosEntity>();

        // Modificamos la consulta HQL para filtrar por el estado deseado
        String sql = "FROM PropietariosEntity WHERE estadoProp = :estado";
        listaPropietarios = (ArrayList<PropietariosEntity>) ses.createQuery(sql)
                .setParameter("estado", estado)
                .list();

        ses.close();
        return listaPropietarios;
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


    public List<VehiculosEntity> listarVehiculosPorPropietario(String propietarioId) {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();

        try {
            String hql = "SELECT v FROM VehiculosEntity v " +
                    "WHERE v.propietariosByPropietarioVehiculo.propietarioId = :propietarioId";

            List<VehiculosEntity> vehiculos = ses.createQuery(hql, VehiculosEntity.class)
                    .setParameter("propietarioId", propietarioId)
                    .getResultList();

            return vehiculos;
        } finally {
            ses.close();
        }
    }

    public List<VentasEntity> obtenerVentasPorPropietario(String propietarioId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            String hql = "SELECT v FROM VentasEntity v " +
                    "JOIN v.vehiculosByVehiculoId vh " +
                    "WHERE v.estadoVenta = 'Vendido' " +
                    "AND vh.propietariosByPropietarioVehiculo.propietarioId = :propietarioId";

            List<VentasEntity> ventas = session.createQuery(hql, VentasEntity.class)
                    .setParameter("propietarioId", propietarioId)
                    .getResultList();

            return ventas;
        } finally {
            session.close();
        }
    }

    public List<ArquileresEntity> obtenerAlquilerPorPropietario(String propietarioId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            String hql = "SELECT a FROM ArquileresEntity a " +
                    "JOIN a.vehiculosByVehiculoId vh " +
                    "WHERE a.estadoArquiler = 'Alquilado' " +
                    "AND vh.propietariosByPropietarioVehiculo.propietarioId = :propietarioId";

            List<ArquileresEntity> arquileres = session.createQuery(hql, ArquileresEntity.class)
                    .setParameter("propietarioId", propietarioId)
                    .getResultList();

            return arquileres;
        } finally {
            session.close();
        }
    }

}

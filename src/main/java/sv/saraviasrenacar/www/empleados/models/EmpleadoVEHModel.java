package sv.saraviasrenacar.www.empleados.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.VehiculosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class EmpleadoVEHModel {

    static SessionFactory factory = HibernateUtil.getSessionFactory();



    public static List<VehiculosEntity> listarVehiculoEstado(String estado) {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<VehiculosEntity> listaVehiculo = new ArrayList<VehiculosEntity>();

        // Modificamos la consulta HQL para filtrar por el estado deseado
        String sql = "FROM VehiculosEntity WHERE estadoVehiculo = :estado";
        listaVehiculo = (ArrayList<VehiculosEntity>) ses.createQuery(sql)
                .setParameter("estado", estado)
                .list();

        ses.close();
        return listaVehiculo;
    }

    public int cambiarEstadoVehiculo(String vehiculoId, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            VehiculosEntity vehiculo = ses.get(VehiculosEntity.class, vehiculoId);

            if (vehiculo != null) {
                vehiculo.setEstadoVehiculo(nuevoEstado);
                ses.update(vehiculo);
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
    } public VehiculosEntity obtenerVehiculo(String codigo) {
        Session ses= factory.openSession();
        try{
            VehiculosEntity vehiculo= (VehiculosEntity) ses.get(VehiculosEntity.class, codigo);
            ses.close();
            return vehiculo;
        }
        catch(Exception e){
            ses.close();
            return null;
        }
    }





}

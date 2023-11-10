package sv.saraviasrenacar.www.empleados.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class EmpleadoVENModel {

    static SessionFactory factory = HibernateUtil.getSessionFactory();



    public static List<VentasEntity> listarVentaEstado(String estado) {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<VentasEntity> listaVentasDIS = new ArrayList<VentasEntity>();

        // Modificamos la consulta HQL para filtrar por el estado deseado
        String sql = "FROM VentasEntity WHERE estadoVenta = :estado";
        listaVentasDIS = (ArrayList<VentasEntity>) ses.createQuery(sql)
                .setParameter("estado", estado)
                .list();

        ses.close();
        return listaVentasDIS;
    }

    public int cambiarEstadoVenta(String ventaID, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            VentasEntity ventas = ses.get(VentasEntity.class, ventaID);

            if (ventas != null) {
                ventas.setEstadoVenta(nuevoEstado);
                ses.update(ventas);
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
    } public VentasEntity obtenerVenta(String codigo) {
        Session ses= factory.openSession();
        try{
            VentasEntity ventas= (VentasEntity) ses.get(VentasEntity.class, codigo);
            ses.close();
            return ventas;
        }
        catch(Exception e){
            ses.close();
            return null;
        }
    }





}

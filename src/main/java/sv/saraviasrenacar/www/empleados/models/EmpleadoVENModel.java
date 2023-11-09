package sv.saraviasrenacar.www.empleados.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class EmpleadoVENModel {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static List<VentasEntity> listarVentaPorEstado(String estado) {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<VentasEntity> listarVentas = new ArrayList<VentasEntity>();

        // Modificamos la consulta HQL para filtrar por el estado deseado
        String sql = "FROM VentasEntity WHERE estadoVenta = :estado";
        listarVentas = (ArrayList<VentasEntity>) ses.createQuery(sql)
                .setParameter("estado", estado)
                .list();

        ses.close();
        return listarVentas;
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
    }


}

package sv.saraviasrenacar.www.empleados.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.tools.HibernateUtil;

public class EmpleadoARQModel {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static List<ArquileresEntity> listarArquilerEstado(String estado) {
        SessionFactory sesFac = HibernateUtil.getSessionFactory();
        Session ses = sesFac.openSession();
        ArrayList<ArquileresEntity> listaArquiler = new ArrayList<ArquileresEntity>();

        // Modificamos la consulta HQL para filtrar por el estado deseado
        String sql = "FROM ArquileresEntity WHERE estadoArquiler = :estado";
        listaArquiler= (ArrayList<ArquileresEntity>) ses.createQuery(sql)
                .setParameter("estado", estado)
                .list();

        ses.close();
        return listaArquiler;
    }

    public int cambiarEstadoArquiler(String arquilerId, String nuevoEstado) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ArquileresEntity arquiler = ses.get(ArquileresEntity.class, arquilerId);

            if (arquiler != null) {
                arquiler.setEstadoArquiler(nuevoEstado);
                ses.update(arquiler);
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
    } public ArquileresEntity obtenerArquiler(String codigo) {
        Session ses= factory.openSession();
        try{
            ArquileresEntity arquiler= (ArquileresEntity) ses.get(ArquileresEntity.class, codigo);
            ses.close();
            return arquiler;
        }
        catch(Exception e){
            ses.close();
            return null;
        }
    }





}

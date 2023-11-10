import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sv.saraviasrenacar.www.empleados.models.EmpleadoVENModel;
import sv.saraviasrenacar.www.entities.RolesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;


public class testventas {

    private SessionFactory factory;
    private EmpleadoVENModel empleadoVENModel;

    @Before
    public void setUp() {
        // Configurar la fábrica de sesiones de Hibernate (puede variar según tu configuración)
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();


    }

    @After
    public void tearDown() {
        factory.close();
    }

    @Test
    public void test () {

        VentasEntity ventas= new VentasEntity();
        ventas.setEstadoVenta("Vendido");

        String ventass = "Vendido";

        for (VentasEntity v: empleadoVENModel.listarVentaPorEstado(ventass)
             ) {
            System.out.println(v.getEstadoVenta());
            System.out.println(v.getVentaId());      }
    }
}

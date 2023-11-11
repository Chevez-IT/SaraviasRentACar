import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sv.saraviasrenacar.www.empleados.models.EmpleadoCLIModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoPROModel;
import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.entities.VehiculosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class testOfertas {

        private SessionFactory factory;
        private EmpleadoPROModel empleadoPROModel;

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
    public void testOferta(){
            VentasEntity ventas = new VentasEntity();
            EmpleadoCLIModel empleadoCLIModel = new EmpleadoCLIModel();

            String Id= "BC321P";

            for (VentasEntity a:empleadoCLIModel.obtenerVentasPorCliente(Id)
                 ) {
                System.out.println(a.getClientesByCompradorVenta());
                System.out.println(a.getVehiculosByVehiculoId());
                System.out.println(a.getEstadoVenta());

            }
        }



}

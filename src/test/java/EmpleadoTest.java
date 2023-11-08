import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sv.saraviasrenacar.www.admins.models.UsuarioModel;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.admins.models.EmpleadoModel;
import sv.saraviasrenacar.www.entities.EmpleadosEntity;


public class EmpleadoTest {

    private SessionFactory factory;
    private UsuarioModel usuarioModel;

    @Before
    public void setUp() {
        // Configurar la fábrica de sesiones de Hibernate (puede variar según tu configuración)
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();

        usuarioModel = new UsuarioModel(factory);
    }

    @After
    public void tearDown() {
        factory.close();
    }

}

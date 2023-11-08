import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sv.saraviasrenacar.www.admins.models.UsuarioModel;
import sv.saraviasrenacar.www.entities.RolesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;

public class UsuarioTest {
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

    @Test
    public void testInsertarUsuario() {
        UsuariosEntity usuario = new UsuariosEntity();
        RolesEntity rol = new RolesEntity();
        usuario.setUsuarioId("MR578");
        usuario.setUsername("MichelleRamos");
        usuario.setCorreoUser("michelleramos@gmail.com");
        usuario.setContrasenaUser("passw0rd123");
        rol.setRolId("3");
        usuario.setRolesByRolId(rol);
        usuario.setEstadoUser("Activo");

        int idUsuario = usuarioModel.insertarUsuario(usuario);
    }

    @Test
    public void testListarUsuarios() {
        UsuariosEntity usuario = new UsuariosEntity();
        for (UsuariosEntity u : usuarioModel.listarUsuarios()) {
            System.out.println(u.getUsuarioId());
            System.out.println(u.getUsername());
            System.out.println(u.getCorreoUser());
            System.out.println(u.getContrasenaUser());
            System.out.println(u.getEstadoUser());
            System.out.println(u.getRolesByRolId().getRolId());

        }
    }

    @Test
    public void testModificarUsuario() {
        UsuariosEntity usuario = new UsuariosEntity();
        RolesEntity rol = new RolesEntity();
        usuario.setUsuarioId("MR578");
        usuario.setUsername("MichelleRamos");
        usuario.setCorreoUser("michelleramos@gmail.com");
        usuario.setContrasenaUser("passw0rd123");
        rol.setRolId("3");
        usuario.setRolesByRolId(rol);
        usuario.setEstadoUser("Activo");

        int idUsuario = usuarioModel.modificarUsuario(usuario);

        System.out.println("Usuario modificado " + idUsuario + " correctamente " + usuario.getUsuarioId());


    }

    @Test
    public void testObtenerUsuario() {
        UsuariosEntity usuario = usuarioModel.obtenerUsuario("MR578");
        System.out.println("Usuario obtenido " + usuario.getUsuarioId() + " correctamente " + usuario.getUsername() + " " + usuario.getCorreoUser() + " " + usuario.getContrasenaUser() + " " + usuario.getEstadoUser() + " " + usuario.getRolesByRolId().getRolId());
    }

    @Test
    public void testCambiarEstadoUsuario() {
        String empleadoId = "MR578";
        String nuevoEstado = "Inactivo";
        int idUsuario = usuarioModel.cambiarEstadoUsuario(empleadoId, nuevoEstado);

        System.out.println("Se ha cambiado el estado del usuario " + empleadoId + " a " + nuevoEstado + " " + idUsuario);
    }

}

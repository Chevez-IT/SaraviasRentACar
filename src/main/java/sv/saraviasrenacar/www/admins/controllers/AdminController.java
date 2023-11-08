package sv.saraviasrenacar.www.admins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.saraviasrenacar.www.admins.models.EmpleadoModel;
import sv.saraviasrenacar.www.entities.EmpleadosEntity;
import sv.saraviasrenacar.www.entities.RolesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.entities.AdministradoresEntity;
import sv.saraviasrenacar.www.admins.models.UsuarioModel;
import sv.saraviasrenacar.www.tools.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("Administrador")
public class AdminController {
	@GetMapping("/")
	public String index() {
		return "adminsView/adminDashboard";
	}

    @GetMapping("/panel")
    public String panel() {
        return "adminsView/adminDashboard";
    }

    @GetMapping("/panel/clientes")
    public String clientes() {
        return "adminsView/gestionClientes";
    }

    @RequestMapping(value = "/panel/empleados", method = GET)
    public String empleados(ModelMap model) {
        model.addAttribute("empleados", EmpleadoModel.listarEmpleado());
        return "adminsView/gestionEmpleados";
    }

    @GetMapping("/panel/empleados/edit")
    public String empleadoEdit() {
        return "adminsView/editar";
    }

    @RequestMapping(value = "/panel/empleados/new", method = GET)
    public String empleadoNew(Model model) {
        model.addAttribute("empleado", new EmpleadosEntity());
        model.addAttribute("roles", new RolesEntity());
        model.addAttribute("usuario", new UsuariosEntity());

        return "adminsView/nuevo";
    }

    @RequestMapping(value = "/panel/empleados/create", method = POST)
    public String empleadoNewInsert(@ModelAttribute("empleado") EmpleadosEntity empleado, Model model, RedirectAttributes atributos) {

        Tools tools = new Tools();
        UsuariosEntity usuario = new UsuariosEntity();
        RolesEntity rol = new RolesEntity();
        AdministradoresEntity admin = new AdministradoresEntity();

        String contrasenna = String.valueOf(tools.GenerarContraseña());
        String user = tools.GenerarUsername(empleado.getNombresEmp(), empleado.getApellidosEmp());
        String idIniciales = tools.GenerarIdIniciales(empleado.getNombresEmp(), empleado.getApellidosEmp());
        String idNRamdom = tools.GenerarIdNRandom();
        String username = user + idNRamdom;
        String idUser = idIniciales + idNRamdom;

        System.out.println("Correo:"+ empleado.getCorreo());

        usuario.setUsuarioId(idUser);
        usuario.setUsername(username);
        usuario.setCorreoUser(empleado.getCorreo());
        usuario.setContrasenaUser(contrasenna);
        rol.setRolId("3");
        usuario.setRolesByRolId(rol);
        usuario.setEstadoUser("Activo");

        int resultUsuario = UsuarioModel.insertarUsuario(usuario);

    if (resultUsuario == 1){

        empleado.setEmpleadoId(idUser+"E");
        empleado.setUsuariosByUsuarioEmpleado(usuario);
        empleado.setFotoEmp("default.png");
        empleado.setEstadoEmp("Activo");
        admin.setAdministradorId("DC312A");
        empleado.setAdministradoresByCreadorId(admin);

       EmpleadoModel.insertarEmpleado(empleado);
    }
        return "redirect:/Administrador/panel/empleados";
    }

    @GetMapping("/panel/proveedores")
    public String proveedores() {
        return "adminsView/gestionProveedores";
    }

}
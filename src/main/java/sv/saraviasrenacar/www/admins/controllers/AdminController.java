package sv.saraviasrenacar.www.admins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/panel/empleados")
    public String empleados() {
        return "adminsView/gestionEmpleados";
    }

    @GetMapping("/panel/empleados/edit")
    public String empleadoEdit() {
        return "adminsView/editar";
    }

    @GetMapping("/panel/empleados/new")
    public String empleadoNew() {
        return "adminsView/nuevo";
    }

    @GetMapping("/panel/proveedores")
    public String proveedores() {
        return "adminsView/gestionProveedores";
    }

}
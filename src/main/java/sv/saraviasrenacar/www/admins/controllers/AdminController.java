package sv.saraviasrenacar.www.admins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/panel")
    public String panel() {
        return "WEB-INF/views/adminsView/adminDashboard";
    }

    @GetMapping("/panel/clientes")
    public String clientes() {
        return "WEB-INF/views/adminsView/gestionClientes";
    }

    @GetMapping("/panel/empleados")
    public String empleados() {
        return "WEB-INF/views/adminsView/gestionEmpleados";
    }

    @GetMapping("/panel/empleados/edit")
    public String empleadoEdit() {
        return "WEB-INF/views/adminsView/editar";
    }

    @GetMapping("/panel/empleados/new")
    public String empleadoNew() {
        return "WEB-INF/views/adminsView/nuevo";
    }

    @GetMapping("/panel/proveedores")
    public String proveedores() {
        return "WEB-INF/views/adminsView/gestionProveedores";
    }



}

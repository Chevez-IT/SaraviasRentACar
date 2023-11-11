package sv.saraviasrenacar.www.empleados.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoDASHController {

    @GetMapping("/EmpleadoDASH/inicio")
    public String Inicio() {
        return "empleadosView/empleadoDashboard";
    }
}


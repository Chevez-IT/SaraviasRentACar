package sv.saraviasrenacar.www.empleados.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.saraviasrenacar.www.empleados.models.EmpleadoCLIModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoPROModel;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("EmpleadoPRO")

public class EmpleadoPROController {
    EmpleadoPROModel empleadoPROModel = new EmpleadoPROModel();
    @RequestMapping(value = "listpro", method = GET)

    public String listarPropietarios(ModelMap modelMap){

//Pasando la lista de editoriales hacia la vista
        modelMap.addAttribute("listaPropietarios",
                empleadoPROModel.listarPropietarios());


//Redireccionando a la página de .jsp
        return "empleadosView/gestionPropietarios";
    }

}
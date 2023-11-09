package sv.saraviasrenacar.www.empleados.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.saraviasrenacar.www.empleados.models.EmpleadoCLIModel;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("EmpleadoCLI")

public class EmpleadoCLIController {
	EmpleadoCLIModel empleadoCLModel = new EmpleadoCLIModel();
	@RequestMapping(value = "listcl", method = GET)

	public String listarCliente(ModelMap modelMap){

//Pasando la lista de editoriales hacia la vista
		modelMap.addAttribute("listaCliente",
				empleadoCLModel.listarClientes());

//Redireccionando a la página de .jsp
		return "empleadosView/gestionClientes";
	}


}



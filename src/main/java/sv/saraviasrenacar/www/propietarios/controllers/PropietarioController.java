package sv.saraviasrenacar.www.propietarios.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Propietario")
public class PropietarioController {
	@GetMapping("/")
	public String index() {
		return "propietariosView/propietarioDashboard";
	}


}

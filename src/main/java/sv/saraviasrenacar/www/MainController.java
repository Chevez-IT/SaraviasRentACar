package sv.saraviasrenacar.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.PostConstruct;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		// Verificar si hay una sesión activa y el valor del rol
		int rol = obtenerRol(); // Supongamos que tienes un método obtenerRol()

		if (rol == 1) {
			return "redirect:/Propietario/";
		} else if (rol == 2) {
			return "redirect:/Administrador/";
		} else if (rol == 3) {
			return "redirect:/Empleado/";
		} else {
			return "redirect:/Inicio/";
		}
	}

	// Método de ejemplo para obtener el rol (deberías implementar esta lógica)
	private int obtenerRol() {
		// Supongamos que aquí tienes la lógica para obtener el rol.
		return 2; // Valor de ejemplo
	}
}

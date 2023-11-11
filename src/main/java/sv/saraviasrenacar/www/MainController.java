package sv.saraviasrenacar.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(@RequestParam("rolId") String rol) {

		if ("1".equals(rol)) {
			return "redirect:/Propietario/";
		} else if ("2".equals(rol)) {
			return "redirect:/Administrador/";
		} else if ("3".equals(rol)) {
			return "redirect:/Empleado/";
		} else if ("4".equals(rol)) {
			return "redirect:/Cliente/";
		} else {
		return "redirect:/Login";
		}
	}
}

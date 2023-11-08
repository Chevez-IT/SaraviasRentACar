package sv.saraviasrenacar.www.clientes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Cliente")
public class ClienteController {
	@GetMapping("/")
	public String index() {
		return "clientesView/clienteDashboard";
	}
}

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


}

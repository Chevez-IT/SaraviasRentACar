package sv.saraviasrenacar.www.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.login.LoginModel;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		UsuariosEntity usuario = LoginModel.findByUsername(username);

		if (usuario != null && password.equals(usuario.getContrasenaUser())) {
			session.setAttribute("user", usuario);
			String rol = String.valueOf(usuario.getRolesByRolId());

			if ("1".equals(rol)) {
				return "redirect:/adminDashboard";
			} else if ("2".equals(rol)) {
				return "redirect:/userDashboard";
			} else if ("3".equals(rol) || "4".equals(rol)) {
				return "redirect:/otherDashboard";
			} else {
				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/login?error=true";
		}
	}

}
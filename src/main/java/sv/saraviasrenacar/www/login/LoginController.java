package sv.saraviasrenacar.www.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sv.saraviasrenacar.www.entities.RolesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @RequestMapping(value = "", method = GET)
    public String index() {
        return "loginView/login";
    }

    @RequestMapping(value = "/log", method = POST)
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        UsuariosEntity usuario = LoginModel.findByUsername(username);
        RolesEntity rol = usuario.getRolesByRolId();
        String rolValue = rol.getRolId(); // Obtener el valor numérico del rol

        if (usuario != null && password.equals(usuario.getContrasenaUser())) {
            session.setAttribute("user", usuario);

            System.out.println("Este es tu rol" + rolValue);

            if ("1".equals(rolValue)) {
                return "redirect:/adminDashboard";
            } else if ("2".equals(rolValue)) {
                return "redirect:/userDashboard";
            } else if ("3".equals(rolValue)) {
                return "redirect:/otherDashboard";
            } else if ("4".equals(rolValue)) {
                return "redirect:/dashboardPrueba";
            }
        } else {
            return "redirect:/login?error=true";
        }
        return rolValue;
    }
}

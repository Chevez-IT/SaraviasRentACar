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
        String rolValue = rol.getRolId();

        if (usuario != null && password.equals(usuario.getContrasenaUser())) {

            session.setAttribute("usuarioId", usuario.getUsuarioId());
            session.setAttribute("rolId", rolValue);
            session.setAttribute("userName", usuario.getUsername());

            if ("1".equals(rolValue)) {
                return "redirect:/Propietario/";
            } else if ("2".equals(rolValue)) {
                return "redirect:/Administrador/";
            } else if ("3".equals(rolValue)) {
                return "redirect:/Empleado/";
            } else if ("4".equals(rolValue)) {
                return "redirect:/Inicio/";
            }
        } else {
            return "redirect:/login?error=true";
        }
        return rolValue;
    }
}

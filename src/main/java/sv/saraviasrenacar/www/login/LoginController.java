package sv.saraviasrenacar.www.login;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.RolesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.*;
import sv.saraviasrenacar.www.tools.Tools;

import java.util.Properties;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
        Tools tools = new Tools();
        String result = String.valueOf(tools.ComprobarContraseña(password, usuario.getContrasenaUser()));

        if (usuario != null && result.equals("true")) {

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

    @GetMapping("nuevo")
    public String clientes() {
        return "loginView/nuevo";
    }

    @GetMapping("/email")
    public String email() {
        return "loginView/nuevo";
    }

    private JavaMailSender javaMailSender;

    /*@RequestMapping(value = "/sendEmail", method = POST)
    boolean sendEmail(@RequestParam String email) {
        final String fromEmail = "javaprueba2023@gmail.com"; // Cambia esto al correo desde el que enviarás el mensaje
        final String password = "rxgfdspfuoyetrze"; // Cambia esto a tu contraseña de correo

        // Configuración de las propiedades del servidor de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("✨ Contraseña Generada ✨"); // Cambia el asunto del correo según tus necesidades

            // Formatear el contenido del correo con guiones, asteriscos y emoticones
            String contenidoCorreo = "¡Hola! 😊\n\n";
            contenidoCorreo += "Tu contraseña de la cuponera ha sido generada con éxito: 🎉🔐\n\n";
            contenidoCorreo += "************\n";
            contenidoCorreo += "     Contraseña:      😃\n";
            contenidoCorreo += "************\n\n";
            contenidoCorreo += "Por favor, guarda esta contraseña de forma segura. 🔒\n\n";
            contenidoCorreo += "¡Gracias y ten un buen día! 🌞\n";

            message.setText(contenidoCorreo); // Agrega el contenido del correo

            // Enviar el mensaje
            Transport.send(message);

            return true; // El correo se envió con éxito
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Hubo un error al enviar el correo
        }
    }
    */

    @RequestMapping(value = "/create", method = GET)
    public String empleadoNew(Model model) {

        model.addAttribute("cliente", new ClientesEntity());
        model.addAttribute("roles", new RolesEntity());
        model.addAttribute("usuario", new UsuariosEntity());
        return "loginView/registrar";
    }
    @RequestMapping(value = "/create", method = POST)
    public String clienteNewInsert(@ModelAttribute("cliente") ClientesEntity cliente, Model model, RedirectAttributes atributos) {

        Tools tools = new Tools();
        UsuariosEntity usuario = new UsuariosEntity();
        RolesEntity rol = new RolesEntity();

        /* contrasenna = String.valueOf(tools.GenerarContraseña());*/

        String contrasenna = "password";
        String encripted = (tools.encriptarContraseña(contrasenna));

        String user = tools.GenerarUsername(cliente.getNombresCli(), cliente.getApellidosCli());
        String idIniciales = tools.GenerarIdIniciales(cliente.getNombresCli(), cliente.getApellidosCli());
        String idNRamdom = tools.GenerarIdNRandom();
        String username = user;
        String idUser = idIniciales + idNRamdom;

        usuario.setUsuarioId(idUser);
        usuario.setUsername(username);
        usuario.setCorreoUser(cliente.getCorreo());
        usuario.setContrasenaUser(encripted);
        rol.setRolId("4");
        usuario.setRolesByRolId(rol);
        usuario.setEstadoUser("Activo");

        int resultUsuario = LoginModel.insertarUsuario(usuario);

        if (resultUsuario == 1){

            cliente.setClienteId(idUser+"C");
            cliente.setUsuariosByUsuarioCliente(usuario);
            cliente.setFotoCli("default.png");
            cliente.setEstadoCli("Pendiente");
            LoginModel.insertarCliente(cliente);
        }
        return "redirect:/Login";
    }

}

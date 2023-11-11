package sv.saraviasrenacar.www.login;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.saraviasrenacar.www.entities.*;

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
                return "redirect:/Cliente/";
            }
        } else {
            return "redirect:/login?error=true";
        }
        return rolValue;
    }


    /*Registrarse como cliente*/
    @GetMapping("nuevo")
    public String clientes() {
        return "loginView/nuevo";
    }

    @GetMapping("/email")
    public String email() {
        return "loginView/nuevo";
    }

    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/sendEmail", method = POST)
    String sendEmail(@RequestParam String email , HttpSession ses) {
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

        Tools tools = new Tools();
        String codigo = String.valueOf(tools.GenerarContraseña());
        try {
            ses.setAttribute("codigoSesion", codigo);
            ses.setAttribute("correo", email);
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("✨ Codigo Generado ✨"); // Cambia el asunto del correo según tus necesidades
            String contenidoCorreo = "¡Hola! 😊\n\n";
            contenidoCorreo += "     Codigo de verificación:      " +codigo+ "\n";
            contenidoCorreo += "************\n\n";
            contenidoCorreo += "Por favor, guarda esta codigo de forma segura\n\n";
            contenidoCorreo += "¡Gracias y ten un buen día!\n";
            message.setText(contenidoCorreo); // Agrega el contenido del correo
            // Enviar el mensaje
            Transport.send(message);
            return "redirect:/Login/comprobar";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/Login";
        }
    }

    @GetMapping("/comprobar")
    public String comprobar() {

        return "loginView/comprobar";
    }



    @RequestMapping(value = "/verificarCodigo", method = POST)
    String verificarCodigo(@RequestParam String codigo, HttpSession session) {
        // Recuperar el código almacenado en la variable de sesión
        String codigoSesion = (String) session.getAttribute("codigoSesion");

        System.out.println(codigoSesion);
        System.out.println(codigo);
        if (codigoSesion != null && codigoSesion.equals(codigo)) {
            System.out.println("Exitooooo");
            return "redirect:/Login/create"; // Redirige a la página de éxito
        } else {
            // El código es incorrecto, realiza la acción en caso de error
            return "redirect:/Login/email"; // Redirige a la página de error
        }
    }




    @RequestMapping(value = "/create", method = GET)
    public String empleadoNew(Model model) {

        model.addAttribute("cliente", new ClientesEntity());
        model.addAttribute("roles", new RolesEntity());
        model.addAttribute("usuario", new UsuariosEntity());
        return "loginView/registrar";
    }

    @RequestMapping(value = "/create", method = POST)
    public String clienteNewInsert(@ModelAttribute("cliente") ClientesEntity cliente, Model model, RedirectAttributes atributos, HttpSession ses)  {

        Tools tools = new Tools();
        UsuariosEntity usuario = new UsuariosEntity();
        RolesEntity rol = new RolesEntity();
        String contrasenna = String.valueOf(tools.GenerarContraseña());
        String encripted = (tools.encriptarContraseña(contrasenna));
        String user = tools.GenerarUsername(cliente.getNombresCli(), cliente.getApellidosCli());
        String idIniciales = tools.GenerarIdIniciales(cliente.getNombresCli(), cliente.getApellidosCli());
        String idNRamdom = tools.GenerarIdNRandom();
        String username = user + idNRamdom;
        String idUser = idIniciales + idNRamdom;

        String correo = (String) ses.getAttribute("correo");


        usuario.setUsuarioId(idUser);
        usuario.setUsername(username);
        usuario.setCorreoUser(correo);
        System.out.println(correo);
        usuario.setContrasenaUser(encripted);
        rol.setRolId("4");
        usuario.setRolesByRolId(rol);
        usuario.setEstadoUser("Activo");

        int resultUsuario = LoginModel.insertarUsuario(usuario);

        if (resultUsuario == 1){
            EnviarCredenciales(contrasenna,username,ses);
            cliente.setClienteId(idUser+"C");
            cliente.setUsuariosByUsuarioCliente(usuario);
            cliente.setFotoCli("default.png");
            cliente.setEstadoCli("Activo");
            LoginModel.insertarCliente(cliente);
        }
        return "redirect:/Login";
    }



    /*Enviar las credenciales*/
    public void EnviarCredenciales(String contrasenna, String usuario, HttpSession ses) {
        final String fromEmail = "javaprueba2023@gmail.com"; // Cambia esto al correo desde el que enviarás el mensaje
        final String password = "rxgfdspfuoyetrze"; // Cambia esto a tu contraseña de correo
        String correo = (String) ses.getAttribute("correo");
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
        Tools tools = new Tools();
        String codigo = String.valueOf(tools.GenerarContraseña());
        try {
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject("✨ Codigo Generado ✨"); // Cambia el asunto del correo según tus necesidades
            String contenidoCorreo = "¡Hola! 😊\n\n";
            contenidoCorreo += "     Su contraseña es:      " +contrasenna+ "\n";
            contenidoCorreo += "     Su usuario es:      " +usuario+ "\n";
            contenidoCorreo += "************\n\n";
            contenidoCorreo += "Por favor, guarda esta codigo de forma segura\n\n";
            contenidoCorreo += "¡Gracias y ten un buen día!\n";
            message.setText(contenidoCorreo); // Agrega el contenido del correo
            // Enviar el mensaje
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    /*Registrarse como cliente*/

    /*Registrarse como propietario*/

    @GetMapping("/emailProp")
    public String emailProp() {
        return "loginView/nuevoProp";
    }


    @RequestMapping(value = "/sendEmailProp", method = POST)
    String sendEmailProp(@RequestParam String email , HttpSession ses) {
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

        Tools tools = new Tools();
        String codigo = String.valueOf(tools.GenerarContraseña());
        try {
            ses.setAttribute("codigoSesion", codigo);
            ses.setAttribute("correo", email);
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("✨ Codigo Generado ✨"); // Cambia el asunto del correo según tus necesidades
            String contenidoCorreo = "¡Hola! 😊\n\n";
            contenidoCorreo += "     Codigo de verificación:      " +codigo+ "\n";
            contenidoCorreo += "************\n\n";
            contenidoCorreo += "Por favor, guarda esta codigo de forma segura\n\n";
            contenidoCorreo += "¡Gracias y ten un buen día!\n";
            message.setText(contenidoCorreo); // Agrega el contenido del correo
            // Enviar el mensaje
            Transport.send(message);
            return "redirect:/Login/comprobarProp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/Login";
        }
    }

    @GetMapping("/comprobarProp")
    public String comprobarProp() {

        return "loginView/comprobarProp";
    }

    @RequestMapping(value = "/verificarCodigoProp", method = POST)
    String verificarCodigoProp(@RequestParam String codigo, HttpSession session) {
        // Recuperar el código almacenado en la variable de sesión
        String codigoSesion = (String) session.getAttribute("codigoSesion");

        System.out.println(codigoSesion);
        System.out.println(codigo);
        if (codigoSesion != null && codigoSesion.equals(codigo)) {
            System.out.println("Exitooooo");
            return "redirect:/Login/createProp"; // Redirige a la página de éxito
        } else {
            // El código es incorrecto, realiza la acción en caso de error
            return "redirect:/Login/emailProp"; // Redirige a la página de error
        }
    }

    @RequestMapping(value = "/createProp", method = GET)
    public String propietarioNew(Model model) {

        model.addAttribute("propietario", new PropietariosEntity());
        model.addAttribute("roles", new RolesEntity());
        model.addAttribute("usuario", new UsuariosEntity());
        return "loginView/propietario";
    }



    @RequestMapping(value = "/createProp", method = POST)
    public String propietarioNewInsert(@ModelAttribute("propietario") PropietariosEntity propietario, Model model, RedirectAttributes atributos, HttpSession ses) {

        Tools tools = new Tools();
        UsuariosEntity usuario = new UsuariosEntity();
        RolesEntity rol = new RolesEntity();
        String contrasenna = String.valueOf(tools.GenerarContraseña());
        String encripted = (tools.encriptarContraseña(contrasenna));
        String correo = (String) ses.getAttribute("correo");
        String user = tools.GenerarUsername(propietario.getNombresProp(), propietario.getApellidosProp());
        String idIniciales = tools.GenerarIdIniciales(propietario.getNombresProp(), propietario.getApellidosProp());
        String idNRamdom = tools.GenerarIdNRandom();
        String username = user + idNRamdom;
        String idUser = idIniciales + idNRamdom;

        usuario.setUsuarioId(idUser);
        usuario.setUsername(username);
        usuario.setCorreoUser(correo);
        usuario.setContrasenaUser(encripted);
        rol.setRolId("1");
        usuario.setRolesByRolId(rol);
        usuario.setEstadoUser("Activo");

        int resultUsuario = LoginModel.insertarUsuario(usuario);
        if (resultUsuario == 1){
            EnviarCredenciales(contrasenna,username,ses);
            EmpleadosEntity empleado = new EmpleadosEntity();
            propietario.setPropietarioId(idUser+"P");
            propietario.setUsuariosByUsuarioPropietario(usuario);
            propietario.setFotoProp("default.png");
            propietario.setEstadoProp("Activo");
            empleado.setEmpleadoId("CR421E");
            propietario.setEmpleadosByGestorId(empleado);
            LoginModel.insertarProp(propietario);
        }
        return "redirect:/Login";
    }
    /*Registrarse como propietario*/


    /*Olvide mi contraseña*/
    /*Redirecciono a la vista para ingresar el correo*/

    @RequestMapping(value = "/olvido", method = GET)
    public String olvido(Model model) {
        model.addAttribute("usuario", new UsuariosEntity());
        return "loginView/cambiarcontra";
    }

    @RequestMapping(value = "/cambiarComprobación", method = POST)
    String cambiarComprobación(@RequestParam String email , HttpSession ses) {
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

        Tools tools = new Tools();
        String codigo = String.valueOf(tools.GenerarContraseña());
        try {
            ses.setAttribute("codigoSesion", codigo);
            ses.setAttribute("correo", email);
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("✨ Codigo Generado ✨"); // Cambia el asunto del correo según tus necesidades
            String contenidoCorreo = "¡Hola! 😊\n\n";
            contenidoCorreo += "     Codigo de verificación:      " +codigo+ "\n";
            contenidoCorreo += "************\n\n";
            contenidoCorreo += "Por favor, guarda esta codigo de forma segura\n\n";
            contenidoCorreo += "¡Gracias y ten un buen día!\n";
            message.setText(contenidoCorreo); // Agrega el contenido del correo
            // Enviar el mensaje
            Transport.send(message);
            return "redirect:/Login/comprobarCambiar";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/Login";
        }
    }

    @GetMapping("/comprobarCambiar")
    public String comprobarCambiar() {

        return "loginView/comprobarCambiar";
    }

    @RequestMapping(value = "/verificarCodigoCambiar", method = POST)
    String verificarCodigoCambiar(@RequestParam String codigo, HttpSession session,HttpSession ses, Model model) {
        // Recuperar el código almacenado en la variable de sesión
        String codigoSesion = (String) session.getAttribute("codigoSesion");
        model.addAttribute("usuario", new UsuariosEntity());
        UsuariosEntity usuario = new UsuariosEntity();
        System.out.println(codigoSesion);
        System.out.println(codigo);
        if (codigoSesion != null && codigoSesion.equals(codigo)) {

            Tools tools = new Tools();

            String correo = (String) ses.getAttribute("correo");
            String contraseña = String.valueOf(tools.GenerarContraseña());
            String encrypted = tools.encriptarContraseña(contraseña);
            EnviarCredencialesCambio(contraseña,ses);
            usuario.setContrasenaUser(encrypted);
            LoginModel.updateCont(usuario,correo);
            return "redirect:/Login"; // Redirige a la página de éxito
        } else {
            // El código es incorrecto, realiza la acción en caso de error
            return "redirect:/Login"; // Redirige a la página de error
        }
    }

    public void EnviarCredencialesCambio(String contrasenna, HttpSession ses) {
        final String fromEmail = "javaprueba2023@gmail.com"; // Cambia esto al correo desde el que enviarás el mensaje
        final String password = "rxgfdspfuoyetrze"; // Cambia esto a tu contraseña de correo
        String correo = (String) ses.getAttribute("correo");
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
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject("✨ Codigo Generado ✨"); // Cambia el asunto del correo según tus necesidades
            String contenidoCorreo = "¡Hola! 😊\n\n";
            contenidoCorreo += "     Su contraseña es:      " + contrasenna + "\n";
            contenidoCorreo += "************\n\n";
            contenidoCorreo += "Por favor, guarda esta codigo de forma segura\n\n";
            contenidoCorreo += "¡Gracias y ten un buen día!\n";
            message.setText(contenidoCorreo); // Agrega el contenido del correo
            // Enviar el mensaje
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

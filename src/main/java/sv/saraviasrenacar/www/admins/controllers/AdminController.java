package sv.saraviasrenacar.www.admins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.saraviasrenacar.www.admins.models.*;
import sv.saraviasrenacar.www.entities.*;
import sv.saraviasrenacar.www.tools.Tools;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Controller
@RequestMapping("Administrador")
@SessionAttributes({"usuarioId", "rolId"})
public class AdminController {
	EmpleadoModel empleadosModel = new EmpleadoModel();
	UsuarioModel usuarioModel = new UsuarioModel();
	AdminModel adminModel = new AdminModel();
	ClientesModel clientesModel = new ClientesModel();
	PropietariosModel propietariosModel = new PropietariosModel();

	@ModelAttribute("rolId")
	public String getRolId(@ModelAttribute("rolId") String rolId) {
		return rolId;
	}
	@ModelAttribute("usuarioId")
	public String getUsuarioId(@ModelAttribute("usuarioId") String usuarioId) {
		return usuarioId;
	}


	@GetMapping("/")
	public String index() {
		return "adminsView/adminDashboard";
	}

	@GetMapping("/panel")
	public String panel() {
		return "adminsView/adminDashboard";
	}

	@RequestMapping(value = "/panel/clientes", method = GET)
	public String clientes(ModelMap model) {
		model.addAttribute("clientes", clientesModel.listarClientes());
		return "adminsView/gestionClientes";
	}

	@RequestMapping(value = "/panel/clientes/{id}", method = GET)
	public String clientesProfile(@PathVariable("id") String id, Model model) {
		ClientesEntity cliente = clientesModel.obtenerCliente(id);

		if (cliente != null) {
			UsuariosEntity usuario = cliente.getUsuariosByUsuarioCliente(); // Obtenemos el usuario asociado al empleado
			model.addAttribute("cliente", cliente);
			model.addAttribute("usuario", usuario); // Pasamos el usuario a la vista
		}
		return "adminsView/perfilClientes";
	}

	@RequestMapping(value = "/panel/clientes/desactivar", method = POST)
	public String desactivarCliente(Model model, @RequestParam("usuarioId") String usuarioId,
									@RequestParam("clienteId") String clienteId) {
		String nuevoEstado = "Inactivo";
		clientesModel.cambiarEstadoCliente(clienteId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/clientes";
	}

	@RequestMapping(value = "/panel/clientes/activar", method = POST)
	public String activarCLiente(Model model, @RequestParam("usuarioId") String usuarioId,
								 @RequestParam("clienteId") String clienteId) {
		String nuevoEstado = "Activo";
		clientesModel.cambiarEstadoCliente(clienteId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/clientes";
	}

	@RequestMapping(value = "/panel/empleados", method = GET)
	public String empleados(ModelMap model) {
		model.addAttribute("empleados", EmpleadoModel.listarEmpleado());
		return "adminsView/gestionEmpleados";
	}

	@GetMapping("/panel/empleados/edit")
	public String empleadoEdit() {
		return "adminsView/editar";
	}


	@RequestMapping(value = "/panel/empleados/new", method = GET)
	public String empleadoNew(Model model) {
		model.addAttribute("empleado", new EmpleadosEntity());
		model.addAttribute("roles", new RolesEntity());
		model.addAttribute("usuario", new UsuariosEntity());

		return "adminsView/nuevo";
	}

	@RequestMapping(value = "/panel/empleados/create", method = POST)
	public String empleadoNewInsert(@ModelAttribute("empleado") EmpleadosEntity empleado, Model model, RedirectAttributes atributos, HttpSession ses
	) {

		Tools tools = new Tools();
		UsuariosEntity usuario = new UsuariosEntity();
		RolesEntity rol = new RolesEntity();
		AdministradoresEntity admin = new AdministradoresEntity();

		String contrasenna = String.valueOf(tools.GenerarContraseña());
		String user = tools.GenerarUsername(empleado.getNombresEmp(), empleado.getApellidosEmp());
		String idIniciales = tools.GenerarIdIniciales(empleado.getNombresEmp(), empleado.getApellidosEmp());
		String idNRamdom = tools.GenerarIdNRandom();
		String username = user + idNRamdom;
		String idUser = idIniciales + idNRamdom;
		String password = tools.encriptarContraseña(contrasenna);

		System.out.println("Correo:" + empleado.getCorreo());

		usuario.setUsuarioId(idUser);
		usuario.setUsername(username);
		usuario.setCorreoUser(empleado.getCorreo());
		usuario.setContrasenaUser(password);
		rol.setRolId("3");
		usuario.setRolesByRolId(rol);
		usuario.setEstadoUser("Activo");

		EnviarCredenciales(contrasenna, username, empleado.getCorreo());


		int resultUsuario = UsuarioModel.insertarUsuario(usuario);

		if (resultUsuario == 1) {

			empleado.setEmpleadoId(idUser + "E");
			empleado.setUsuariosByUsuarioEmpleado(usuario);
			empleado.setFotoEmp("default.png");
			empleado.setEstadoEmp("Activo");
			admin.setAdministradorId("EF306A");
			empleado.setAdministradoresByCreadorId(admin);

			EmpleadoModel.insertarEmpleado(empleado);
		}
		return "redirect:/Administrador/panel/empleados";
	}

	@RequestMapping(value = "/panel/empleados/desactivar", method = POST)
	public String desactivar(Model model, @RequestParam("usuarioId") String usuarioId,
							 @RequestParam("empleadoId") String empleadoId) {
		String nuevoEstado = "Inactivo";
		empleadosModel.cambiarEstadoEmpleado(empleadoId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/empleados";
	}

	@RequestMapping(value = "/panel/empleados/activar", method = POST)
	public String activar(Model model, @RequestParam("usuarioId") String usuarioId,
						  @RequestParam("empleadoId") String empleadoId) {
		String nuevoEstado = "Activo";
		empleadosModel.cambiarEstadoEmpleado(empleadoId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/empleados";
	}


	@RequestMapping(value = "/panel/proveedores", method = GET)
	public String proveedores(ModelMap model) {
		model.addAttribute("proveedores", propietariosModel.listarPropietarios());
		return "adminsView/gestionProveedores";
	}

	@RequestMapping(value = "/panel/proveedores/{id}", method = GET)
	public String proveedoresProfile(@PathVariable("id") String id, Model model) {
		PropietariosEntity propietario = propietariosModel.obtenerPropietarios(id);

		if (propietario != null) {
			UsuariosEntity usuario = propietario.getUsuariosByUsuarioPropietario(); // Obtenemos el usuario asociado al empleado
			model.addAttribute("proveedor", propietario);
			model.addAttribute("usuario", usuario); // Pasamos el usuario a la vista
		}
		return "adminsView/perfilProveedor";
	}

	@RequestMapping(value = "/panel/proveedores/desactivar", method = POST)
	public String desactivarProveedores(Model model, @RequestParam("usuarioId") String usuarioId,
										@RequestParam("propietarioId") String propietarioId) {
		String nuevoEstado = "Inactivo";
		propietariosModel.cambiarEstadoPropietario(propietarioId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/proveedores";
	}

	@RequestMapping(value = "/panel/proveedores/activar", method = POST)
	public String activarProveedores(Model model, @RequestParam("usuarioId") String usuarioId,
									 @RequestParam("propietarioId") String propietarioId) {
		String nuevoEstado = "Activo";
		propietariosModel.cambiarEstadoPropietario(propietarioId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/proveedores";
	}


	@RequestMapping(value = "/panel/admin", method = GET)
	public String administrador(ModelMap model) {
		model.addAttribute("admin", adminModel.listarAdministrador());
		return "adminsView/gestionAdministrador";
	}

	@RequestMapping(value = "/panel/admin/new", method = GET)
	public String adminNew(Model model) {
		model.addAttribute("admin", new AdministradoresEntity());
		model.addAttribute("roles", new RolesEntity());
		model.addAttribute("usuario", new UsuariosEntity());

		return "adminsView/nuevoAdmin";

	}

	@RequestMapping(value = "/panel/admin/create", method = POST)
	public String adminNewInsert(@ModelAttribute("admin") AdministradoresEntity administrador, Model model, RedirectAttributes atributos, HttpSession ses) {

		Tools tools = new Tools();
		UsuariosEntity usuario = new UsuariosEntity();
		RolesEntity rol = new RolesEntity();

		String contrasenna = String.valueOf(tools.GenerarContraseña());
		String user = tools.GenerarUsername(administrador.getNombresAdmin(), administrador.getApellidosAdmin());
		String idIniciales = tools.GenerarIdIniciales(administrador.getNombresAdmin(), administrador.getApellidosAdmin());
		String idNRamdom = tools.GenerarIdNRandom();
		String username = user + idNRamdom;
		String idUser = idIniciales + idNRamdom;
		String password = tools.encriptarContraseña(contrasenna);


		usuario.setUsuarioId(idUser);
		usuario.setUsername(username);
		usuario.setCorreoUser(administrador.getCorreoAdmin());
		usuario.setContrasenaUser(password);
		rol.setRolId("2");
		usuario.setRolesByRolId(rol);
		usuario.setEstadoUser("Activo");

		EnviarCredenciales(contrasenna, username, administrador.getCorreoAdmin());

		int resultUsuario = UsuarioModel.insertarUsuario(usuario);

		if (resultUsuario == 1) {

			administrador.setAdministradorId(idUser + "A");
			administrador.setUsuariosByUsuarioAdmin(usuario);
			administrador.setFotoAdmin("default.png");
			administrador.setNombresAdmin(administrador.getNombresAdmin());
			administrador.setApellidosAdmin(administrador.getApellidosAdmin());
			administrador.setTelefonoAdmin(administrador.getTelefonoAdmin());
			administrador.setEstadoAdmin("Activo");

			AdminModel.insertarAdministrador(administrador);
		}
		return "redirect:/Administrador/panel/admin";
	}

	@RequestMapping(value = "/panel/admin/{id}", method = GET)
	public String adminProfile(@PathVariable("id") String id, Model model) {
		AdministradoresEntity admin = adminModel.obtenerAdministrador(id);

		if (admin != null) {
			UsuariosEntity usuario = admin.getUsuariosByUsuarioAdmin(); // Obtenemos el usuario asociado al empleado
			model.addAttribute("admin", admin);
			model.addAttribute("usuario", usuario); // Pasamos el usuario a la vista
		}
		return "adminsView/perfilAdmin";
	}

	@RequestMapping(value = "/panel/admin/desactivar", method = POST)
	public String desactivarAdmin(Model model, @RequestParam("usuarioId") String usuarioId,
								  @RequestParam("adminId") String adminId) {
		String nuevoEstado = "Inactivo";
		adminModel.cambiarEstadoAdministrador(adminId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/admin";
	}

	@RequestMapping(value = "/panel/admin/activar", method = POST)
	public String activarAdmin(Model model, @RequestParam("usuarioId") String usuarioId,
							   @RequestParam("adminId") String adminId) {
		String nuevoEstado = "Activo";
		adminModel.cambiarEstadoAdministrador(adminId, nuevoEstado);
		usuarioModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/Administrador/panel/admin";
	}


	@RequestMapping(value = "/panel/empleados/{id}", method = GET)
	public String empleadoProfile(@PathVariable("id") String id, Model model, HttpSession session) {
		EmpleadosEntity empleado = empleadosModel.obtenerEmpleado(id);

		if (empleado != null) {
			UsuariosEntity usuario = empleado.getUsuariosByUsuarioEmpleado(); // Obtenemos el usuario asociado al empleado
			model.addAttribute("empleado", empleado);
			model.addAttribute("usuario", usuario); // Pasamos el usuario a la vista
			session.setAttribute("emisor", "DC312");
		}

		return "adminsView/perfil";
	}

	@RequestMapping(value = "/panel/admin/listamensaje", method = POST)
	public String chat(ModelMap model, HttpSession session, @RequestParam("receptor") String receptor) {
		// Obtener variables de sesión del controlador de login

		String emisor = (String) session.getAttribute("usuarioId");
		String rolId = (String) session.getAttribute("rolId");
		String userName = (String) session.getAttribute("userName");
		session.setAttribute("receptor", receptor);

		List<MensajesEntity> mensajes = ChatModel.listarMensajes(emisor, receptor);
		model.addAttribute("mensajes", mensajes);
		System.out.println("estos son los que salen" + emisor + receptor);

		return "adminsView/chat";
	}


	@RequestMapping(value = "/createMensaje", method = RequestMethod.POST)
	public String createMensaje(@ModelAttribute("mensaje") MensajesEntity mensaje,
								HttpSession session, // Agrega el objeto HttpSession
								Model model, RedirectAttributes atributos) {

		// Obtener el valor del emisor desde la sesión
		String receptor = (String) session.getAttribute("receptor");

		String emisor = (String) session.getAttribute("usuarioId");
		MensajesEntity mensajeIn = new MensajesEntity();
		UsuariosEntity usuario = new UsuariosEntity();
		usuario.setUsuarioId(emisor);
		mensajeIn.setUsuariosByEmisorMensaje(usuario);
		UsuariosEntity usuario2 = new UsuariosEntity();
		usuario2.setUsuarioId(receptor);
		mensajeIn.setUsuariosByReceptorMensaje(usuario2);
		mensajeIn.setMensaje(mensaje.getMensaje());
		mensajeIn.setEstadoMensaje("Leido");
		ChatModel.insertarMensaje(mensajeIn);
		return "redirect:/Administrador/panel/admin/listamensaje";
	}





/* Metodos de correo */
	public void EnviarCredenciales(String contrasenna, String usuario, String correo) {
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
}
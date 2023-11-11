package sv.saraviasrenacar.www.empleados.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sv.saraviasrenacar.www.empleados.models.EmpleadoCLIModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoUSUModel;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("EmpleadoCLI")

public class EmpleadoCLIController {
	EmpleadoCLIModel empleadoCLIModel = new EmpleadoCLIModel();
	EmpleadoUSUModel empleadoUSUModel = new EmpleadoUSUModel();
	@RequestMapping(value = "listcli", method = RequestMethod.GET)

	public String listarClientesEstado(ModelMap modelMap) {
		// Filtrar las ventas por estado (por ejemplo, 'Activa')
		String estadoDeseado = "Activo";


		// Pasar la lista de ventas filtradas hacia la vista
		modelMap.addAttribute("listaCliente", EmpleadoCLIModel.listarClientesEstado(estadoDeseado));

		// Redireccionar a la página .jsp que mostrará las ventas filtradas
		return "empleadosView/gestionClientes";

	}

	@RequestMapping(value = "listcli", method = RequestMethod.POST)

	public String listarCliente(@RequestParam("estadoCliente") String activo, ModelMap modelMap) {

		// Pasar la lista de ventas filtradas hacia la vista
		modelMap.addAttribute("listaCliente", EmpleadoCLIModel.listarClientesEstado(activo));
		modelMap.addAttribute("estadoCliente", activo);

		// Redireccionar a la página .jsp que mostrará las ventas filtradas
		return "empleadosView/gestionClientes";

	}

	@RequestMapping(value = "/clientep/{id}", method = GET)
	public String empleadoProfile(@PathVariable("id") String id, Model model) {
		ClientesEntity clientes = empleadoCLIModel.obtenerCliente(id);

		if (clientes != null) {
			UsuariosEntity usuariocliente = clientes.getUsuariosByUsuarioCliente(); // Obtenemos el usuario asociado al empleado
			model.addAttribute("cliente", clientes);
			model.addAttribute("usuario", usuariocliente); // Pasamos el usuario a la vista
		}

		return "empleadosView/ClientesP";
	}

	@RequestMapping(value = "/clientep/activar", method = POST)
	public String activarCliente(Model model, @RequestParam("usuarioId") String usuarioId,
						  @RequestParam("clienteId") String clienteId) {
		String nuevoEstado = "Activo";
		empleadoCLIModel.cambiarEstadoCliente(clienteId, nuevoEstado);
		empleadoUSUModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/EmpleadoCLI/listcli";
	}

	@RequestMapping(value = "/clientep/desactivar", method = POST)
	public String desactivarCliente(Model model, @RequestParam("usuarioId") String usuarioId,
						  @RequestParam("clienteId") String clienteId) {
		String nuevoEstado = "Inactivo";
		empleadoCLIModel.cambiarEstadoCliente(clienteId, nuevoEstado);
		empleadoUSUModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);
		return "redirect:/EmpleadoCLI/listcli";
	}


	@RequestMapping(value = "/clientep/historial", method = POST)
	public String historialPropietario(Model model, @RequestParam("clienteId") String clienteId){

		model.addAttribute("compravehiculo",empleadoCLIModel.obtenerVentasPorCliente(clienteId));
		model.addAttribute("arquilervehiculocli",empleadoCLIModel.obtenerAlquilerPorCliente(clienteId));

		return "empleadosView/HistorialC";
	}

}




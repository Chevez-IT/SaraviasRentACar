package sv.saraviasrenacar.www.propietarios.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.entities.VehiculosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.propietarios.models.AlquileresModel;
import sv.saraviasrenacar.www.propietarios.models.VehiculosModel;
import sv.saraviasrenacar.www.propietarios.models.VentasModel;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("Propietario")
public class PropietarioController {
	int rolId = 1;
	String idUsuario ="BC321";
	String idPropietario ="BC321P";


	//Controlamos el acceso a las rutas
	public boolean verificarAcceso(Integer rolId) {
		return rolId != null && rolId.equals(1);
	}

	AlquileresModel alquileresModel = new AlquileresModel();
	VentasModel ventasModel = new VentasModel();

	VehiculosModel vehiculosModel = new VehiculosModel();

	//	Ruta Inicial
	@GetMapping("/")
	public String index(ModelMap modelMap) {
		if(!verificarAcceso(rolId)){
			return "redirect:/otraRuta";
		}else{
			List<ArquileresEntity> arquileresEnEspera = alquileresModel.listarPorPropietarioYEstado(idPropietario, "En espera");
			List<ArquileresEntity> arquileresActivos = alquileresModel.listarPorPropietarioYEstado(idPropietario, "Arquilado");
			int nArquileresEnEspera = arquileresEnEspera.size();
			int nArquileresActivos = arquileresActivos.size();
			modelMap.addAttribute("alquileresEnEspera", alquileresModel.listarPorPropietarioYEstado(idPropietario, "En espera"));
			modelMap.addAttribute("nArquileresEnEspera", nArquileresEnEspera);
			modelMap.addAttribute("nArquileresActivos", nArquileresActivos);

			List<VentasEntity> ventasEnEspera = ventasModel.listarPorPropietarioYEstado(idPropietario, "En espera");
			List<VentasEntity> ventasActivas = ventasModel.listarPorPropietarioYEstado(idPropietario, "Vendido");
			int nVentasEnEspera = ventasEnEspera.size();
			int nVentasActivas = ventasActivas.size();
			modelMap.addAttribute("ventasEnEspera", ventasModel.listarPorPropietarioYEstado(idPropietario, "En espera"));
			modelMap.addAttribute("nVentasEnEspera", nVentasEnEspera);
			modelMap.addAttribute("nVentasActivas", nVentasActivas);

			List<VehiculosEntity> vehiculosEnEspera = vehiculosModel.listarPorPropietarioYEstado(idPropietario, "En espera");
			int nVehiculosEnEspera = vehiculosEnEspera.size();
			modelMap.addAttribute("vehiculosEnEspera", vehiculosModel.listarPorPropietarioYEstado(idPropietario, "En espera"));
			modelMap.addAttribute("nVehiculosEnEspera", nVehiculosEnEspera);

			return "propietariosView/propietarioDashboard";
		}
	}

//	Rutas para la gestion de vehiculos
	@GetMapping("/Vehiculos/Nuevo")
	public String nuevoVehiculo() {
		return "propietariosView/propietarioNuevoCarro";
	}

	@GetMapping("/Vehiculos/Rechazados")
	public String vehiculosRechazados() {
		return "propietariosView/propietarioCarros";
	}

	@GetMapping("/Vehiculos/Disponibles")
	public String vehiculosDisponibles() {
		return "propietariosView/propietarioCarros";
	}

	@GetMapping("/Vehiculos/EnEspera")
	public String vehiculosEnEspera() {
		return "propietariosView/propietarioCarros";
	}

	@GetMapping("/Vehiculos/Vendidos")
	public String vehiculosVendidos() {
		return "propietariosView/propietarioCarros";
	}

	@GetMapping("/Vehiculos/Alquilados")
	public String vehiculosAlquilados() {
		return "propietariosView/propietarioCarros";
	}

	@GetMapping("/Vehiculos")
	public String vehiculos() {
		return "propietariosView/propietarioCarros";
	}

	@GetMapping("/Vehiculos/Editar")
	public String editarVehiculo(@PathVariable Long idVehiculo) {
		return "propietariosView/propietarioEditarCarro";
	}


//	Rutas para la gestion de ventas
	@GetMapping("/Ventas/Nuevo")
	public String nuevaVenta() {
		return "propietariosView/propietarioNuevaVenta";
	}
	@GetMapping("/Ventas/Disponibles")
	public String ventasDisponibles() {
		return "propietariosView/propietarioVentas";
	}
	@GetMapping("/Ventas/NoDisponibles")
	public String ventasNoDisponibles() {
		return "propietariosView/propietarioVentas";
	}
	@GetMapping("/Ventas")
	public String ventas() {
		return "propietariosView/propietarioVentas";
	}
	@GetMapping("/Ventas/Editar")
	public String editarVenta(@PathVariable Long idVenta) {
		return "propietariosView/propietarioEditarVenta";
	}


//	Rutas para la gestion de alquileres
	@GetMapping("/Alquileres")
	public String alquileres() {
		return "propietariosView/propietarioAlquileres";
	}
	@GetMapping("/Alquileres/Disponibles")
	public String alquileresDisponibles() {
		return "propietariosView/propietarioVentas";
	}
	@GetMapping("/Alquileres/NoDisponibles")
	public String alquileresNoDisponibles() {
		return "propietariosView/propietarioVentas";
	}
	@GetMapping("/Alquileres/Nuevo")
	public String nuevoAlquiler() {
		return "propietariosView/propietarioVentas";
	}
	@GetMapping("/Alquileres/Editar")
	public String editarAlquiler(@PathVariable Long idAlquiler) {
		return "propietariosView/propietarioEditarAlquiler";
	}


//	Rutas para la gestion de la informacion del usuario
	@GetMapping("/MiPefil")
	public String perfil() {
		return "propietariosView/propietarioPerfil";
	}
	@GetMapping("/MiPefil/NuevaContraseña")
	public String perfilNuevaContrasena() {
		return "propietariosView/propietarioContraseña";
	}


}

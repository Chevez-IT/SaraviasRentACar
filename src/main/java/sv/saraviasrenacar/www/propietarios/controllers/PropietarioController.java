package sv.saraviasrenacar.www.propietarios.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("Propietario")
public class PropietarioController {
//	Ruta Inicial
	@GetMapping("/")
	public String index() {
		return "propietariosView/propietarioDashboard";
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

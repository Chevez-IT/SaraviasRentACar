package sv.saraviasrenacar.www.propietarios.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sv.saraviasrenacar.www.entities.*;
import sv.saraviasrenacar.www.propietarios.models.AlquileresModel;
import sv.saraviasrenacar.www.propietarios.models.UsuariosModel;
import sv.saraviasrenacar.www.propietarios.models.VehiculosModel;
import sv.saraviasrenacar.www.propietarios.models.VentasModel;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("Propietario")
public class PropietarioController {
	AlquileresModel alquileresModel = new AlquileresModel();
	VentasModel ventasModel = new VentasModel();
	VehiculosModel vehiculosModel = new VehiculosModel();
	UsuariosModel usuariosModel = new UsuariosModel();


	//Controlamos el acceso a las rutas
	public boolean verificarAcceso(String rolId) {
		return rolId != null && rolId.equals("1");
	}

	//	Ruta Inicial
	@GetMapping("/")
	public String index(HttpSession session, ModelMap modelMap) {
		String rolId = (String) session.getAttribute("rolId");
		String usuarioId = (String) session.getAttribute("usuarioId");
		String idPropietario = usuarioId+"P";
		if (!verificarAcceso(rolId)) {
			return "redirect:/otraRuta";
		} else {
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

			List<VehiculosEntity> vehiculosEnEspera = vehiculosModel.listarPorPropietarioYEstado(idPropietario,
					"Activo");
			int nVehiculosEnEspera = vehiculosEnEspera.size();
			modelMap.addAttribute("vehiculosEnEspera", vehiculosModel.listarPorPropietarioYEstado(idPropietario,
					"Activo"));
			modelMap.addAttribute("nVehiculosEnEspera", nVehiculosEnEspera);

			return "propietariosView/propietarioDashboard";
		}
	}

	//	Rutas para la gestion de vehiculos
	@GetMapping("/Vehiculos/Nuevo")
	public String nuevoVehiculo() {
		return "propietariosView/propietarioNuevoCarro";
	}

	@PostMapping ("/Vehiculos/Nuevo/Crear")
	public String crearVehiculo(@RequestParam("inputImagenes") MultipartFile[] imagenes,
								VehiculosEntity vehiculo, ModelMap model,HttpSession session ) {
		String usuarioId = (String) session.getAttribute("usuarioId");
		return "propietariosView/propietarioCarros";
	}

	@GetMapping("/Vehiculos/Disponibles")
	public String vehiculosDisponibles(HttpSession session, ModelMap modelMap) {
		String rolId = (String) session.getAttribute("rolId");
		String usuarioId = (String) session.getAttribute("usuarioId");
		String idPropietario = usuarioId+"P";
		if (!verificarAcceso(rolId)) {
			return "redirect:/otraRuta";
		} else {
			List<VehiculosEntity> vehiculosDisponibles = vehiculosModel.listarPorPropietarioYEstado(idPropietario,
					"Activo");
			modelMap.addAttribute("vehiculos", vehiculosModel.listarPorPropietarioYEstado(idPropietario,
					"Activo"));
			return "propietariosView/propietarioCarros";
		}
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
	public String perfil(HttpSession session, ModelMap modelMap) {
		String usuarioId = (String) session.getAttribute("usuarioId");
		String propietarioId = usuarioId+"P";
		modelMap.addAttribute("usuario", usuariosModel.obtenerUsuarioPorId(usuarioId));
		modelMap.addAttribute("propietario", usuariosModel.obtenerPropietarioPorId(propietarioId));
		return "propietariosView/propietarioPerfil";
	}
	@PostMapping("/MiPerfil/ActualizarInfo")
	public String perfilActualizarInfo(@ModelAttribute PropietariosEntity propietario,
									   @ModelAttribute UsuariosEntity usuario,
									   HttpSession session) {

		usuariosModel.actualizarInformacionUsuario(usuario);
		usuariosModel.actualizarInformacionPropietario(propietario);

		return "redirect:/Propietario/MiPefil";
	}

	@PostMapping("/MiPerfil/ActualizarFoto")
	public String perfilActualizarFoto(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		String usuarioId = (String) session.getAttribute("usuarioId");
		String propietarioId = usuarioId + "P";

		String nombreImagen = guardarImagen(file, propietarioId, "../resources/img/perfilesImg/");

		// Actualizar el nombre de la imagen en el perfil del propietario
		usuariosModel.actualizarNombreImagenPropietario(propietarioId, nombreImagen);

		return "redirect:/Propietario/MiPefil";
	}

	public static String guardarImagen(MultipartFile file, String nombreImg, String directorioBase) throws IOException {
		// Obtenemos el nombre original del archivo
		String nombreOriginal = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

		// Generamos un nombre único para evitar conflictos
		String nombreImagen = "propietario" + nombreImg + "_" + System.currentTimeMillis() + "_" + nombreOriginal;

		// Construimos la ruta completa donde se guardará la imagen
		Path rutaCompleta = Paths.get(directorioBase, nombreImagen);

		try {
			// Copiamos el contenido del archivo al nuevo archivo en la ruta especificada
			Files.copy(file.getInputStream(), rutaCompleta);
			return nombreImagen;
		} catch (IOException e) {
			// Manejar la excepción (puedes lanzarla nuevamente o loguearla)
			throw new IOException("Error al guardar la imagen: " + e.getMessage());
		}
	}


	@GetMapping("/MiPefil/NuevaContraseña")
	public String perfilNuevaContrasena() {
		return "propietariosView/propietarioContraseña";
	}


}

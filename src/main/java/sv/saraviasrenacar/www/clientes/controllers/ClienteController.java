package sv.saraviasrenacar.www.clientes.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.saraviasrenacar.www.clientes.models.AlquileresModel;
import sv.saraviasrenacar.www.clientes.models.VehiculosModel;
import sv.saraviasrenacar.www.clientes.models.VentasModel;
import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.entities.ImgVehiculosEntity;
import sv.saraviasrenacar.www.entities.VehiculosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;

@Controller
@RequestMapping("Cliente")
public class ClienteController {


	AlquileresModel alquileresModel = new AlquileresModel();

	VehiculosModel vehiculosModel = new VehiculosModel();
	VentasModel ventasModel = new VentasModel();
	@GetMapping("/")
	public String index(ModelMap modelMap) {

		try {
			// Obtener alquileres disponibles
			List<ArquileresEntity> alquileresDisponibles = alquileresModel.obtenerAlquileresDisponibles();
			// Lista para almacenar la información completa de cada alquiler con su vehículo e imágenes
			List<Object> alquileresInfo = new ArrayList<>();
			// Por cada alquiler, obtener información del vehículo y sus imágenes
			for (ArquileresEntity alquiler : alquileresDisponibles) {
				String idVehiculo = alquiler.getVehiculosByVehiculoId().getVehiculoId(); // Obtener ID del vehículo
				VehiculosEntity vehiculo = vehiculosModel.obtenerPorId(idVehiculo); // Obtener información del vehículo
				List<ImgVehiculosEntity> imagenes = vehiculosModel.obtenerImagenesPorIdVehiculo(idVehiculo); //
				// Obtener imágenes

				// Crear un DTO (Data Transfer Object) para almacenar toda la información necesaria
				AlquilerDTO alquilerInfo = new AlquilerDTO(alquiler, vehiculo, imagenes);
				alquileresInfo.add(alquilerInfo);
			}


			// Obtener alquileres disponibles
			List<VentasEntity> ventasDisponibles = ventasModel.obtenerVentasDisponibles();
			// Lista para almacenar la información completa de cada alquiler con su vehículo e imágenes
			List<Object> VentasInfo = new ArrayList<>();
			// Por cada alquiler, obtener información del vehículo y sus imágenes
			for (VentasEntity ventas : ventasDisponibles) {
				String idVehiculo = ventas.getVehiculosByVehiculoId().getVehiculoId(); // Obtener ID del vehículo
				VehiculosEntity vehiculo = vehiculosModel.obtenerPorId(idVehiculo); // Obtener información del vehículo
				List<ImgVehiculosEntity> imagenes = vehiculosModel.obtenerImagenesPorIdVehiculo(idVehiculo); //
				// Obtener imágenes

				// Crear un DTO (Data Transfer Object) para almacenar toda la información necesaria
				VentasDTO ventaInfo = new VentasDTO(ventas, vehiculo, imagenes);
				VentasInfo.add(ventaInfo);
			}

			// Agregar la lista completa al modelo
			modelMap.addAttribute("alquileresInfo", alquileresInfo);
			modelMap.addAttribute("ventasInfo", VentasInfo);

			return "webView/inicio";
		} catch (Exception e) {
			// Manejar excepciones según tus necesidades
			return "redirect:/error"; // Página de error
		}
	}
}

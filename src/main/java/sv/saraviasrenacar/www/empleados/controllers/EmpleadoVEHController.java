package sv.saraviasrenacar.www.empleados.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sv.saraviasrenacar.www.empleados.models.EmpleadoUSUModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoVEHModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoVENModel;
import sv.saraviasrenacar.www.entities.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("EmpleadoVEH")

public class EmpleadoVEHController {

    EmpleadoVEHModel empleadoVEHModel = new EmpleadoVEHModel();

    @RequestMapping(value = "listveh", method = RequestMethod.GET)

    public String listarVehiculoEstado(ModelMap modelMap) {
        // Filtrar las ventas por estado (por ejemplo, 'Activa')
        String estadoDeseado = "Disponible";

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaVehiculo", EmpleadoVEHModel.listarVehiculoEstado(estadoDeseado));

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionVehiculos";

    }

    @RequestMapping(value = "listveh", method = RequestMethod.POST)

    public String listarVehiculo(@RequestParam("estadoVehiculo") String activo, ModelMap modelMap) {

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaVehiculo", EmpleadoVEHModel.listarVehiculoEstado(activo));
        modelMap.addAttribute("estadoVehiculo", activo);

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionVehiculos";

    }

    @RequestMapping(value = "/vehiculop/{id}", method = GET)
    public String vehiculoProfile(@PathVariable("id") String id, Model model) {
        VehiculosEntity vehiculos = empleadoVEHModel.obtenerVehiculo(id);

        if (vehiculos != null) {
            PropietariosEntity propietariovehiculo = vehiculos.getPropietariosByPropietarioVehiculo(); // Obtenemos el usuario asociado al empleado
            model.addAttribute("vehiculos", vehiculos);
            model.addAttribute("propietariovehiculo", propietariovehiculo); // Pasamos el usuario a la vista
        }

        return "empleadosView/VehiculosP";
    }

    @RequestMapping(value = "/vehiculop/activar", method = POST)
    public String activarVehiculo(Model model, @RequestParam("vehiculoId") String vehiculoId) {
        String nuevoEstado = "Activo";
        empleadoVEHModel.cambiarEstadoVehiculo(vehiculoId, nuevoEstado);
        return "redirect:/EmpleadoVEH/listveh";
    }



    @RequestMapping(value = "vehiculop/rechazar", method = RequestMethod.POST)
    public String rechazarVehiculo(Model model, @RequestParam("vehiculoId") String vehiculoId) {
        String nuevoEstado = "Inactivo";
        empleadoVEHModel.cambiarEstadoVehiculo(vehiculoId, nuevoEstado);
        return "redirect:/EmpleadoVEH/listveh";
    }

}

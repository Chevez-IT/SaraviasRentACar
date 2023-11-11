package sv.saraviasrenacar.www.empleados.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sv.saraviasrenacar.www.empleados.models.EmpleadoUSUModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoVENModel;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("EmpleadoVEN")

public class EmpleadoVENController {

    EmpleadoVENModel empleadoVENModel = new EmpleadoVENModel();

    @RequestMapping(value = "listven", method = RequestMethod.GET)

    public String listarVentaEstado(ModelMap modelMap) {
        // Filtrar las ventas por estado (por ejemplo, 'Activa')
        String estadoDeseado = "Disponible";

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaVentaDIS", EmpleadoVENModel.listarVentaEstado(estadoDeseado));

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionVentas";

    }

    @RequestMapping(value = "listven", method = RequestMethod.POST)

    public String listarVentas(@RequestParam("estadoVenta") String activo, ModelMap modelMap) {

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaVentaDIS", EmpleadoVENModel.listarVentaEstado(activo));
        modelMap.addAttribute("estadoVenta", activo);

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionVentas";

    }

    @RequestMapping(value = "aprobar", method = RequestMethod.POST)
    public String aprobarPendiente(Model model, @RequestParam("ventaId") String ventaId) {
        String nuevoEstado = "Disponible";
        empleadoVENModel.cambiarEstadoVenta(ventaId, nuevoEstado);
        return "redirect:/EmpleadoVEN/listven";
    }

    @RequestMapping(value = "rechazar", method = RequestMethod.POST)
    public String rechazarPendiente(Model model, @RequestParam("ventaId") String ventaId) {
        String nuevoEstado = "Rechazado";
        empleadoVENModel.cambiarEstadoVenta(ventaId, nuevoEstado);
        return "redirect:/EmpleadoVEN/listven";
    }

    @RequestMapping(value = "vender", method = RequestMethod.POST)
    public String venderOferta(Model model, @RequestParam("ventaId") String ventaId) {
        String nuevoEstado = "Vendido";
        empleadoVENModel.cambiarEstadoVenta(ventaId, nuevoEstado);
        return "redirect:/EmpleadoVEN/listven";
    }

    @RequestMapping(value = "rechazardis", method = RequestMethod.POST)
    public String rechazarOfertan(Model model, @RequestParam("ventaId") String ventaId) {
        String nuevoEstado = "Disponible";
        empleadoVENModel.cambiarEstadoVenta(ventaId, nuevoEstado);
        return "redirect:/EmpleadoVEN/listven";
    }


}

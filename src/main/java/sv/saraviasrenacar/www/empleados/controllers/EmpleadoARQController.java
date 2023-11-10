package sv.saraviasrenacar.www.empleados.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sv.saraviasrenacar.www.empleados.models.EmpleadoARQModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoUSUModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoVENModel;
import sv.saraviasrenacar.www.entities.UsuariosEntity;
import sv.saraviasrenacar.www.entities.VentasEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("EmpleadoARQ")

public class EmpleadoARQController {

    EmpleadoARQModel empleadoARQModel = new EmpleadoARQModel();

    @RequestMapping(value = "listarq", method = RequestMethod.GET)

    public String listarArquilerEstado(ModelMap modelMap) {
        // Filtrar las ventas por estado (por ejemplo, 'Activa')
        String estadoDeseado = "Disponible";

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaArquiler", EmpleadoARQModel.listarArquilerEstado(estadoDeseado));

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionArquiler";

    }

    @RequestMapping(value = "listarq", method = RequestMethod.POST)

    public String listarArquiler(@RequestParam("estadoArquiler") String activo, ModelMap modelMap) {

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaArquiler", EmpleadoARQModel.listarArquilerEstado(activo));
        modelMap.addAttribute("estadoArquiler", activo);

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionArquiler";

    }

    @RequestMapping(value = "aprobar", method = RequestMethod.POST)
    public String aprobarPendiente(Model model, @RequestParam("arquilerId") String arquilerId) {
        String nuevoEstado = "Disponible";
        empleadoARQModel.cambiarEstadoArquiler(arquilerId, nuevoEstado);
        return "redirect:/EmpleadoARQ/listarq";
    }

    @RequestMapping(value = "rechazar", method = RequestMethod.POST)
    public String rechazarPendiente(Model model, @RequestParam("arquilerId") String arquilerId) {
        String nuevoEstado = "Rechazado";
        empleadoARQModel.cambiarEstadoArquiler(arquilerId, nuevoEstado);
        return "redirect:/EmpleadoARQ/listarq";
    }

    @RequestMapping(value = "arquilar", method = RequestMethod.POST)
    public String venderOferta(Model model, @RequestParam("arquilerId") String arquilerId) {
        String nuevoEstado = "Arquilado";
        empleadoARQModel.cambiarEstadoArquiler(arquilerId, nuevoEstado);
        return "redirect:/EmpleadoARQ/listarq";
    }

    @RequestMapping(value = "rechazardis", method = RequestMethod.POST)
    public String rechazarOferta(Model model, @RequestParam("arquilerId") String arquilerId) {
        String nuevoEstado = "Disponible";
        empleadoARQModel.cambiarEstadoArquiler(arquilerId, nuevoEstado);
        return "redirect:/EmpleadoARQ/listarq";
    }


}

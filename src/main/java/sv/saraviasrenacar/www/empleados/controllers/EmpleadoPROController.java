package sv.saraviasrenacar.www.empleados.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sv.saraviasrenacar.www.empleados.models.EmpleadoCLIModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoPROModel;
import sv.saraviasrenacar.www.empleados.models.EmpleadoUSUModel;
import sv.saraviasrenacar.www.entities.ClientesEntity;
import sv.saraviasrenacar.www.entities.PropietariosEntity;
import sv.saraviasrenacar.www.entities.UsuariosEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("EmpleadoPRO")

public class EmpleadoPROController {

    EmpleadoPROModel empleadoPROModel = new EmpleadoPROModel();
    EmpleadoUSUModel empleadoUSUModel = new EmpleadoUSUModel();
    @RequestMapping(value = "listpro", method = RequestMethod.GET)

    public String listarPropietarioEstado(ModelMap modelMap) {
        // Filtrar las ventas por estado (por ejemplo, 'Activa')
        String estadoDeseado = "Activo";

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaPropietarios", EmpleadoPROModel.listarPropietarioEstado(estadoDeseado));

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionPropietarios";

    }

    @RequestMapping(value = "listpro", method = RequestMethod.POST)

    public String listarPropietarios(@RequestParam("estadoPropietario") String activo, ModelMap modelMap) {

        // Pasar la lista de ventas filtradas hacia la vista
        modelMap.addAttribute("listaPropietarios", EmpleadoPROModel.listarPropietarioEstado(activo));
        modelMap.addAttribute("estadoPropietario", activo);

        // Redireccionar a la página .jsp que mostrará las ventas filtradas
        return "empleadosView/gestionPropietarios";

    }

    @RequestMapping(value = "/propietariop/{id}", method = GET)
    public String propietarioProfile(@PathVariable("id") String id, Model model) {
        PropietariosEntity propietarios = empleadoPROModel.obtenerPropietarios(id);

        if (propietarios != null) {
            UsuariosEntity usuariopropietario = propietarios.getUsuariosByUsuarioPropietario(); // Obtenemos el usuario asociado al empleado
            model.addAttribute("propietario", propietarios);
            model.addAttribute("usuario", usuariopropietario); // Pasamos el usuario a la vista
        }

        return "empleadosView/PropietarioP";
    }

    @RequestMapping (value = "/activar", method = GET)
    public String activarPropietario(Model model, @RequestParam("usuarioId") String usuarioId,
                                 @RequestParam("propietarioId") String propietarioId) {
        String estado = "Activo";

        model.addAttribute("Activar", empleadoPROModel.cambiarEstadoPropietario(propietarioId,estado));
        model.addAttribute("Activar", empleadoUSUModel.cambiarEstadoUsuario(usuarioId,estado));

        return "empleadosView/PropietarioP";

    }


    @RequestMapping (value = "/desactivar", method = GET)
    public String desactivarPropietario(Model model, @RequestParam("usuarioId") String usuarioId,
                                    @RequestParam("propietarioId") String propietarioId) {
        String nuevoEstado = "Inactivo";

        int resultadoPropietario = empleadoPROModel.cambiarEstadoPropietario(propietarioId, nuevoEstado);
        int resultadoUsuario = empleadoUSUModel.cambiarEstadoUsuario(usuarioId, nuevoEstado);

        // Verifica los resultados si es necesario
        if (resultadoPropietario== 1 && resultadoUsuario == 1) {
            model.addAttribute("Desactivar", "Estado cambiado con éxito");
            model.addAttribute("Perfil", empleadoPROModel.obtenerPropietarios(propietarioId));
        } else {
            model.addAttribute("Desactivar", "Hubo un error al cambiar el estado");
            model.addAttribute("Perfil", empleadoPROModel.obtenerPropietarios(propietarioId));
        }

        return "empleadosView/PropietarioP";
    }

}




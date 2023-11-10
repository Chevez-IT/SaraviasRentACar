package sv.saraviasrenacar.www.chat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.saraviasrenacar.www.entities.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Chat")
public class ChatController {

            @RequestMapping(value = "", method = RequestMethod.GET)
            public String chat(ModelMap model, HttpSession session) {
                session.setAttribute("emisor", "CG103");
                session.setAttribute("receptor", "DC253");
                String emisor = "DC253";
                String receptor = "CG103";
                List<MensajesEntity> mensajes = ChatModel.listarMensajes(emisor, receptor);
                model.addAttribute("mensajes", mensajes);
                return "chatView/chat";
            }



    @RequestMapping(value = "/createMensaje", method = RequestMethod.POST)
    public String createMensaje(@ModelAttribute("mensaje") MensajesEntity mensaje,
                                @RequestParam("emisor") String emisor,
                                @RequestParam("receptor") String receptor,
                                Model model, RedirectAttributes atributos) {

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
        return "redirect:/Chat";
    }
}
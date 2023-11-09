package sv.saraviasrenacar.www.clientes.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("Inicio")
@Controller

public class  WebController {
    @GetMapping("/")
    public String inicio() {
        return "webView/inicio";
    }
}

package com.crudo.demo.Controlador;

import com.crudo.demo.Entidades.Usuario;
import com.crudo.demo.Entidades.tareas;
import com.crudo.demo.Servicio.serviciotarea;
import com.crudo.demo.Servicio.serviusuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class frontcontroller {
    @Autowired
    serviciotarea st;
    @Autowired
    serviusuario su;

    public frontcontroller(serviciotarea sta, serviusuario serv) {
        su = serv;
        st = sta;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) throws Exception {
        if(principal!=null) {
            Usuario usu = su.usuaut(principal.getClaims());
            model.addAttribute("usu",usu);
            System.out.println(principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/lista")
    public String lista( Model modelo) {
        List<tareas> tar = st.getAgenda();
        modelo.addAttribute("tarea", tar);
        return "lista";
    }

    @GetMapping("/nueva")
    public String nuevat(Model modelo) {
     modelo.addAttribute("nuevatarea",new tareas());
        return "nueva";
    }
}

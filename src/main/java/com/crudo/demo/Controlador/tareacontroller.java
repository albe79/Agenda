package com.crudo.demo.Controlador;

import com.crudo.demo.Entidades.lista_tareas;
import com.crudo.demo.Entidades.tareas;
import com.crudo.demo.Servicio.serviciotarea;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@RestController
public class tareacontroller {
    serviciotarea st;
    public tareacontroller(serviciotarea sta) {
        st = sta;
    }

   /* @GetMapping("/lista")
    public List<tareas> lista(){

        return st.getAgenda();
    }*/
    @PostMapping("/guardar")
    public RedirectView creatarea(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD")  tareas ta,Model model){
        model.addAttribute(ta);
        ta.setEstado(false);
        this.st.creartarea(ta);
       return new RedirectView("/lista");
    }
    @PatchMapping("/guardar/{id}")//para finalizar una tarea
    public RedirectView actualizatarea(@PathVariable("id") Long id){
        this.st.tarfinalizada(id);
        return new RedirectView("/lista");
    }
    @DeleteMapping("/guardar/{id}")
    public RedirectView borratarea(@PathVariable("id") Long id) {
        this.st.borrar(id);
        return new RedirectView("/lista");
    }
}

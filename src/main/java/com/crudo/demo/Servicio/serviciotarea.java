package com.crudo.demo.Servicio;

import com.crudo.demo.Entidades.lista_tareas;
import com.crudo.demo.Entidades.tareas;
import com.crudo.demo.Repositorio.repotareas;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class serviciotarea {
    repotareas rta;
   /* tareas t1;
    tareas t2;
    tareas t3;
    lista_tareas agenda;*/

    public serviciotarea(repotareas ret) {
        rta = ret;
       /* tareas t1 = new tareas("pagar arriendo",false, LocalDate.now());
        tareas t2 = new tareas("pagar impuesto",false, LocalDate.now());
        tareas t3 = new tareas("pagar sueldos",false, LocalDate.now());
        agenda = new lista_tareas("agenda del mes");
        agenda.agregar(t1);
        agenda.agregar(t2);
        agenda.agregar(t3);*/
    }

    public List<tareas> getAgenda() {
        return rta.findAll();
    }
    public tareas creartarea(tareas tar){
        return rta.save(tar);
    }
    public Boolean tarfinalizada(Long id){//colocar Boolean no el primitivo boolean
        Optional<tareas> tarea = rta.findById(id);
        if(tarea.isPresent()){
            tarea.get().setEstado(true);
            rta.save(tarea.get());
            return true;
        }
        return false;
    }
    public Boolean borrar(Long id){
        rta.deleteById(id);
        return true;
    }

}

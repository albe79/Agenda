package com.crudo.demo.Entidades;

import java.util.ArrayList;
import java.util.List;

public class lista_tareas {
    private String nombre;
    private List<tareas> listado;

    public lista_tareas(String nombre) {
        this.nombre = nombre;
        this.listado = new ArrayList<>();
    }
    public void agregar(tareas tar){
        this.listado.add(tar);
    }

    public List<tareas> getListado() {
        return listado;
    }

    public void setListado(List<tareas> listado) {
        this.listado = listado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package com.crudo.demo.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "tareas")
public class tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    private String descripcion;
    @Column
    private boolean estado;
    @Column
    private LocalDate creacion;

    public tareas() {
    }

    public tareas(String descripcion, boolean estado, LocalDate creacion) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.creacion = creacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }
}

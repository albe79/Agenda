package com.crudo.demo.Entidades;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(unique = true)
    private String email;
    @Column
    private String imagen;
   /* @Column(unique = true)
    private String clave;*/

    public Usuario() {
    }

    public Usuario(String id, String email, String imagen) {
        this.id = id;
        this.email = email;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    }



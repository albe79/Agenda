package com.crudo.demo.Servicio;

import com.crudo.demo.Entidades.Usuario;
import com.crudo.demo.Repositorio.repousu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class serviusuario {
    @Autowired
    repousu ru;

    public serviusuario(repousu ru) {
        this.ru = ru;
    }
    public Usuario crearusu(Usuario nuevousu){
        return ru.save(nuevousu);
    }
    public Usuario findUserById(String id)  {
        Usuario us =  ru.findById(id);
        return us;
    }

    public Usuario usuaut(Map<String,Object> userData) throws Exception {
        String id = (String) userData.get("sub");
        Usuario usua = this.findUserById(id);
        if(usua==null) {
            String email = (String) userData.get("email");
            String imagen = (String) userData.get("picture");
            Usuario nuevo = new Usuario(id = id, email = email, imagen = imagen);
            System.out.println("aqui"+nuevo.getId());
            return crearusu(nuevo);
        }else {

            return usua;
        }

    }
/*@Service
public class serviusuario {
    @Autowired
    repousu ru;

    public serviusuario(repousu ru) {
        this.ru = ru;
    }
    public Usuario crearusu(Usuario nuevousu){
       return ru.save(nuevousu);
    }
    public Usuario findUserByEmail(String email){
        Usuario u = ru.findByEmail(email);
       return u;
    }

    public Usuario usuaut(Map<String,Object> datosusu){

            String email = (String) datosusu.get("email");
            Usuario usua = findUserByEmail(email);
           if(usua==null) {

               String imagen = (String) datosusu.get("picture");
               String auth0id = (String) datosusu.get("sub");

               Usuario nuevo = new Usuario(email = email, imagen = imagen, auth0id = auth0id);

               return crearusu(nuevo);
           }
           System.out.println(usua.getCorreo());
               return usua;

    }*/
}

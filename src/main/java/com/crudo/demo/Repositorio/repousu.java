package com.crudo.demo.Repositorio;

import com.crudo.demo.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface repousu extends JpaRepository<Usuario,Long> {
    Usuario findById(String id);
}

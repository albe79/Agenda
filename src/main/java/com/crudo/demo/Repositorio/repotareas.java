package com.crudo.demo.Repositorio;

import com.crudo.demo.Entidades.tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repotareas extends JpaRepository<tareas,Long> {
}

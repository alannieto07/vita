
package com.equipo.equipo.Repositorio;

import com.equipo.equipo.Entidades.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepositorio extends JpaRepository < Turno ,String> {
    
}


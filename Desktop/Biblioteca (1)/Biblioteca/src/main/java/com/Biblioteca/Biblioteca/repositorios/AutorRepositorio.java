
package com.Biblioteca.Biblioteca.repositorios;

import com.Biblioteca.Biblioteca.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository <Autor,String> {
    
}

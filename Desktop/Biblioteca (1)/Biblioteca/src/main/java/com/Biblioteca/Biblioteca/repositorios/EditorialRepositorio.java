
package com.Biblioteca.Biblioteca.repositorios;

import com.Biblioteca.Biblioteca.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository <Editorial,String> {
    
}

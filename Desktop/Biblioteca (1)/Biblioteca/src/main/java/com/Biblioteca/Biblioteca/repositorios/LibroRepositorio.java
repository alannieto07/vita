
package com.Biblioteca.Biblioteca.repositorios;

import com.Biblioteca.Biblioteca.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository <Libro,Long> { 
    
    
    //aca irian la querys para buscar en la base de datos algun dato que se requiera 
    
    
    
    // en esta query lo que hacemos es buscar en la base de datos, un libro por su titulo
     @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo); 
    
    //en esta otra lo que hacemos es buscar un libro por el nombre del autor, o sea en la columna donde se encuentra el autor
     @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro> buscarPorAutor(@Param ("nombre") String nombre); 
    
    
}

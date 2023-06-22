
package com.Biblioteca.Biblioteca.servicios;

import com.Biblioteca.Biblioteca.entidades.Autor;
import com.Biblioteca.Biblioteca.repositorios.AutorRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Biblioteca.Biblioteca.excepsiones.MiException;

@Service
public class AutorServicio {
    
    @Autowired
    private AutorRepositorio autorrepositorio; 
    
    //solo instanciamos el nombre porque el id se genera automaticamente
    
    
    @Transactional // esta etiqueta es para los metodos que van a hacer modificaciones constantemente a la base de datos 
    public void Crearautor(String nombre) throws MiException{ 
        
        validar(nombre);
        
        Autor autor = new Autor();
        
        autor.setNombre(nombre);
        
        autorrepositorio.save(autor);
    } 
    
    //lista autores
    
    public List<Autor> Listaautores(){ 
        
        List<Autor> autores = new ArrayList();
        
        autores = autorrepositorio.findAll();
        
        return autores;
        
        
        
    } 
    
    @Transactional
    public void ModificarAutor(String id, String nombre ) throws MiException{ 
        
        validar(nombre);
        
        Optional<Autor> respuestaAutor = autorrepositorio.findById(id);
        
        if(respuestaAutor.isPresent()){
            Autor autor = respuestaAutor.get();
            
            autor.setNombre(nombre); 
            autorrepositorio.save(autor);
            
        }
        
    } 
    
    
    public Autor getOne(String id){
        return autorrepositorio.getOne(id);
        
    }
    
    
    private void validar(String nombre) throws MiException {

      
       if(nombre.isEmpty() || nombre == null){
           
           throw new MiException (" el nombre no puede ser nulo o estar vacio");
           
       }
             
    }
    
    
 
}


package com.Biblioteca.Biblioteca.servicios;

import com.Biblioteca.Biblioteca.entidades.Editorial;
import com.Biblioteca.Biblioteca.entidades.Libro;
import com.Biblioteca.Biblioteca.excepsiones.MiException;
import com.Biblioteca.Biblioteca.repositorios.EditorialRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio { 
    
 @Autowired 
 private EditorialRepositorio editorialrepositorio; 
 
 
 //solo instanciamos el nombre porque el id se genera automaticamente
 
 @Transactional // esta etiqueta es para los metodos que van a hacer modificaciones constantemente a la base de datos 
 public void Creareditorial(String nombre) throws MiException{ 
     
     validar(nombre);

    Editorial editorial = new Editorial(); 
    
    editorial.setNombre(nombre);
    
    editorialrepositorio.save(editorial);
    
 }
 
 
 //lista editoriales  
 
 public List<Editorial> Listaeditoriales(){
     
     List<Editorial> editoriales = new ArrayList(); 
     
     editoriales = editorialrepositorio.findAll();
     
     return editoriales;
     
  } 
 
 @Transactional
 public void ModificarEditorial(String id, String nombre) throws MiException{ 
     
     validar(nombre);
     
     Optional<Editorial> respuestaEditorial = editorialrepositorio.findById(id);
     
     if(respuestaEditorial.isPresent()){
         
         Editorial editorial = respuestaEditorial.get(); 
         
         editorial.setNombre(nombre);
         
         editorialrepositorio.save(editorial);
         
     }
     
 }  
 
 public Editorial getone(String id){
     
     return editorialrepositorio.getOne(id);
 }
 
 
 private void validar(String nombre) throws MiException{ 
     
     if (nombre.isEmpty() || nombre == null) {
         
         throw new MiException("el nombre no puede ser nulo o estar vacio");
         
         
     }
     
 }
 
    
}

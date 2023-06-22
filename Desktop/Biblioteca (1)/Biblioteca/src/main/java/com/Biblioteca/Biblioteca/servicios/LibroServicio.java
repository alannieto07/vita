
package com.Biblioteca.Biblioteca.servicios;

import com.Biblioteca.Biblioteca.entidades.Autor;
import com.Biblioteca.Biblioteca.entidades.Editorial;
import com.Biblioteca.Biblioteca.entidades.Libro;
import com.Biblioteca.Biblioteca.excepsiones.MiException;
import com.Biblioteca.Biblioteca.repositorios.AutorRepositorio;
import com.Biblioteca.Biblioteca.repositorios.EditorialRepositorio;
import com.Biblioteca.Biblioteca.repositorios.LibroRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio { 
    
    //en esta clase lo que vamos a hacer es iniciar o crear cada objeto con sus atributos 
    
    
    //vamos a traer las clases del repositorio
    @Autowired
    private LibroRepositorio librorepositorio; 
      
    @Autowired
    private AutorRepositorio autorrepositorio;
    
    @Autowired
    private EditorialRepositorio editorialrepositorio;
    
    
    @Transactional // esta etiqueta es para los metodos que van a hacer modificaciones constantemente a la base de datos 
    public void crearLibro (Long isbn,String titulo,Integer ejemplares, String idautor, String ideditorial) throws MiException{
          
        validar(isbn,titulo,ejemplares,idautor,ideditorial);
        
        
        // buscamos el autor y la editorial por el id en el repositorio para instanciarlo y poder asignarle cada uno al libro
        Autor autor = autorrepositorio.findById(idautor).get();
        Editorial editorial = editorialrepositorio.findById(ideditorial).get();
        
        //instanciamos el libro que queremos crear como entidad, con el metodo set que de la clase entidad del libro
        Libro libro = new Libro();  
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setFechaingreso(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);  
        
        librorepositorio.save(libro);
             
        
    }
    
    //lista de libros que podemos traer desde el repositorio gracias al metodo findall 
    
    public List<Libro> Listarlibros(){
         
        List<Libro> libros = new ArrayList();  
        
        libros = librorepositorio.findAll();
        
        
        
        return libros;
        
     } 
      
    
    // con este metodo modificamos el libro con los atributor que querramos
    
    @Transactional
    public void Modificarlibro(Long isbn, String titulo, String idautor,String ideditorial,Integer ejemplares) throws MiException{
      
        
        validar(isbn,titulo,ejemplares,idautor,ideditorial);
        
     //optional nos permite a diferencia de buscar por id del repositorio asegurarnos de que lo que busca no se encuentre vacio 
     Optional<Libro> respuesta = librorepositorio.findById(isbn); 
     Optional<Autor> respuestaAutor = autorrepositorio.findById(idautor);
     Optional<Editorial> respuestaEditorial = editorialrepositorio.findById(ideditorial);
     
     Editorial editorial = new Editorial();
     Autor autor = new Autor();
     
     
     if(respuestaAutor.isPresent()){
         autor = respuestaAutor.get();
     } 
     
     if(respuestaEditorial.isPresent()){
         editorial = respuestaEditorial.get();
     }
     
     
     
     if(respuesta.isPresent()){
         
         Libro libro = respuesta.get();
         
         libro.setTitulo(titulo); 
         libro.setAutor(autor);
         libro.setEditorial(editorial);
         libro.setEjemplares(ejemplares); 
         librorepositorio.save(libro);
         
       }
     
 } 
    
    
    public Libro getone(Long isbn){ 
      return  librorepositorio.getOne(isbn);
    }
    
    
    
private void validar(Long isbn,String titulo,Integer ejemplares, String idautor, String ideditorial) throws MiException {
   
    if(isbn == null){
        throw new MiException("el isbn no puede ser nulo");
        
    }  
    if(titulo.isEmpty() || titulo == null){
       throw new MiException ("el titulo no puede ser nulo o estar vacio");
    } 
   if(ejemplares == null){
       throw new MiException ("los ejemplares no pueden ser nulos");
       
   } 
   if(idautor.isEmpty() || idautor == null){
       throw new MiException("el autor no puede ser nulo o estar vacio");
   } 
   if(ideditorial.isEmpty() || ideditorial == null){
       throw new MiException ("la editorial no puede ser nula o estar vacia");
    }
    
    
}    
    
    
    
    
    
    
}

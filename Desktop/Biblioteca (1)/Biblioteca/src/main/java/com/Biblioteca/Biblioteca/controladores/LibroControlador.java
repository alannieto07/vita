
package com.Biblioteca.Biblioteca.controladores;


import com.Biblioteca.Biblioteca.entidades.Autor;
import com.Biblioteca.Biblioteca.entidades.Editorial;
import com.Biblioteca.Biblioteca.entidades.Libro;
import com.Biblioteca.Biblioteca.excepsiones.MiException;
import com.Biblioteca.Biblioteca.servicios.AutorServicio;
import com.Biblioteca.Biblioteca.servicios.EditorialServicio;
import com.Biblioteca.Biblioteca.servicios.LibroServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro")
public class LibroControlador {  
    
    @Autowired
    LibroServicio libroservicio; 
    @Autowired
    AutorServicio autorservicio; 
    @Autowired
    EditorialServicio editorialservicio;
    
    
    
    @GetMapping("/registrar")
    public String registrar(ModelMap modelo){  
        
        List<Autor> autores = autorservicio.Listaautores(); 
                                                                              // con esto traemos la lista de los autores e editoriales para mostrar en el formulario de libro.
        List<Editorial> editoriales = editorialservicio.Listaeditoriales(); 
        
        
        modelo.addAttribute("autores",autores);
        modelo.addAttribute("editoriales", editoriales);
        
        
        
        return "libro_form.html";
    } 
    
    @PostMapping("/registro")
    public String registro(@RequestParam(required=false) Long isbn,@RequestParam  String titulo, @RequestParam(required=false) Integer ejemplares, @RequestParam  String idautor, @RequestParam  String ideditorial, ModelMap modelo){ 
        
        try {
            libroservicio.crearLibro(isbn, titulo, ejemplares,idautor, ideditorial); 
            
            modelo.put("exito", "el libro fue cargado correctamente");
            
            
        } catch (MiException ex) { 
              List<Autor> autores = autorservicio.Listaautores();
            // con esto traemos la lista de los autores e editoriales para mostrar en el formulario de libro.
            List<Editorial> editoriales = editorialservicio.Listaeditoriales();

            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            
            modelo.put("error", ex.getMessage());
            
            return "libro_form.html";
        } 
        
        return "Index.html";
        
    } 
    
    
    @GetMapping("/lista")
    public String lista (ModelMap modelo){ 
        
        List<Libro> libros = libroservicio.Listarlibros(); 
        
        modelo.addAttribute("libros", libros);
        
        
        return "libro_list.html";
    } 
    
    
    @GetMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn,ModelMap modelo){  
        
            List<Autor> autores = autorservicio.Listaautores();
            // con esto traemos la lista de los autores e editoriales para mostrar en el formulario de libro.
            List<Editorial> editoriales = editorialservicio.Listaeditoriales();

            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
        
        modelo.put("libro", libroservicio.getone(isbn)); 
        
        return"libro_modificar.html";
        
    } 
    
    @PostMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn,String titulo,  Integer ejemplares, String idautor, String ideditorial, ModelMap modelo ){
        
        try { 
            List<Autor> autores = autorservicio.Listaautores();
            // con esto traemos la lista de los autores e editoriales para mostrar en el formulario de libro.
            List<Editorial> editoriales = editorialservicio.Listaeditoriales();

            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            
            libroservicio.Modificarlibro(isbn, titulo, idautor, ideditorial, ejemplares); 
            
            return"redirect:../lista";
            
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage()); 
            
            List<Autor> autores = autorservicio.Listaautores();
            // con esto traemos la lista de los autores e editoriales para mostrar en el formulario de libro.
            List<Editorial> editoriales = editorialservicio.Listaeditoriales();

            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            
            return"libro_modificar.html";
        }
        
    }
    
}

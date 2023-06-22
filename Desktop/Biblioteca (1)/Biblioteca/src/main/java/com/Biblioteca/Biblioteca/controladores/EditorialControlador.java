
package com.Biblioteca.Biblioteca.controladores;

import com.Biblioteca.Biblioteca.entidades.Editorial;
import com.Biblioteca.Biblioteca.excepsiones.MiException;
import com.Biblioteca.Biblioteca.servicios.EditorialServicio;
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
@RequestMapping("/editorial")
public class EditorialControlador {   
    
    @Autowired
    EditorialServicio editorialservicio;
    
    @GetMapping("/registrar")
    public String registrar(){
        return "editorial_form.html";
    } 
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre , ModelMap modelo){ 
        
        System.out.println("nombre: " + nombre);  
        
        try {
            editorialservicio.Creareditorial(nombre); 
            
            modelo.put("exito", "la editorial se guardo con exito");
            
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
              
            
            return "editorial_form.html";
        }
        
        return "Index.html";
        
    }
    
    @GetMapping("/lista")
    public String lista(ModelMap modelo){
        
        List<Editorial> editoriales = editorialservicio.Listaeditoriales();
        
        modelo.addAttribute("editoriales" ,editoriales);
        
        return "editorial_list.html";
        
    } 
    
    @GetMapping("/modificar/{id}")
    public String modificar (@PathVariable String id, ModelMap modelo){ 
        
        modelo.put("editorial", editorialservicio.getone(id));
        
        return "editorial_modificar.html";
    } 
    
    
    @PostMapping("/modificar/{id}")
    public String modificar (@PathVariable String id, String nombre, ModelMap modelo){
        
        try {
            editorialservicio.ModificarEditorial(id, nombre); 
            
            
            return"redirect:../lista"; 
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            
            return"editorial_modificar.html";
        }
        
        
    }

    
    
    
}

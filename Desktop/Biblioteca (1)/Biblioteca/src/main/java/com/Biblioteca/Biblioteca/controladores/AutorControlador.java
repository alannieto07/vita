
package com.Biblioteca.Biblioteca.controladores;

import com.Biblioteca.Biblioteca.entidades.Autor;
import com.Biblioteca.Biblioteca.excepsiones.MiException;
import com.Biblioteca.Biblioteca.servicios.AutorServicio;
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
@RequestMapping("/autor")
public class AutorControlador {  
    
    
    @Autowired
   private AutorServicio autorservicio;
   
    @GetMapping("/registrar")  //con esto vamos a ingresar desde nuestro localhost al formulario para ingresar autores 
    public String registrar(){
        return "autor_form.html";
    } 
    
    @PostMapping("/registro")   // con esto vamos a recibir el nombre del autor y lo vamos a guardar en la base de datos 
    public String registro(@RequestParam String nombre, ModelMap modelo){ 
        
        System.out.println("nombre :" + nombre);   
        
        try {
            autorservicio.Crearautor(nombre); 
            
            
            modelo.put("exito", "el autor se guardo con exito");
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            
            return "autor_form.html";
        }
        
        return "Index.html";
        
    }  
    
    
    @GetMapping("/lista")
    public String Lista (ModelMap modelo){ 
        
       List<Autor> autores = autorservicio.Listaautores(); 
       
       modelo.addAttribute("autores", autores);
       
       return "autor_list.html"; 
        
    } 
    
    
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo){ 
         
        modelo.put("autor", autorservicio.getOne(id));
        
        return "autor_modificar.html";
        
    }
    
    @PostMapping("/modificar/{id}")
    public String modificar (@PathVariable String id, String nombre, ModelMap modelo){
        
        try {
            autorservicio.ModificarAutor(id, nombre); 
            
            
            return"redirect:../lista";
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());
            
            return"autor_modificar.html";
        }
        
        
    }
    
    
    
}

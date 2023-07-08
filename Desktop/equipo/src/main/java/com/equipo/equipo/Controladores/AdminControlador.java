
package com.equipo.equipo.Controladores;

import com.equipo.equipo.Entidades.Usuario;
import com.equipo.equipo.Servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {  
    
    @Autowired
    UsuarioServicio usuarioservicio;
    
    
  @GetMapping("/dashboard")
  public String panel(){
    return "panel.html";
  }   
  
  
    
    @GetMapping("/usuarios") 
    public String usuarioLista(ModelMap modelo){ 
        
       List <Usuario> usuarios =  usuarioservicio.ListaUsuarios(); 
       
       modelo.addAttribute("usuarios", usuarios); 
       
        return"usuario_list.html";
    } 
    
    @GetMapping("/modificarRol/{id}")
    public String ModificarRol(@PathVariable String id){ 
        
        usuarioservicio.ModificarRol(id);
        
         return "redirect:/admin/usuarios";
        
    }
    
}


package com.Biblioteca.Biblioteca.controladores;

import com.Biblioteca.Biblioteca.entidades.Usuario;
import com.Biblioteca.Biblioteca.excepsiones.MiException;
import com.Biblioteca.Biblioteca.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class PortalControlador {  
    
    
    @Autowired
    UsuarioServicio usuarioservicio;
    
    
    @GetMapping("/")
    public String index(){ 
        
      return "index.html";
    } 
    
     @GetMapping("/registrar")
     public String registrar (){
         return "usuario_registrarse.html";
     }  
     
     
     @PostMapping("/registro")
     public String registro(@RequestParam String nombre, @RequestParam String email,@RequestParam String password , String password2, ModelMap modelo){
          
        try {
            usuarioservicio.registrar(nombre, email, password, password2); 
            
            modelo.put("exito","el usuario se registro con exito!"); 
            
            return "index.html";
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage()); 
            
            modelo.put("nombre", nombre);
            modelo.put("email",email);
            
            return"usuario_registrarse.html";
            
        }
         
         
     }
     
     @GetMapping("/login")
     public String ingresar(@RequestParam(required=false) String error, ModelMap modelo){ 
         
         if(error != null){
             modelo.put("error", "usuario o contraseña invalidas"); 
              
             return"login.html";
         }
         
         return"login.html";
        
     } 
     
    
     
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {

        Usuario logueado = (Usuario) session.getAttribute("usuariosession");

        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }

        return "inicio.html";
    }
    
   
    
    
    
    
    
    
    
}

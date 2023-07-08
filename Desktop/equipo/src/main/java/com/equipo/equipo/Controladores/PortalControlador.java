
package com.equipo.equipo.Controladores;

import com.equipo.equipo.Entidades.Turno;
import com.equipo.equipo.Entidades.Usuario;
import com.equipo.equipo.Excepciones.MiException;
import com.equipo.equipo.Repositorio.UsuarioRepositorio;
import com.equipo.equipo.Servicios.TurnoServicio;
import com.equipo.equipo.Servicios.UsuarioServicio;
import java.util.List;
import java.util.Optional;
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

@Controller
@RequestMapping("/")
public class PortalControlador {  
    
    @Autowired
    UsuarioServicio usuarioservicio;
    
    @Autowired
    UsuarioRepositorio usuariorepositorio;
    
    @Autowired
    TurnoServicio turnoservicio;
    
    
    @GetMapping("/")
    public String index(){
        
        return "index.html";
    } 
    
    @GetMapping("/registrar")
    public String registrar(ModelMap modelo){ 
          
        List <Turno> turnos = turnoservicio.ListaTurno();
         modelo.addAttribute("turnos", turnos); 
        
        return"usuario_registrar.html";
     } 
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido,@RequestParam(required = false) Integer dni,@RequestParam(required= false) Integer edad, @RequestParam(required= false) Integer numero,@RequestParam String email, @RequestParam String password,@RequestParam String password2,ModelMap modelo,@RequestParam String idturno){
        
        try {
            usuarioservicio.CrearUsuario(nombre, apellido, numero, dni, edad, email, password, password2, idturno);
            
           modelo.put("exito", "usuario registrado con exito!");
              
           
        
        } catch (MiException ex) {
            
            
            modelo.put("error", ex.getMessage());
            
              List <Turno> turnos = turnoservicio.ListaTurno();
              modelo.addAttribute("turnos", turnos); 
            
             return"usuario_registrar.html";
        }
        
        return "login.html";
    } 
    
    
    @GetMapping("/contacto")
    public String contacto(){
        return "contacto.html"; 
    } 
    
    @GetMapping("/leermas")
    public String leermas(){
        return "leermas.html";
     }
    
   
    
    @RequestMapping("/misturnos")
    public String misturno(ModelMap modelo){ 
        
        
       
        
        return "misturnos.html";
        
     }
    
     @GetMapping("/login")
    public String login(@RequestParam(required = false)String error, ModelMap modelo){ 
        
       if(error != null){
           modelo.put("error", "usuario o contraseña incorrectos");
       }
        return "login.html";
     }  
    
   
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio( HttpSession session,ModelMap modelo){  
        
           
        
         Usuario logueado = (Usuario) session.getAttribute("usuariosession");
     
        
         if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        } 
         
         return "inicio.html";
    }   
    
   
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//    @GetMapping("/perfil/{id}") 
//    public String SeleccionarTurno(@PathVariable String id, ModelMap modelo,HttpSession session){ 
//         
//          Usuario usuario = (Usuario) session.getAttribute(id);
//         modelo.put("usuario", usuario);
//        
//         List <Turno> turnos = turnoservicio.ListaTurno();
//         modelo.addAttribute("turnos", turnos); 
//          
//          
//          return "seleccion_turnos.html";
//         
//    
//    } 
    
    
    
//       @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//      @PostMapping("/perfil/{id}")
//      public String seleccionarTurno( @PathVariable String id ,@RequestParam String idturno, ModelMap modelo,@RequestParam String nombre, @RequestParam String apellido,@RequestParam(required = false) Integer dni,@RequestParam(required= false) Integer edad, @RequestParam(required= false) Integer numero,@RequestParam String email, @RequestParam String password,@RequestParam String password2 ){
//          
//            try {
//               
//                
//                List <Turno> turnos = turnoservicio.ListaTurno();
//        
//              modelo.addAttribute("turnos", turnos);
//               
//              
//              usuarioservicio.SeleccionarTurno(idturno, id, nombre, apellido, numero, dni, edad, email, password, password2);
//            
//            modelo.put("exito","turno seleccionado con exito"); 
//             
//            
//        
//        } catch (MiException ex) {
//             
//              List <Turno> turnos = turnoservicio.ListaTurno();
//        
//              modelo.addAttribute("turnos", turnos);
//            
//            modelo.put("error", ex.getMessage()); 
//            
//            return "seleccion_turnos.html";
//        }
//        
//        return "inicio.html";
//          
//          
//          
//          
//      } 
              
              
              
        
        
      
   
    
    
    
    
  
    
    
    
}

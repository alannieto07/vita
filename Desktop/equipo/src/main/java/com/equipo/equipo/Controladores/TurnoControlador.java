
package com.equipo.equipo.Controladores;

import com.equipo.equipo.Entidades.Turno;
import com.equipo.equipo.Entidades.Usuario;
import com.equipo.equipo.Excepciones.MiException;
import com.equipo.equipo.Servicios.TurnoServicio;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/turno")
public class TurnoControlador { 
    
    @Autowired
    TurnoServicio turnoservicio;
    
    
    @GetMapping("/lista")
    public String listaTurnos(ModelMap modelo){ 
        
        Usuario usuario = new Usuario();
        
        if(usuario.getTurno() != null){
            
        
        
        List <Turno> turnos = turnoservicio.ListaTurno();
        
        modelo.addAttribute("turnos", turnos); 
        
        return"turnos_list.html";
        }
        
        return"turnos_list.html";
        
    }
    
    @GetMapping("/registrar")
    public String registrar(){
        return "turnos_form.html";
    } 
    
    
    @PostMapping("/registro")
    public String registroTurno(@RequestParam(required= false)@DateTimeFormat(pattern = "yyyy-MM-dd")  Date fecha, @RequestParam String especialidad, @RequestParam String profesional, @RequestParam(required=false) Integer hora,ModelMap modelo){ 
        
        
        try {
            turnoservicio.Agregarturno(fecha, especialidad, profesional, hora); 
            
            modelo.put("exito", "turno registrado con exito");
            
              return "panel.html";
              
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage()); 
            
               return "turnos_form.html";
        }
       
    } 
      
    
    
   

      
    
    
    
}
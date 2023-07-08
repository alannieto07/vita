
package com.equipo.equipo.Servicios;

import com.equipo.equipo.Entidades.Turno;
import com.equipo.equipo.Excepciones.MiException;
import com.equipo.equipo.Repositorio.TurnoRepositorio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServicio { 
    
    @Autowired
    TurnoRepositorio turnorepositorio;  
    
    
    @Transactional
    public void Agregarturno ( Date fecha,String especialidad, String profesional,Integer hora) throws MiException{ 
        
        validar(fecha,especialidad,profesional,hora);
        
        Turno turno = new Turno();  
        
        
        turno.setFecha(fecha); 
        turno.setEspecialidad(especialidad);
        turno.setProfesional(profesional);
        turno.setHora(hora); 
        
        turnorepositorio.save(turno);
        
    } 
    
    
    private void validar(Date fecha, String especialidad, String profesional,Integer hora) throws MiException{ 
         
        
        if(fecha == null){ 
            
            throw new MiException("la fecha no puede ser nula ");
         
        }
       
        if(especialidad.isEmpty()|| especialidad == null){
            
            throw new MiException("la especialidad no puede ser nulo o estar vacío");
         
        }
        if(profesional.isEmpty() || profesional == null){ 
            
            throw new MiException("la profesional no puede ser nula o esta vacía");
            
        }
        if(hora == null){
            throw new MiException("la hora no puede ser nula");
        }
        
    }  
    
    @Transactional
    public void ModificarTurno(Date fecha,String id, String especialidad, String profesional,Integer hora){
        
        Optional <Turno> respuestaturno = turnorepositorio.findById(id);
        
        if(respuestaturno.isPresent()){ 
            
            Turno turno = respuestaturno.get();
            
           
            turno.setEspecialidad(especialidad);
            turno.setProfesional(profesional);
            turno.setFecha(fecha);
            turno.setHora(hora);
            
            
        }
        
    }
    
    @Transactional
    public List <Turno> ListaTurno(){
        
       List <Turno> turnos = new ArrayList();  
        
        turnos = turnorepositorio.findAll();
        
        return turnos;
    }
    
}
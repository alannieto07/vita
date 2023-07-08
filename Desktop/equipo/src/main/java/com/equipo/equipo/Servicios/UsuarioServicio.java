
package com.equipo.equipo.Servicios;

import com.equipo.equipo.Entidades.Turno;
import com.equipo.equipo.Entidades.Usuario;
import com.equipo.equipo.Enumeraciones.Rol;
import com.equipo.equipo.Excepciones.MiException;
import com.equipo.equipo.Repositorio.TurnoRepositorio;
import com.equipo.equipo.Repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;





@Service
public class UsuarioServicio implements UserDetailsService  { 
    
    @Autowired
    UsuarioRepositorio usuariorepositorio;  
    
    @Autowired
    TurnoRepositorio turnorepositorio;
    
    @Transactional
    public void CrearUsuario(String nombre, String apellido,Integer numero,Integer dni,Integer edad,String email,String password,String password2, String idturno) throws MiException{
         
        validar(nombre, apellido,email,dni,numero,edad,password,password2,idturno);
        
        Optional<Turno> respuestaturno = turnorepositorio.findById(idturno); 
        
        Turno turno = new Turno();
       if(respuestaturno.isPresent()){
           turno = respuestaturno.get();
       }
       
        Usuario usuario = new Usuario();
        
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email); 
        usuario.setDni(dni);
        usuario.setTurno(turno);
        usuario.setNumero(numero);
        usuario.setEdad(edad);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
      
        
        usuariorepositorio.save(usuario);
        
       
    } 
    
    
    
 
    
    
    @Transactional
    public void ModificarRol(String id) {  
        
        Optional <Usuario> respuestausuario = usuariorepositorio.findById(id);
        
        if(respuestausuario.isPresent()){  
            
            Usuario usuario = respuestausuario.get();
            
            if(usuario.getRol().equals(Rol.USER)){
                
                usuario.setRol(Rol.ADMIN);
                
            }else if (usuario.getRol().equals(Rol.ADMIN)){
                
                usuario.setRol(Rol.USER); 
                
            }
            
            
        }
        
        
        
    }
    
   
    private void validar(String nombre,String email, String apellido,Integer dni,Integer numero,Integer edad,String password,String password2,String idturno) throws MiException{ 
        
        if(idturno.isEmpty() || idturno == null){
            
            throw new MiException("el turno no puede ser nulo o estar vacio");
            
        }
        
        if(nombre.isEmpty()|| nombre == null){
            
            throw new MiException ("el nombre no puede ser nulo o estar vacío");
            
        } 
        if(apellido.isEmpty()|| apellido == null){
            
            throw new MiException("el apellido no puede ser nulo o estar vacio");
            
        } 
        
        if(email.isEmpty() || email== null){
             
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        
        if(dni < 8 || dni == null){
            
            throw new MiException("dni no válido o vacío");
            
        }
         if(numero < 10 || numero == null){
            
            throw new MiException("numero no valido o nulo");
            
        }
        
        if(edad == 0 || edad == null){
            
            throw new MiException("edad no valida o nula");
            
        } 
        
        if(password.isEmpty() || password.length() < 8){ 
            
            throw new MiException("la contraseña no puede tener menos de 8 caracteres o ser nula");
            
        } 
        
        if(!password.equals(password2)){
            
            throw new MiException("las contraseñas deben ser iguales");
            
        }
        
        
    }
    
   
    
    @Transactional
    public List <Usuario> MisTurnos(String email) { 
        
       
        
     List <Usuario> usuarios = new ArrayList();
     
     usuarios = usuariorepositorio.findAll(email);
     
     return usuarios;
        
    }
   
   
    
    public Usuario getone(String id){ 
      return  usuariorepositorio.getOne(id);
    }
    

    
    @Transactional
    public List <Usuario> ListaUsuarios(){  
        
        List <Usuario> usuarios = new ArrayList(); 
        
        usuarios = usuariorepositorio.findAll();
       
        return usuarios;
     
    }  
    
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuariorepositorio.buscarPorEmail(email); 

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }

    }
    
}

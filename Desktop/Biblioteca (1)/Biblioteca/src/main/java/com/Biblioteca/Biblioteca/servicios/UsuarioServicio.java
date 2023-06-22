
package com.Biblioteca.Biblioteca.servicios;

import com.Biblioteca.Biblioteca.entidades.Usuario;
import com.Biblioteca.Biblioteca.enumeraciones.Rol;
import com.Biblioteca.Biblioteca.excepsiones.MiException;
import com.Biblioteca.Biblioteca.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UsuarioServicio implements UserDetailsService { 
    
    @Autowired
    UsuarioRepositorio usuariorepositorio; 
    
    
    @Transactional
    public void registrar( String nombre, String email,String password,String password2) throws MiException{
          
          validar(nombre,email,password,password2);
        
        Usuario usuario = new Usuario();
        
        
        usuario.setNombre(nombre);
        usuario.setEmail(email);
         usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        
        usuariorepositorio.save(usuario);
        
        
    } 
    
    private void validar(String nombre, String email,String password,String password2) throws MiException{
        
        if(nombre.isEmpty() || nombre== null){
            
            throw new MiException("el nombre no puede ser nulo o estar vacio");
            
        }
        if(email.isEmpty() || email== null){
            
            throw new MiException("el email no puede ser nulo o estar vacio");
            
        }
        if(password.isEmpty()|| password == null || password.length() <= 5){
           
            throw new MiException("la contraseña no puede estar vacia, y debe tener mas de 5 digitos"); 
             
        }
        
        if(!password.equals(password2)){ 
            
            throw new MiException("las contraseñas deben ser iguales");
            
        } 
        
   
            
        } 
    
   
    
    
      public Usuario getOne( String id){
        return usuariorepositorio.getOne(id);
    } 
   
   public List <Usuario> listaUsuarios(){
      
       List<Usuario> usuarios = new ArrayList();
       
       usuarios = usuariorepositorio.findAll();
       
       return usuarios;
   }  
   
   @Transactional
    public void cambiarRol(String id) {

        Optional<Usuario> respuesta = usuariorepositorio.findById(id);

        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();

            if (usuario.getRol().equals(Rol.USER)) {

                usuario.setRol(Rol.ADMIN);

            } else if (usuario.getRol().equals(Rol.ADMIN)) {
                
                usuario.setRol(Rol.USER);
            }

        }

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

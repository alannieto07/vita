
package com.equipo.equipo.Entidades;


import com.equipo.equipo.Enumeraciones.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.OneToOne;


import org.hibernate.annotations.GenericGenerator;




@Entity
public class Usuario { 
    
 @Id
 @GeneratedValue(generator = "uuid")
 @GenericGenerator(name = "uuid", strategy = "uuid2")
 private String id; 

 private String nombre;
 
 private String apellido; 
 
 private Integer numero;
 
 private String email;
 
 private Integer dni;
 
 private Integer edad;
 
 private String password;
 

 @OneToOne
 private Turno turno;
 
 
  @Enumerated(EnumType.STRING) 
  private Rol Rol;   

    public Usuario() {
    }
     
  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Turno getTurno() {
        return turno;
    } 

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    

   

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
   

}
     
    
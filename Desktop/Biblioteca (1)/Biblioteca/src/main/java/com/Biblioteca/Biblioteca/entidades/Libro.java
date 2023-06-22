
package com.Biblioteca.Biblioteca.entidades;

import java.util.Date;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Libro { 
    
    
    // este seria el id del libro 
    @Id
    private Long isbn;  
    
    //titulo del libro
    private String titulo; 
    
    //numero de ejemplares de libro, o sea cuantos hay para vender
    private Integer ejemplares;
    
    //fecha de ingreso del libro, cuando se hace el stock
    @Temporal(TemporalType.DATE)
    private Date alta; 
    
    
    //el autor del libro, manytoone porque pueden ser varios libros para un mismo autor
    @ManyToOne
    private Autor autor; 
    
    // la editorial del libro, lo mismo, pueden ser varios libros con la misma editorial
    @ManyToOne
    private Editorial editorial; 

    public Libro() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Date getFechaingreso() {
        return alta;
    }

    public void setFechaingreso(Date alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void setAutor(String idautor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEditorial(String ideditorial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
    
    
    
    
    
    
    
}

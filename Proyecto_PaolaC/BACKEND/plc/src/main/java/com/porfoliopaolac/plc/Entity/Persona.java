/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliopaolac.plc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter    @Setter
@Entity

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) 
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50,message= "No ha ingresado el nombre" )
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50,message="No ha ingresado el apellido" )
    private String apellido;
    
  
    @Size(min = 1, max = 50,message="No ha ingresado la imagen" )
    private String img;
    private String banner;
    private String profesion;
    private String acercaDeMi;
    
    //constructor//

    public Persona(String nombre, String apellido, String img, String banner, String profesion, String acercaDeMi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.banner = banner;
        this.profesion = profesion;
        this.acercaDeMi = acercaDeMi;
    }

    public Persona() {
    }
    
    
 
    
}

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

@Getter @Setter
@Entity

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) 
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50,message= "No cumple con la longitud" )
    private String Nombre;
    
    @NotNull
    @Size(min = 1, max = 50,message="No cumple con la longitud" )
    private String Apellido;
    
  
    @Size(min = 1, max = 50,message="No cumple con la longitud" )
    private String img;

    
    
}

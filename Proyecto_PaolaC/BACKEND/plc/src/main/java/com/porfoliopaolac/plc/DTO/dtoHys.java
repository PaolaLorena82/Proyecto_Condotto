/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliopaolac.plc.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Pao
 */
public class dtoHys {
    
    @NotBlank
    private String nombreHys;
   @NotBlank
    private String imgHys;
   @NotBlank
    private Number capacidadesHys;
   
   
   //constructor//

    public dtoHys() {
    }

    public dtoHys(String nombreHys, String imgHys, Number capacidadesHys) {
        this.nombreHys = nombreHys;
        this.imgHys = imgHys;
        this.capacidadesHys = capacidadesHys;
    }

    
   
   //getters and setters//

    public String getNombreHys() {
        return nombreHys;
    }

    public void setNombreHys(String nombreHys) {
        this.nombreHys = nombreHys;
    }

    public String getImgHys() {
        return imgHys;
    }

    public void setImgHys(String imgHys) {
        this.imgHys = imgHys;
    }

    public Number getCapacidadesHys() {
        return capacidadesHys;
    }

    public void setCapacidadesHys(Number capacidadesHys) {
        this.capacidadesHys = capacidadesHys;
    }

    
    
    
}

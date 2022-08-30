
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
public class dtoProyecto {
    @NotBlank
    private String tituloP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String img;
    
    //CONSTRUCTORES//

    public dtoProyecto() {
    }

    public dtoProyecto(String tituloP, String descripcionP, String img) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.img = img;
    }
//GETTERS AND SETTER//

    public String getTituloP() {
        return tituloP;
    }

    public void setTituloP(String tituloP) {
        this.tituloP = tituloP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
   
    
}

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
    private String imgP;
    
    //CONSTRUCTORES//

    public dtoProyecto() {
    }

    public dtoProyecto(String tituloP, String descripcionP, String imgP) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
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

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
   
    
}
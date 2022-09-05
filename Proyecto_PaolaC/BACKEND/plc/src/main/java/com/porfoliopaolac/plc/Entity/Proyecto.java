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


@Entity
public class Proyecto {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloP;
    private String descripcionP;
    private String imgP;
    
    
    //constructores//

    public Proyecto() {
    }

    public Proyecto(String tituloP, String descripcionP, String imgP) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }

    //getters and setters//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

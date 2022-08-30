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


public class HyS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHys;
    private String imgHys;
    private Number capacidadesHys;
    
    //constructor//

    public HyS() {
    }

    public HyS(String nombreHys, String imgHys, Number capacidadesHys) {
        this.nombreHys = nombreHys;
        this.imgHys = imgHys;
        this.capacidadesHys = capacidadesHys;
    }

    
    

    //getter and setter//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

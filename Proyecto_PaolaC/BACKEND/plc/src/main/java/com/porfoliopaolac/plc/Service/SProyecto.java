/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliopaolac.plc.Service;

import com.porfoliopaolac.plc.Entity.Proyecto;
import com.porfoliopaolac.plc.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired
    RProyecto rProyecto;
    
     public  List<Proyecto> list(){
        return  rProyecto.findAll();
    }

    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }

    public Optional<Proyecto> getByTituloP(String tituloP){
        return rProyecto.findByTituloP(tituloP);
    }

    public void save(Proyecto proyec){
        rProyecto.save(proyec);
    }

    public void delete(int id){
        rProyecto.deleteById(id);
    }

    public boolean existsById(int id){
        return rProyecto.existsById(id);
    }

    public boolean existsByTituloP(String tituloP){
        return rProyecto.existsByTituloP(tituloP);
    }

    
    
    
    
}

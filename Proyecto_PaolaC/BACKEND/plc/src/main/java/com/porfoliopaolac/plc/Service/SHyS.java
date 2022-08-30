/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliopaolac.plc.Service;

import com.porfoliopaolac.plc.Entity.HyS;
import com.porfoliopaolac.plc.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHyS {
   
    @Autowired
    
    RHyS rHyS;
     public  List<HyS> list(){
        return  rHyS.findAll();
    }

    public Optional<HyS> getOne(int id){
        return rHyS.findById(id);
    }

    public Optional<HyS> getByNombreHys(String nombreHys){
        return rHyS.findByNombreHys(nombreHys);
    }

    public void save(HyS skill){
        rHyS.save(skill);
    }

    public void delete(int id){
        rHyS.deleteById(id);
    }

    public boolean existsById(int id){
        return rHyS.existsById(id);
    }

    public boolean existsByNombreHys(String nombreHys){
        return rHyS.existsByNombreHys(nombreHys);
    }

    
}

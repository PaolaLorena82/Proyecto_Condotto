/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliopaolac.plc.Controller;

import com.porfoliopaolac.plc.DTO.dtoHys;
import com.porfoliopaolac.plc.Entity.HyS;

import com.porfoliopaolac.plc.Security.Controller.Mensaje;
import com.porfoliopaolac.plc.Service.SHyS;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/hys")

public class CHys {
      @Autowired
      
      SHyS sHyS;

      @GetMapping("/lista")
      public ResponseEntity<List<HyS>> list(){
        List<HyS> list = sHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
       
    }
      
      @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id")int id){
        if(!sHyS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = sHyS.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
      
      @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHyS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sHyS.delete(id);
        return new ResponseEntity(new Mensaje("HyS Eliminada"), HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys){
        if(StringUtils.isBlank(dtohys.getNombreHys())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHyS.existsByNombreHys(dtohys.getNombreHys())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = new HyS(
                dtohys.getNombreHys(), dtohys.getImgHys(),dtohys.getCapacidadesHys());
           
        sHyS.save(hys);
        return new ResponseEntity(new Mensaje("HyS creada"), HttpStatus.OK);

    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys){
        if(!sHyS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sHyS.existsByNombreHys(dtohys.getNombreHys()) && sHyS.getByNombreHys(dtohys.getNombreHys()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohys.getNombreHys())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = sHyS.getOne(id).get();

        hys.setNombreHys(dtohys.getNombreHys());
        hys.setImgHys(dtohys.getImgHys());
        hys.setCapacidadesHys(dtohys.getCapacidadesHys());
        

        sHyS.save(hys);

        return new ResponseEntity(new Mensaje("HyS actualizado"), HttpStatus.OK);
    }
    
}

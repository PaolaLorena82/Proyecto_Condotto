
package com.porfoliopaolac.plc.Controller;

import com.porfoliopaolac.plc.DTO.dtoExperiencia;
import com.porfoliopaolac.plc.Entity.Experiencia;
import com.porfoliopaolac.plc.Security.Controller.Mensaje;
import com.porfoliopaolac.plc.Service.SExperiencia;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")

public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) 
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
 
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
   
  @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia) {
        if (StringUtils.isBlank(dtoexperiencia.getNombreEx())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
 
        if (sExperiencia.existsByNombreEx(dtoexperiencia.getNombreEx())) 
            return new ResponseEntity(new Mensaje("Experiencia existe"), HttpStatus.BAD_REQUEST);
        

        Experiencia experiencia = new Experiencia
        (dtoexperiencia.getNombreEx(), dtoexperiencia.getDescripcionEx());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
}
  


    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexperiencia) {
        //Validamos si existe el ID
        if (!sExperiencia.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        //Compara nombre de experiencias
        if (sExperiencia.existsByNombreEx(dtoexperiencia.getNombreEx()) && sExperiencia.getByNombreEx(dtoexperiencia.getNombreEx()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if (StringUtils.isBlank(dtoexperiencia.getNombreEx())) 
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        

        Experiencia experiencia = sExperiencia.getOne(id).get();
        
        experiencia.setNombreEx(dtoexperiencia.getNombreEx());
        experiencia.setDescripcionEx(dtoexperiencia.getDescripcionEx());

        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}

    


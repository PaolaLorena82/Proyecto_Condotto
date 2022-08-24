/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliopaolac.plc.Security.Service;

import com.porfoliopaolac.plc.Security.Entity.Rol;
import com.porfoliopaolac.plc.Security.Enums.RolNombre;
import com.porfoliopaolac.plc.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
    return irolRepository.findByRolNombre(rolNombre);
            }
    
    
    public void save (Rol rol){
        irolRepository.save(rol);
    }
}

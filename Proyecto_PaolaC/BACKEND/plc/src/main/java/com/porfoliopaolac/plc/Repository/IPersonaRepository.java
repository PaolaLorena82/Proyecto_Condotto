
package com.porfoliopaolac.plc.Repository;

import com.porfoliopaolac.plc.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
    
    
}

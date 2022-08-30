
package com.porfoliopaolac.plc.Repository;

import com.porfoliopaolac.plc.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto>findByTituloP(String tituloP);
    public boolean existsByTituloP(String tituloP);
    
}
    
 
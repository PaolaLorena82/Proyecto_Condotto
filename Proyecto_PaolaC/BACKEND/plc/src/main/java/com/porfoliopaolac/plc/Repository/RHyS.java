
package com.porfoliopaolac.plc.Repository;

import com.porfoliopaolac.plc.Entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface RHyS extends JpaRepository<HyS, Integer>{
    public Optional<HyS> findByNombreHys(String nombreHys);
    public boolean existsByNombreHys (String nombreHys);
    
    
}

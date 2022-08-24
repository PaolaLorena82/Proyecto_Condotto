
package com.porfoliopaolac.plc.Interface;


import com.porfoliopaolac.plc.Entity.Persona;
import java.util.List;





public interface IPersonaService { 
    
    //publicar lista//

    public List <Persona> getPersona();
    
    //agregar personas//
    public void savePersona (Persona persona);
    
    //sacar personas//
    
    public void deletePersona (Long id);
    
    //encontrar perona//
    
    public Persona findPersona (Long  id);
    
}

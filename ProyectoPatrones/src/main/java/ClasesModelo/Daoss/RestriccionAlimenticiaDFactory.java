/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import ClasesModelo.Daoss.RestriccionAlimenticiaDao;
import Clasesmodelo.Interfacesmodelo.Restrialimenticia;
import java.sql.Connection;
/**
 *
 * @author Michael
 */
public class RestriccionAlimenticiaDFactory {
    
    
    public static Restrialimenticia ObjetoRestricionAlimenticiaDao(Connection connection){
        
         return new RestriccionAlimenticiaDao(connection); 
         
     
     
     }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import ClasesModelo.Daoss.PreferenciasDao;
import Clasesmodelo.Interfacesmodelo.Preferencia;
import java.sql.Connection;

/**
 *
 * @author Michael
 */
public class PreferenciasDFactory {
    
    
    public static  Preferencia ObjetoPreferenciasDao(Connection connection){
        
         return new PreferenciasDao(connection) ; 
           
     }
    
    
    
}

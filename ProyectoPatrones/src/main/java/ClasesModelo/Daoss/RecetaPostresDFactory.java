/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

 
import Clasesmodelo.Interfacesmodelo.RecetPostre;
import java.sql.Connection;
import ClasesModelo.Daoss.RecetaPostresDao; 

/**
 *
 * @author Michael
 */
public class RecetaPostresDFactory {
    
    public static RecetPostre ObjetoRecetaPostresdao(Connection connection){
        
         return new RecetaPostresDao(connection); 
            
     }
    
    
    
}

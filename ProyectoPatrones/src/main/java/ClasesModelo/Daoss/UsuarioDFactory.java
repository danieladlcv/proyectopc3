/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;
import Clasesmodelo.Interfacesmodelo.Usu; 
import ClasesModelo.Daoss.UsuarioDao;
import Base.DatabaseConnection; 
import java.sql.Connection;
/**
 *
 * @author Michael
 */
public class UsuarioDFactory {
    
     public static Usu ObjetoUsudao(Connection connection){
        
         return new UsuarioDao(connection); 
         
     
     
     }
    
    
    
    
}

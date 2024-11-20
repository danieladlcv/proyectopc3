/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import Clasesmodelo.Interfacesmodelo.Notificacion;
import java.sql.Connection;

/**
 *
 * @author Michael
 */
public class NotificacionCorreoDao implements Notificacion{

    private Connection connection; 
    public NotificacionCorreoDao(Connection connection) {
      this.connection= connection; 
    }

    @Override
    public void enviarmesajes(String destino, String asunto, String mensaje) {
        
    }

    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import Clasesmodelo.Interfacesmodelo.Notificacion;
import ClasesModelo.NotificacionCorreo;
import ClasesModelo.Daoss.NotificacionCorreoDao; 
import ClasesModelo.NotificacionSMS;
import java.sql.Connection;
/**
 *
 * @author Michael
 */
public class NotificacionDFactory {
    
    public static Notificacion crearNotificacion(Connection connection, String tipo) {
        if (tipo.equalsIgnoreCase("correo")) {

           return new NotificacionCorreoDao(connection);
           
        } else if (tipo.equalsIgnoreCase("sms")) {
            
            return new NotificacionSMSDao(connection);
        }else{
        
         throw new IllegalArgumentException("Tipo de notificación no soportado"); }
   }   
}

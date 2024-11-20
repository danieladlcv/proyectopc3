/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesControl;

import Base.DatabaseConnection;
import ClasesControl.*;
import ClasesModelo.NotificacionCorreo;
import ClasesModelo.NotificacionSMS;
import ClasesModelo.Preferencias;
import ClasesModelo.RecetaPostres;
import ClasesModelo.RestriccionAlimenticia;
import ClasesModelo.Usuario;

import Clasesmodelo.Interfacesmodelo.Notificacion;


/**
 *
 * @author Michael
 */
public class Objetosserviciosfactory {
    
    public Objetosserviciosfactory(){
     DatabaseConnection dbConnection = DatabaseConnection.getInstance(); 
    }
   public static Usuario crearservicioUsuario(int id, String nombre,String email, String celular, String password) {
        
     return new Usuario( id, nombre, email,celular, password) ;
    }
    
    public static RestriccionAlimenticia crearobjetoRestriccion(int id, String alergias, boolean Gluten, boolean Lactosa, boolean Azucar, boolean Vegano, boolean Citrico, boolean Bajoengrasa) {
        return new RestriccionAlimenticia(id,alergias, Gluten,  Lactosa,  Azucar, Vegano,  Citrico,  Bajoengrasa);    
    }

 
    public static Preferencias crearservicioPreferencia(String tipopostre, String nivelactividad, int comidasaldia, boolean prefiereOrganico, boolean bajoEnAzucar, boolean altoEnProteinas) {
        return new Preferencias(tipopostre, nivelactividad, comidasaldia,prefiereOrganico, bajoEnAzucar, altoEnProteinas);
    }

    public static RecetaPostres crearservicioReceta(int id, String nombre, String tipopostre, String ingredientes, String descripcionreceta) {
        return new RecetaPostres( id,  nombre,  tipopostre,  ingredientes, descripcionreceta);
    }
    
    public static NotificacionCorreo enviarnoticorreo(String destino, String motivo, String mensaje){
        return new NotificacionCorreo(destino, motivo,mensaje);
    }
    
    public static NotificacionSMS enviarnotisms(String destino, String motivo, String mensaje){
        return new NotificacionSMS(destino,motivo,mensaje);
    }
    
    
    
}

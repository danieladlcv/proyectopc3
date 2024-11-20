/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesControl;

import Base.DatabaseConnection;
import ClasesControl.*;
import ClasesModelo.Daoss.NotificacionDFactory;
import ClasesModelo.Daoss.PreferenciasDFactory;
import ClasesModelo.Daoss.RecetaPostresDFactory;
import ClasesModelo.Daoss.RestriccionAlimenticiaDFactory;
import ClasesModelo.Daoss.UsuarioDFactory;
import ClasesModelo.NotificacionCorreo;
import ClasesModelo.NotificacionSMS;

import ClasesModelo.Preferencias;
import ClasesModelo.RecetaPostres;
import ClasesModelo.RestriccionAlimenticia;
import ClasesModelo.Usuario;
import ClasesVista.Clasesproxybridge.VistaRegistroUsuario;
import ClasesVista.Clasesproxybridge.VistaUsuarioSwing;
import ClasesVista.Interfaceproxybridge.VistaComidaSaludable;
import ClasesVista.Interfaceproxybridge.VistaUsuario;
import Clasesmodelo.Interfacesmodelo.Notificacion;
import Clasesmodelo.Interfacesmodelo.Preferencia;
import Clasesmodelo.Interfacesmodelo.RecetPostre;
import Clasesmodelo.Interfacesmodelo.Restrialimenticia;
import Clasesmodelo.Interfacesmodelo.Usu;
import java.sql.Connection;
import javax.swing.SwingUtilities;

/**
 *
 * @author Michael
 */
public class FacadeServicios {
    //private VistaComidaSaludable vista;
    DatabaseConnection dbConnection= new DatabaseConnection(); 
    
    public FacadeServicios() {
       
       this.dbConnection=DatabaseConnection.getInstance()  ; 
       
    }
    

    
    public Usu registrarUsuario(int id, String nombre, String email,String telefono, String password) {
        
       
        Usuario usuario = Objetosserviciosfactory.crearservicioUsuario(id, nombre, email, telefono, password);      
        //return usuario;
        Usu usuariodo = UsuarioDFactory.ObjetoUsudao(dbConnection.getConnection());
        usuariodo.ingresoUsu(usuario); 
        
      return usuariodo  ; 
    }
    
    
    public void actualizarusuario(Usu usuariodo, String nombre, String email, String telefono, String password){
         usuariodo.updateUsu(nombre, email,telefono, password)    ;
         
    }

    public Restrialimenticia crearRestriccion(int id, String alergias, boolean Gluten, boolean Lactosa, boolean Azucar, boolean Vegano, boolean Citrico, boolean Bajoengrasa) {
        
        RestriccionAlimenticia restriccion = Objetosserviciosfactory.crearobjetoRestriccion(id,alergias, Gluten, Lactosa, Azucar, Vegano, Citrico, Bajoengrasa);
         //return restriccion             ; 
         
        Restrialimenticia restricalimendao= RestriccionAlimenticiaDFactory.ObjetoRestricionAlimenticiaDao(dbConnection.getConnection()); 
         restricalimendao.ingresoRestrialimenticia(restriccion);
         return restricalimendao; 
    }
    
   public Preferencia crearpreferencia (String tipopostre, String nivelactividad, int comidasaldia, boolean prefiereOrganico, boolean bajoEnAzucar, boolean altoEnProteínas) {
       
        Preferencias preferencia = Objetosserviciosfactory.crearservicioPreferencia(tipopostre, nivelactividad, comidasaldia,prefiereOrganico, bajoEnAzucar, altoEnProteínas);
         //return preferencia               ;
        Preferencia preferendao= PreferenciasDFactory.ObjetoPreferenciasDao(dbConnection.getConnection()); 
       return preferendao; 
   }
   
   public RecetPostre crearservicioReceta(int id, String nombre, String tipopostre, String ingredientes, String descripcionreceta) {
       
       RecetaPostres recetapostres = Objetosserviciosfactory.crearservicioReceta(id, nombre, tipopostre, ingredientes, descripcionreceta);
       
       //return recetapostres;
    
       RecetPostre recetapostredao= RecetaPostresDFactory.ObjetoRecetaPostresdao(dbConnection.getConnection()); 
      return recetapostredao;
   }
   
    public Notificacion enviarnoticorreo(String destino, String motivo, String mensaje){

           NotificacionCorreo notificacionCorreo = Objetosserviciosfactory.enviarnoticorreo(destino,motivo,mensaje);

           //return notificacionCorreo;
           Notificacion notificorreodao= NotificacionDFactory.crearNotificacion(dbConnection.getConnection(), "Correo"); 
          return notificorreodao; 
    }

       public Notificacion enviarnotisms(String celulardestino, String motivo, String mensaje){

           NotificacionSMS notificacionSMS = Objetosserviciosfactory.enviarnotisms(celulardestino, motivo, mensaje);

           //return notificacionSMS ;
           Notificacion notifisms= NotificacionDFactory.crearNotificacion(dbConnection.getConnection(), "sms"); 
           return notifisms; 
           
       }
  

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo;



/**
 *
 * @author Michael
 */
public class NotificacionCorreo {
    
   
    private String destino;
    private String motivo;
    private String mensaje;

    public NotificacionCorreo(String correodestino, String motivo, String mensaje) {
        this.destino = correodestino;
        this.motivo = motivo;
        this.mensaje = mensaje;
    }

    public String getDestino() {
        return destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
   
   
   
   }
    


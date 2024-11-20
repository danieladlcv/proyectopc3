/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesVista.ClasesComando;

import ClasesControl.FacadeServicios;
import ClasesVista.InterfaceComando.ComandoSMS;

/**
 *
 * @author Michael
 */
public class EnvioCorreo implements ComandoSMS{
    
    private FacadeServicios facade;
    
    public EnvioCorreo(FacadeServicios facade){
        this.facade=facade;
    }
    
//    public void ejecutar(String destino, String motivo, String mensaje) {
//        facade.enviarnoticorreo(destino, motivo, mensaje);
//    }

    @Override
    public void efectuar(String destino, String motivo, String mensaje) {
        facade.enviarnoticorreo(destino, motivo, mensaje);
    }

    
    
    
}

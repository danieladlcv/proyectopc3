/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesVista.Clasesproxybridge;

import ClasesVista.Interfaceproxybridge.VistaUsuario;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VistaRegistroUsuario {
  private VistaUsuario vistaUsuario;

    public VistaRegistroUsuario(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
    }

    public void iniciar() {
        vistaUsuario.mostrar();
    }

    public void mostrarMensaje(String mensaje) {
        vistaUsuario.mostrarMensaje(mensaje);
    }

    public void cerrar() {
        vistaUsuario.cerrar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaUsuario vista = new VistaUsuarioSwing(); // Aquí podríamos cambiar la implementación
            VistaRegistroUsuario app = new VistaRegistroUsuario(vista);
            app.iniciar();
            
           if (vista instanceof VistaUsuarioSwing) {
               VistaUsuarioSwing vistaSwing = (VistaUsuarioSwing) vista;
               String usuario = vistaSwing.getCampoNombre().toString(); 
               
           }
            
        });
        
    }  
}

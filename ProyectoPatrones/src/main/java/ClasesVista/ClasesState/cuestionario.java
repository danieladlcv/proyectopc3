/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesVista.ClasesState;

import ClasesVista.InterfaceState.CuestionarioState;
import javax.swing.JButton;
import javax.swing.JPanel;


public class cuestionario {
    
 private CuestionarioState estadoActual;

   
    public cuestionario() {
        this.estadoActual = new EstadoInicio(); // Estado inicial
    }

    public void setEstado(CuestionarioState nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void manejarEstado(JPanel panelCuestionario, JButton btnGuardar, JButton btnCerrar) {
        estadoActual.manejarEstado(panelCuestionario, btnGuardar, btnCerrar);
    }
}
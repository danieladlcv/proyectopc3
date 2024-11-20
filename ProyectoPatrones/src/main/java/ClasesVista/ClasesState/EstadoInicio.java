/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesVista.ClasesState;

import ClasesVista.InterfaceState.CuestionarioState;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yamil
 */
public class EstadoInicio implements CuestionarioState{

    @Override
    public void manejarEstado(JPanel panelCuestionario, JButton btnGuardar, JButton btnCerrar) {
        
        btnGuardar.setEnabled(false);
        btnCerrar.setEnabled(true);
        panelCuestionario.setVisible(true);  // Mostrar el panel de cuestionario
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clasesmodelo.Interfacesmodelo;

import java.util.List;
import ClasesModelo.Usuario;

/**
 *
 * @author Michael
 */
public interface Usu {
    List<Usuario> mostrarUsu();
    Usuario mostrarunUsu(int id); 
    void updateUsu (String nombre, String email,String telefono, String password); 
    void ingresoUsu (Usuario usua); 
    void deleteUsu (int id); 
}

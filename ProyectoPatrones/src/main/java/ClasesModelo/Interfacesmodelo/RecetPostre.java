/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clasesmodelo.Interfacesmodelo;

import ClasesModelo.RecetaPostres;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface RecetPostre {
    List<RecetaPostres> mostrarRecetaPostres();
    RecetaPostres mostrarunRecetaPostres(int id);
    void updateRecetaPostres (RecetaPostres receta); 
    void ingresoRecetaPostres (RecetaPostres receta); 
    void deleteRecetaPostres (int id); 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clasesmodelo.Interfacesmodelo;

import ClasesModelo.Preferencias;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface Preferencia {
    List<Preferencias> mostrarPreferencia();
    Preferencias mostrarunPreferencia(int id); 
    void updatePreferencia (String tipopostre, String nivelactividad, int comidasaldia, boolean prefiereOrganico, boolean bajoEnAzucar, boolean altoEnProteinas);
    void ingresoPreferencia (Preferencias pref);
    void deletePreferencia (int id);
}

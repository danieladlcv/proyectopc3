/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import ClasesModelo.Preferencias;
import Clasesmodelo.Interfacesmodelo.Preferencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class PreferenciasDao implements Preferencia{
    private Connection connection;

    public PreferenciasDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Preferencias> mostrarPreferencia() {
         List Preferen = null;
      String query = "{CALL mostrarPreferencia()}";
      try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
          Preferen = new ArrayList<>();
          ResultSet rs = preparedStatement.executeQuery(query);
          
          while (rs.next()) {
              String tipopostre = rs.getString("tipopostre");
              String nivelactividad = rs.getString("nivelactividad");
              int comidasaldia = rs.getInt("comidasaldia");
              Boolean prefiereOrganico = rs.getBoolean("prefiereOrganico");
              Boolean bajoEnAzucar = rs.getBoolean("bajoEnAzucar");
              Boolean altoEnProteinas = rs.getBoolean("altoEnProteinas");
              Preferen.add(new Preferencias(tipopostre, nivelactividad, comidasaldia, prefiereOrganico, bajoEnAzucar, altoEnProteinas));
          }         
      } catch (SQLException ex) {
          Logger.getLogger(PreferenciasDao.class.getName()).log(Level.SEVERE, null, ex);
      }
      return Preferen;
    }

    @Override
    public Preferencias mostrarunPreferencia(int id) {
        Preferencias Preferen = null;
      String query = "{CALL mostrarunPreferencia()}";
      try(PreparedStatement pstmt = connection.prepareStatement(query)){
          pstmt.setInt(1, id); 
          ResultSet rs = pstmt.executeQuery(query);
          
          while (rs.next()) {
              String tipopostre = rs.getString("tipopostre");
              String nivelactividad = rs.getString("nivelactividad");
              int comidasaldia = rs.getInt("comidasaldia");
              Boolean prefiereOrganico = rs.getBoolean("prefiereOrganico");
              Boolean bajoEnAzucar = rs.getBoolean("bajoEnAzucar");
              Boolean altoEnProteinas = rs.getBoolean("altoEnProteinas");
              Preferen= new Preferencias(tipopostre, nivelactividad, comidasaldia, prefiereOrganico, bajoEnAzucar, altoEnProteinas);
          }         
      } catch (SQLException ex) {
          Logger.getLogger(PreferenciasDao.class.getName()).log(Level.SEVERE, null, ex);
      }
      return Preferen;
    }

    @Override
    public void updatePreferencia(String tipopostre, String nivelactividad, int comidasaldia, boolean prefiereOrganico, boolean bajoEnAzucar, boolean altoEnProteinas) {
         String query = "{CALL updatepreferencias(?, ?, ?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {           
            stmt.setString(1, tipopostre );
            stmt.setString(2, nivelactividad);
            stmt.setInt(3,comidasaldia);
            stmt.setBoolean(4, prefiereOrganico );
            stmt.setBoolean(5, bajoEnAzucar);
            stmt.setBoolean(6, altoEnProteinas);
            stmt.executeUpdate();
            connection.close();
            System.out.println("Preferencia modificada");
        }catch (SQLException ex){
          Logger.getLogger(PreferenciasDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Preferencia sin modificar") ;
        }
    }

    @Override
    public void ingresoPreferencia(Preferencias pref) {
        String query = "{CALL agregarpreferencias(?, ?, ?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareCall(query)) {
            stmt.setString(1, pref.getTipopostre());
            stmt.setString(2, pref.getNivelactividad());
            stmt.setInt(3,pref.getComidasaldia());
            stmt.setBoolean(4, pref.isPrefiereOrganico());
            stmt.setBoolean(5, pref.isBajoEnAzucar());
            stmt.setBoolean(6, pref.isAltoEnProteinas());
            stmt.execute();
            connection.close();
            System.out.println("Preferencia registrada");
        }catch (SQLException ex){
          Logger.getLogger(PreferenciasDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Preferencia no registrada");
        }
    }

    @Override
    public void deletePreferencia(int id) {
        String query = "{CALL borrarpreferencias(?)}";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            connection.close();
            System.out.println("Preferencia eliminada");
        } catch (SQLException ex) {
          Logger.getLogger(PreferenciasDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    
}

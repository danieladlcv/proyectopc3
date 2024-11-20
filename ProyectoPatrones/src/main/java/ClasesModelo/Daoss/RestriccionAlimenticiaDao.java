/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import java.sql.Connection;
import ClasesModelo.RestriccionAlimenticia;
import Clasesmodelo.Interfacesmodelo.Restrialimenticia;
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
public class RestriccionAlimenticiaDao implements Restrialimenticia{

    private Connection connection;
    
    public RestriccionAlimenticiaDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<RestriccionAlimenticia> mostrarRestrialimenticia() {
        List restricciones = null;
        String query = "{CALL mostrarrestricciones()}";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
          restricciones = new ArrayList<>();
          ResultSet rs = preparedStatement.executeQuery(query);
          
          while (rs.next()) {
              int id = rs.getInt("id");
              String alergias = rs.getString("alergias");
              Boolean Gluten = rs.getBoolean("gluten");
              Boolean Lactosa = rs.getBoolean("lactosa");
              Boolean Azucar = rs.getBoolean("azucar");
              Boolean Vegano = rs.getBoolean("vegano");
              Boolean Citrico = rs.getBoolean("citrico");
              Boolean Bajoengrasa = rs.getBoolean("bajoengrasa");
              restricciones.add(new RestriccionAlimenticia(id, alergias, Gluten, Lactosa, Azucar, Vegano, Citrico, Bajoengrasa));
          }         
      } catch (SQLException ex) {
          Logger.getLogger(RestriccionAlimenticiaDao.class.getName()).log(Level.SEVERE, null, ex);
      }
        return restricciones;
    }

    @Override
    public RestriccionAlimenticia mostrarunRestriccionalimenticia(int ids) {
        RestriccionAlimenticia restric= null;
        String query = "{CALL mostrarunRestriccion(?)}";
         try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setInt(1, ids); // Asegúrate de que el ID sea correcto
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
              
              String alergias = rs.getString("alergias");
              Boolean Gluten = rs.getBoolean("gluten");
              Boolean Lactosa = rs.getBoolean("lactosa");
              Boolean Azucar = rs.getBoolean("azucar");
              Boolean Vegano = rs.getBoolean("vegano");
              Boolean Citrico = rs.getBoolean("citrico");
              Boolean Bajoengrasa = rs.getBoolean("bajoengrasa");
            restric=new RestriccionAlimenticia(ids, alergias, Gluten, Lactosa, Azucar, Vegano, Citrico, Bajoengrasa);
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
        return restric;
    }

    @Override
    public void updateRestrialimenticia(int id, String alergias, boolean gluten, boolean lactosa, boolean azucar, boolean vegano, boolean citrico, boolean bajograsa) {
        String query = "{CALL mostrarRestriccion(?, ?, ?, ?, ?, ?, ?, ?)}"; // Procedimiento almacenado
        try (PreparedStatement stmt = connection.prepareStatement(query)) {           
            stmt.setInt(1, id );
            stmt.setString(2, alergias);
            stmt.setBoolean(3, gluten );
            stmt.setBoolean(4, lactosa);
            stmt.setBoolean(5, azucar);
            stmt.setBoolean(6, vegano);
            stmt.setBoolean(7, citrico);
            stmt.setBoolean(8, bajograsa);
            stmt.executeUpdate();
            connection.close();
            System.out.println("Restriccion modificado");
        }catch (SQLException ex){
          Logger.getLogger(RestriccionAlimenticiaDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Restriccion sin modificar") ;
        }  
    }

    @Override
    public void ingresoRestrialimenticia(RestriccionAlimenticia restriccion) {
        String query = "{CALL agregarRestriccion(?, ?, ?, ?, ?, ?, ?,?)}";
    try (PreparedStatement stmt = connection.prepareCall(query)) {
            stmt.setInt(1, restriccion.getId());
            stmt.setString(2, restriccion.getAlergias());
            stmt.setBoolean(3, restriccion.isGluten()); 
            stmt.setBoolean(4, restriccion.isLactosa());
            stmt.setBoolean(5, restriccion.isAzucar());
            stmt.setBoolean(6, restriccion.isVegano());
            stmt.setBoolean(7, restriccion.isCitrico());
            stmt.setBoolean(8, restriccion.isBajoengrasa());
            stmt.execute();
            connection.close();
            System.out.println("Restricción registrada");
        }catch (SQLException ex){
          Logger.getLogger(RestriccionAlimenticiaDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Restricción no registrada");
        }
    }

    @Override
    public void deleteRestrialimenticia(int id) {
        String query = "{CALL eliminarRestriccion(?)}";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            connection.close();
            System.out.println("Restriccion eliminada");
        } catch (SQLException ex) {
          Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    

    
    
}

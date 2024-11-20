/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import java.sql.Connection;
import ClasesModelo.RecetaPostres;
import Clasesmodelo.Interfacesmodelo.RecetPostre;
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
public class RecetaPostresDao implements RecetPostre{
    private Connection connection; 
    
    public RecetaPostresDao(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public List<RecetaPostres> mostrarRecetaPostres() {
         List recetas= null;
        String query = "{CALL mostrarrecetapostres()}";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {         
          recetas= new ArrayList<>();
          //Statement stmt = connection.createStatement();
          ResultSet rs = preparedStatement.executeQuery(query);
          
          while (rs.next()) {
              int id = rs.getInt("id");
              String nombre = rs.getString("nombre");
              String tipopostre = rs.getString("tipopostre");
              String ingredientes= rs.getString("ingredientes");
              String descripcion= rs.getString("descripcionReceta");
              recetas.add(new RecetaPostres(id, nombre, tipopostre, ingredientes, descripcion));
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(RecetaPostresDao.class.getName()).log(Level.SEVERE, null, ex);
      }
      return recetas;
    }

    @Override
    public RecetaPostres mostrarunRecetaPostres(int id) {
        RecetaPostres recet = null;
        String sql = "{CALL mostrarunRecetaPostres(?)}"; 

    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, id); 
        ResultSet rs = pstmt.executeQuery() ;

        if (rs.next()) {
            
            String nombre = rs.getString("nombre");
            String tipopostre = rs.getString("tipopostre");
            String ingredientes = rs.getString("ingredientes");
            String descripcion= rs.getString("descripcionReceta");
            recet = new RecetaPostres(id, nombre, tipopostre, ingredientes, descripcion);
        }
    } catch (SQLException ex) {
        Logger.getLogger(RecetaPostresDao.class.getName()).log(Level.SEVERE, null, ex);
    }

      return recet;
    }

    @Override
    public void updateRecetaPostres(RecetaPostres receta) {
        String sql = "{CALL ActualizarRecetaPostres(?, ?, ?,?,?)}"; // Procedimiento almacenado
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {           
            stmt.setInt(1, receta.getId() );
            stmt.setString(2, receta.getNombre());
            stmt.setString(3, receta.getTipopostre());
            stmt.setString(4, receta.getIngredientes());
            stmt.setString(5, receta.getDescripcionreceta());
            stmt.executeUpdate();
            connection.close();
            System.out.println("Receta modificada");
        }catch (SQLException ex){
          Logger.getLogger(RecetaPostresDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Receta sin modificar"); 
        }
        
        
        
    }

    @Override
    public void ingresoRecetaPostres(RecetaPostres receta) {
        String sql = "{call AgregarRecetaPostres(?, ?,?,?,?)}"; // Procedimiento almacenado
        try (PreparedStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, receta.getId());
            stmt.setString(2, receta.getNombre());
            stmt.setString(3, receta.getTipopostre()); 
            stmt.setString(4, receta.getIngredientes());
            stmt.setString(5, receta.getDescripcionreceta());
            stmt.execute();
            connection.close();
            System.out.println("Receta registrada");
        }catch (SQLException ex){
          Logger.getLogger(RecetaPostresDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Receta no registrada");
        }
    }

    @Override
    public void deleteRecetaPostres(int id) {
        String sql = "{CALL BorrarRecetaPostres(?)}"; // Procedimiento almacenado
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            connection.close();
            System.out.println("Receta eliminada");
        } catch (SQLException ex) {
          Logger.getLogger(RecetaPostresDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo.Daoss;

import Base.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import ClasesModelo.Usuario;
import Clasesmodelo.Interfacesmodelo.Usu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class UsuarioDao implements Usu {
  private Connection connection;
  DatabaseConnection dbconnection; 
 public UsuarioDao(Connection connection){
     this.connection= connection; 
      
 
 }
    
    @Override
    public List<Usuario> mostrarUsu() {
        List usuarios= null;
        String query = "{CALL mostrarusuarios()}";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {         
          usuarios = new ArrayList<>();
          //Statement stmt = connection.createStatement();
          ResultSet rs = preparedStatement.executeQuery(query);
          
          while (rs.next()) {
              int id = rs.getInt("id");
              String nombre = rs.getString("nombre");
              String email = rs.getString("email");
              String telefono=rs.getString("telefono");
              String password= rs.getString("password");
              
              usuarios.add(new Usuario(id, nombre, email,telefono, password));
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
      return usuarios;
    }

    @Override
    public void updateUsu(String nombre, String email,String telefono, String password) {
         
        String sql = "{CALL updateusuarios(?, ?, ?,?,?)}"; // Procedimiento almacenado
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {           
            //stmt.setInt(1, id );
            stmt.setString(2, nombre );
            stmt.setString(3, email);
            stmt.setString(4, email);
            stmt.setString(5, password);
            stmt.executeUpdate();
            connection.close();
            System.out.println("Usuario modificado");
        }catch (SQLException ex){
          Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Usuario sin modificar") ;
        }
    }

    @Override
    public void ingresoUsu(Usuario usua) {
        String sql = "{call agregarusuario(?, ?,?,?,?)}"; // Procedimiento almacenado
        try (PreparedStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, usua.getId());
            stmt.setString(2, usua.getNombre());
            stmt.setString(3, usua.getEmail()); 
            stmt.setString(4, usua.getTelefono());
            stmt.setString(5, usua.getPassword());
            
            stmt.execute();
            connection.close();
            System.out.println("Usuario registrado");
        }catch (SQLException ex){
          Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex); 
            System.out.println("Usuario no registrado") ;
        }
    }

    @Override
    public void deleteUsu(int id) {
         
        String sql = "{CALL borrarusuarios(?)}"; // Procedimiento almacenado
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            connection.close();
            System.out.println("Usuario eliminado");
        } catch (SQLException ex) {
          Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @Override
    public Usuario mostrarunUsu(int ids) {
        Usuario usuario = null;
    String sql = "{CALL mostrarunusuario(?)}"; 

    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, ids); 
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String email = rs.getString("email");
            String telefono=rs.getString("telefono");
            String password = rs.getString("password");
            
            usuario = new Usuario(ids, nombre, email,telefono, password);
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }

    return usuario;
    }

    
    
    
}

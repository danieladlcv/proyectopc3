/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

/**
 *
 * @author Michael
 */
import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    
    // Parámetros de conexión
    private String url="jdbc:mysql://localhost:3306/postressaludables";;
    private String user="root";
    private String password="";

   

    // Constructor privado
    public DatabaseConnection() {
//        this.url = url;
//        this.user = user;
//        this.password = password;
        connect();
    }

     public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

   
    
    
    // Método para obtener la instancia
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        System.out.println("Base con instancia ya creada" + "\n");
        return instance;
        
    }

    // Método para conectar a la base de datos
    private void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
    
    //cerrar conección
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
  

}





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

/**
 *
 * @author Michael
 */

/*
import javax.mail.Session;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;



public class CorreoConnec {
    
    
public class EmailSession {
    private static EmailSession instancia;
    private Session session;
    private String usuario;
    private String contraseña;

    private EmailSession(String usuario, String contraseña)  {
        
  
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.session = crearSesion();
    }

    public static EmailSession obtenerInstancia(String usuario, String contraseña) {
        if (instancia == null) {
            instancia = new EmailSession(usuario, contraseña);
        }
        return instancia;
    }

    
    }

    
private Session crearSesion() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        });
    }

    public Session getSession() {
        return session;
    }
}
    
    
    
    
}


*/
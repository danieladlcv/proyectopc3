/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClasesModelo;

/**
 *
 * @author Michael
 */

import ClasesModelo.Daoss.UsuarioDFactory;
import Clasesmodelo.Interfacesmodelo.Usu; 
import Base.DatabaseConnection; 
import ClasesControl.FacadeServicios;
import ClasesModelo.Daoss.RecetaPostresDao;
import java.util.ArrayList;
import java.util.List;
import ClasesModelo.Daoss.UsuarioDao; 
import ClasesVista.Clasesproxybridge.VistaRegistroUsuario;
import ClasesVista.Clasesproxybridge.VistaUsuarioSwing;
import ClasesVista.Interfaceproxybridge.VistaUsuario;
import Clasesmodelo.Interfacesmodelo.RecetPostre;
import Clasesmodelo.Interfacesmodelo.Restrialimenticia;
import javax.swing.SwingUtilities;


public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Parámetros de conexión
//            String url = "jdbc:mysql://localhost:3306/postressaludables";
//            String user = "root";
//            String password = "";

        // Obtener la instancia de la conexión
            //DatabaseConnection dbConnection = DatabaseConnection.getInstance(url, user, password) ;
            
        // Obtener un objeto usuario 
           //Usuario usuario = new Usuario (42, "Mario", "Mario2025qgmail.com", "Mario2"); 
        
   
         // obtener un objeto dao 
//            Usu usuariodo = UsuarioDFactory.ObjetoUsudao(dbConnection.getConnection()); // el metodo ObUsu de UsuarioDFactory retorna un objeto dao
            
//            usuariodo.ingresoUsu(usuario) ;
         // usuariodo.mostrarunUsu(30); 
           
         // modificando el usuario con id 30    
         //   usuariodo.updateUsu(37, "Dalia", "Dalia2025@gmail.com", "Da09");
          //List<Usuario> usuarios= usuariodo.mostrarunUsu(37); 
          //for (Usuario usuario: usuarios){
            //  System.out.println(usuario);
          //}
       
        // borrando usuario determinado 
        //  usuariodo.deleteUsu(21);
        
         // System.out.println(usuariodo.mostrarunUsu(3).getId() + " "+ usuariodo.mostrarunUsu(3).getNombre()+ " "+ usuariodo.mostrarunUsu(3).getEmail() +  " "+usuariodo.mostrarunUsu(3).getPassword() + "\n");  
        
         // List<Usuario> usuarios = usuariodo.mostrarUsu();
        // System.out.println("Lista de usuarios: " + "\n");
//         for (Usuario usuario : usuarios) {
//            System.out.println(usuario.getId()+ " "+ usuario.getNombre()+ " "+ usuario.getEmail() + " "+ usuario.getPassword() );
//            
//            
//            
//        }
//         System.out.println("");
//         System.out.println("Clase Receta Postres Dao ");
//         
//         RecetaPostres receta= new RecetaPostres(4, "Pastel de coco con avena", "Torta", "Agua, leche, azucar, coco, harina", "Es buena para la salud"); 
//         RecetPostre recetitapostredao= RecetaPostresFactory.ObjetoRecetaPostresdao(dbConnection.getConnection()); 
         //recetitapostredao.ingresoRecetaPostres(receta);
         
         //Se modifica el objeto receta 
//         receta.setNombre("Helado de Fresa con miel ");
//         receta.setTipopostre("Helado");
//         receta.setIngredientes("Fresas,leche,azucar");
//         recetitapostredao.updateRecetaPostres(receta);
//         
//         System.out.println("");
//         System.out.println("Mostrar las recetas de postres");
//         List<RecetaPostres> listarecetas = recetitapostredao.mostrarRecetaPostres(); 
//         for (RecetaPostres recetapostres : listarecetas) {
//            System.out.println(recetapostres.getId()+ "   "+ recetapostres.getNombre()+ "   "+ recetapostres.getTipopostre()
//                    + "   "+ recetapostres.getIngredientes()+ "   " + recetapostres.getDescripcionreceta());
//            
//           }
         
//         System.out.println("");
//         System.out.println("Mostrar una receta");
//         System.out.println(recetitapostredao.mostrarunRecetaPostres(4).getId() + "  "
//           + recetitapostredao.mostrarunRecetaPostres(4).getNombre() + "   "+ 
//             recetitapostredao.mostrarunRecetaPostres(4).getTipopostre() + "   "+ 
//             recetitapostredao.mostrarunRecetaPostres(4).getIngredientes() + "   "+
//             recetitapostredao.mostrarunRecetaPostres(4).getDescripcionreceta()); 
    
//          System.out.println("");
//          System.out.println("Ingreso de un registro de restricciones alimenticias");
          // se crea el objeto de restriccion alimenticia asignando valores a los campos del constructor
//          RestriccionAlimenticia restrictalimenti= new RestriccionAlimenticia (6, "Almendras" , true, false, true,false, true, false); 
//          // se crea el objeto de restriccion alimenticia dao 
//          Restrialimenticia restriccionalimenticiadao = RestriccionAlimenticiaFactory.ObjetoRestricionAlimenticiaDao(dbConnection.getConnection()); 
////          restriccionalimenticiadao.ingresoRestrialimenticia(restrictalimenti);
//                   
//          System.out.println("");
//          System.out.println("Mostrar un registro de restricciones alimenticias");
//                  
//          System.out.println(restriccionalimenticiadao.mostrarunRestriccionalimenticia(6).getAlergias()+
//                 "    " + restriccionalimenticiadao.mostrarunRestriccionalimenticia(6).isGluten()+ "   "+
//                 restriccionalimenticiadao.mostrarunRestriccionalimenticia(6).isLactosa()+ "    "+ 
//                 restriccionalimenticiadao.mostrarunRestriccionalimenticia(6).isAzucar() + "    " + 
//                 restriccionalimenticiadao.mostrarunRestriccionalimenticia(6).isVegano()+ "      "+ 
//                 restriccionalimenticiadao.mostrarunRestriccionalimenticia(6).isCitrico() + "    "+ 
//                 restriccionalimenticiadao.mostrarunRestriccionalimenticia(6).isBajoengrasa());
//         
          
          
         //SwingUtilities.invokeLater(() -> {
            VistaUsuario vista = new VistaUsuarioSwing(); // Aquí podríamos cambiar la implementación
            VistaRegistroUsuario app = new VistaRegistroUsuario(vista);
            app.iniciar();
            
            //if (vista instanceof VistaUsuarioSwing) {
//               VistaUsuarioSwing vistaSwing = (VistaUsuarioSwing) vista;
//               
//               
//               
//               String usuario= vistaSwing.getCampoNombre().toString();
//               String correo=vistaSwing.getCampoCorreo().toString(); 
//               String contrasena= vistaSwing.getCampoContraseña().toString(); 
               
           // }
            
            
       // });
        
//        FacadeServicios facade= new FacadeServicios();
//        facade.registrarUsuario(46, usuario , correo, contrasena); 
        
       }

          
        
    } 

    


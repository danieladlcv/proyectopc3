/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo;

/**
 *
 * @author Michael
 */
public class RecetaPostres {
    private int id; 
    private String nombre;  
    private String tipopostre; 
    private String ingredientes;    
    private String descripcionreceta; 

    public RecetaPostres(int id, String nombre, String tipopostre, String ingredientes, String descripcionreceta) {
        this.id = id;
        this.nombre = nombre;
        this.tipopostre = tipopostre;
        this.ingredientes = ingredientes;
        this.descripcionreceta = descripcionreceta;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getTipopostre() {
        return tipopostre;
    }

    public void setTipopostre(String tipopostre) {
        this.tipopostre = tipopostre;
    }

    

    public String getDescripcionreceta() {
        return descripcionreceta;
    }

    public void setDescripcionreceta(String descripcionreceta) {
        this.descripcionreceta = descripcionreceta;
    }
    
    
    
    
    
}

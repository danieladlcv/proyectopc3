/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesModelo;

import java.util.List;

/**
 *
 * @author Michael
 */
public class RestriccionAlimenticia {
    private int id; 
    private String alergias;
    private boolean Gluten; 
    private boolean Lactosa; 
    private boolean Azucar; 
    private boolean Vegano; 
    private boolean Citrico; 
    private boolean Bajoengrasa; 

    public RestriccionAlimenticia(int id, String alergias, boolean Gluten, boolean Lactosa, boolean Azucar, boolean Vegano, boolean Citrico, boolean Bajoengrasa){
        this.id= id;
        this.alergias=alergias;
        this.Gluten= Gluten;
        this.Lactosa=Lactosa;
        this.Azucar= Azucar;
        this.Vegano= Vegano;
        this.Citrico= Citrico;
        this.Bajoengrasa= Bajoengrasa;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public boolean isGluten() {
        return Gluten;
    }

    public void setGluten(boolean Gluten) {
        this.Gluten = Gluten;
    }

    public boolean isLactosa() {
        return Lactosa;
    }

    public void setLactosa(boolean Lactosa) {
        this.Lactosa = Lactosa;
    }

    public boolean isAzucar() {
        return Azucar;
    }

    public void setAzucar(boolean Azucar) {
        this.Azucar = Azucar;
    }

    public boolean isVegano() {
        return Vegano;
    }

    public void setVegano(boolean Vegano) {
        this.Vegano = Vegano;
    }

    public boolean isCitrico() {
        return Citrico;
    }

    public void setCitrico(boolean Citrico) {
        this.Citrico = Citrico;
    }

    public boolean isBajoengrasa() {
        return Bajoengrasa;
    }

    public void setBajoengrasa(boolean Bajoengrasa) {
        this.Bajoengrasa = Bajoengrasa;
    }
    
    
    
    
    
}

package ClasesModelo;



public class Preferencias {
    private String tipopostre; //helado, galletitas, brownie
    private String nivelactividad; 
    private int comidasaldia;   
    private boolean prefiereOrganico;     // Indica si prefiere alimentos orgánicos
    private boolean bajoEnAzucar;         // Indica si prefiere alimentos bajos en azúcar
    private boolean altoEnProteinas; 
    
    
    // Indica si prefiere alimentos altos en proteínas
    
    public Preferencias(String tipopostre, String nivelactividad, int comidasaldia, boolean prefiereOrganico, boolean bajoEnAzucar, boolean altoEnProteinas){
      this.tipopostre= tipopostre;
      this.nivelactividad=nivelactividad;
      this.comidasaldia=comidasaldia;
      this.prefiereOrganico=prefiereOrganico;
      this.bajoEnAzucar=bajoEnAzucar;
      this.altoEnProteinas=altoEnProteinas;
    }

    

    public String getTipopostre() {
        return tipopostre;
    }

    public void setTipopostre(String tipopostre) {
        this.tipopostre = tipopostre;
    }
   
   

    public String getNivelactividad() {
        return nivelactividad;
    }


    public void setNivelactividad(String nivelactividad) {
        this.nivelactividad = nivelactividad;
    }


    public int getComidasaldia() {
        return comidasaldia;
    }


    public void setComidasaldia(int comidasaldia) {
        this.comidasaldia = comidasaldia;
    }



    public boolean isPrefiereOrganico() {
        return prefiereOrganico;
    }


    public void setPrefiereOrganico(boolean prefiereOrganico) {
        this.prefiereOrganico = prefiereOrganico;
    }


    public boolean isBajoEnAzucar() {
        return bajoEnAzucar;
    }


    public void setBajoEnAzucar(boolean bajoEnAzucar) {
        this.bajoEnAzucar = bajoEnAzucar;
    }

 
    public boolean isAltoEnProteinas() {
        return altoEnProteinas;
    }


    public void setAltoEnProteinas(boolean altoEnProteinas) {
        this.altoEnProteinas = altoEnProteinas;
    }
      
    
}

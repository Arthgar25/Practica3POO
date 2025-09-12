public class Jugador
{   
    //Cada jugador solo tendra un nombre y sus fichas.
    private int fichas = 0;
    private String nombre;
    
    //Los metodos solo seran para constructor, getters y setters
    public Jugador(String nombre){this.nombre = nombre;}
    
    public int getFichas(){return fichas;}
    
    public String getNombre(){return nombre;}
    
    public void setFichas(int fichas){this.fichas = fichas;}
    
    public void increaseFichas(){this.fichas++;}
    
    public void decreaseFichas(){this.fichas--;}
    
    public void duplicateFichas(){this.fichas*=2;}
}
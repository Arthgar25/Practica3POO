
/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jugador
{
    private int fichas = 0;
    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public int getFichas(){
        return fichas;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setFichas(int fichas){
        this.fichas = fichas;
    }
    
    public void increaseFichas(){
        this.fichas++;
    }
    
    public void decreaseFichas(){
        this.fichas--;
    }
    
    public void duplicateFichas(){
        this.fichas*=2;
    }
}
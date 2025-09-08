
/**
 * Write a description of class GanaleJuego here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GanaleJuego
{
    int turno = 1;
    boolean terminado = false;
    Jugador jugador;

    public GanaleJuego(){
        jugador = new Jugador(1);
    }

    public void turno(){
        if(terminado)return;
        jugador.lanzarDados();
        turno++;
        if(jugador.getFichas() >= 6 || turno >= 10)terminado = true;
    }
    
    public int getTurno(){
        return turno;
    }
    
    public int getFichasJugador(){
        return jugador.getFichas();
    }
    
    public int getIdJugador(){
        return jugador.getId();
    }
    
    public boolean juegoTerminado(){
        return terminado;
    }
    
    public char getResultado1(){
        return jugador.getResultado1();
    }
    
    public char getResultado2(){
        return jugador.getResultado2();
    }
}
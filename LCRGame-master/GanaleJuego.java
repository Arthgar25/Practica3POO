
/**
 * Write a description of class GanaleJuego here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GanaleJuego
{
    int turno = 0;
    boolean juegoTerminado = false;
    Jugador jugador;

    public GanaleJuego(){
        jugador = new Jugador(1);
    }

    public void turno(){
        if(juegoTerminado)return;
        jugador.lanzarDados();
        turno++;
        if(jugador.getFichas() >= 6 || turno >= 10)juegoTerminado = true;
    }

}
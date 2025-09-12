import java.util.*;

public class GanaleJuego {
    private DadoLCR dado1 = new DadoLCR();
    private DadoLCR dado2 = new DadoLCR();
    private int turno = 1;
    private boolean terminado = false;
    Jugador jugador;

    public GanaleJuego(){
        jugador = new Jugador("");
    }

    public void lanzarDados(){
        if(terminado) return;
        dado1.lanzar();
        dado2.lanzar();
        procesarResultados();
    }

    private void procesarResultados(){
        aplicarResultado(jugador, dado1.getValor());
        aplicarResultado(jugador, dado2.getValor());

        if(dado1.getValor() == 'C' || dado2.getValor() == 'C'){
            jugador.duplicateFichas();
        }

        if(jugador.getFichas() < 0) jugador.setFichas(0);

        if(jugador.getFichas() >= 6) terminado = true;
    }

    private void aplicarResultado(Jugador jugador, char resultado){
        switch(resultado){
            case 'L': jugador.decreaseFichas(); break;
            case 'R': jugador.decreaseFichas(); jugador.decreaseFichas(); break;
            case '*': jugador.increaseFichas(); break;
        }
    }

    public void passTurn(){
        turno++;
        if(turno >= 10) terminado = true; 
    }

    public int getTurno(){ return turno; }

    public boolean getTerminado(){ return terminado; }

    public char getResultadoDado1(){ return dado1.getValor(); }

    public char getResultadoDado2(){ return dado2.getValor();}
}
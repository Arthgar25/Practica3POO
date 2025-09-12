import java.util.*;

public class GanaleJuego {
    private DadoLCR dado1 = new DadoLCR();
    private DadoLCR dado2 = new DadoLCR();
    private int turno = 1;
    private boolean terminado = false;
    private int jugadorActual = 0;

    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public GanaleJuego(int cantidadDeJugadores, Scanner scnr){
        for(int i = 1; i <= cantidadDeJugadores; i++){
            System.out.print("Nombre del jugador " + i + ": ");
            String nombre = scnr.nextLine();
            jugadores.add(new Jugador(nombre));
        }
    }

    public void lanzarDados(){
        if(terminado) return;
        dado1.lanzar();
        dado2.lanzar();
        procesarResultados();
    }

    private void procesarResultados(){
        Jugador jugador = jugadores.get(jugadorActual);

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
        jugadorActual++;
        if(jugadorActual >= jugadores.size()){
            jugadorActual = 0;  
            turno++;
        }

        if(turno >= 10) terminado = true; 
    }

    public int getTurno(){ return turno; }

    public boolean getTerminado(){ return terminado; }

    public Jugador getJugadorActual(){ return jugadores.get(jugadorActual); }

    public List<Jugador> getJugadores(){ return new ArrayList<>(jugadores); } // copia defensiva

    public char getResultadoDado1(){ return dado1.getValor(); }

    public char getResultadoDado2(){ return dado2.getValor();}
}
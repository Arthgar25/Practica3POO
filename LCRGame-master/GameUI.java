import java.util.*;

public class GameUI {
    private GanaleJuego juego;

    public GameUI(){
        Scanner scnr = new Scanner(System.in);

        juego = new GanaleJuego();

        while(!juego.getTerminado()){
            System.out.println("========================");
            System.out.println("Turno: " + juego.getTurno());

            System.out.println("Ingresa 1 para lanzar dados");
            int userInput = scnr.nextInt();
            if(userInput == 1){
                juego.lanzarDados();
                mostrarResultadoDado("primer dado", juego.getResultadoDado1());
                mostrarResultadoDado("segundo dado", juego.getResultadoDado2());
                juego.passTurn();
            }
            System.out.println("Fichas del jugador: " + juego.jugador.getFichas());
        }

        System.out.println("Juego terminado!");
    }

    private void mostrarResultadoDado(String nombre, char valor){
        System.out.print("Resultado del " + nombre + ": " + valor);
        switch(valor){
            case 'L': System.out.println(", -1 ficha"); break;
            case 'R': System.out.println(", -2 fichas"); break;
            case '*': System.out.println(", +1 ficha"); break;
            case 'C': System.out.println(", fichas x2 (una sola vez)"); break;
            default: System.out.println("error"); break;
        }
    }
}
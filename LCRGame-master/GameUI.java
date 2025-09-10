import java.util.*;
/**
 * Write a description of class GameUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameUI
{
    private GanaleJuego juego;

    public GameUI(){
        Scanner scnr = new Scanner(System.in);
        int cantidad;

        System.out.print("Ingresa la cantidad de jugadores: ");
        cantidad = scnr.nextInt();
        scnr.nextLine();
        juego = new GanaleJuego(cantidad, scnr);
        
        while(!juego.getTerminado()){
            System.out.println("============================");
            System.out.println("Turno: " + juego.getTurno());
            System.out.println("Jugador actual: " + juego.getJugadorActual().getNombre());
            
            System.out.println("Ingresa 1 para lanzar dados");
            int userInput = scnr.nextInt();
            if(userInput == 1){
                juego.lanzarDados();
                mostrarResultadoDado("primer dado", juego.getResultadoDado1());
                mostrarResultadoDado("segundo dado", juego.getResultadoDado2());
                juego.passTurn();
            }
            
            for(Jugador jugador : juego.getJugadores()){
                System.out.println("Jugador " + jugador.getNombre() + " tiene " + jugador.getFichas() + " fichas.");
            }
        }
        System.out.println("Juego terminado!");
    }
    
    private void mostrarResultadoDado(String nombre, char valor){
        System.out.print("Resultado del " + nombre + ": " + valor);
        switch(valor){
            case 'L': 
                System.out.println(", -1 ficha"); 
                break;
            case 'R': 
                System.out.println(", -2 fichas"); 
                break;
            case '*': 
                System.out.println(", +1 ficha"); 
                break;
            case 'C': 
                System.out.println(", fichas x2 (una sola vez)"); 
                break;
            default: 
                System.out.println("error"); 
                break;
        }
    }
}
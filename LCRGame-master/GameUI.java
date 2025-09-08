import java.util.*;
/**
 * Write a description of class GameUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameUI
{
    GanaleJuego juego;
    Jugador jugador;
    ArrayList<Jugador> jugadores = new ArrayList<>();

    public GameUI(){
        juego = new GanaleJuego();
        Scanner scnr = new Scanner(System.in);
        int userInput;

        System.out.print("Ingresa la cantidad de jugadores: ");
        userInput = scnr.nextInt();

        for(int i = 1; i <= userInput; i++){
            jugador = new Jugador(i);
            jugadores.add(jugador);
        }

        do{
            System.out.println("========================================");
            for (Jugador jugador : jugadores) {
                System.out.println("----------------------------------------");
                System.out.println("Turno actual global: " + juego.getTurno());
                System.out.println("Jugador " + jugador.getId());
                System.out.println("Ingresa 1 para lanzar dados");
                userInput = scnr.nextInt();
                if(userInput == 1){
                    jugador.lanzarDados();
                    System.out.print("Resultado de primer dado: " + jugador.getResultado1());
                    switch(jugador.getResultado1()){
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
                    System.out.print("Resultado de segundo dado: " + jugador.getResultado2());
                    switch(jugador.getResultado2()){
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
                    System.out.println("Fichas de jugador " + jugador.getId() + ": " + jugador.getFichas());
                }
            }
            juego.turno++;
            if(juego.getTurno() >= 10 || jugador.getFichas() >= 6){
                System.out.println("Juego Terminado, jugador " + jugador.getId() + " es el ganador");
                juego.terminado = true;
            }
        }while(!juego.terminado());
    }
}
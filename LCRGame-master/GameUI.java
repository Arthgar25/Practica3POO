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

    public GameUI(){
        juego = new GanaleJuego();
        Scanner scnr = new Scanner(System.in);
        int userInput;

        System.out.println("Fichas del jugador: " + juego.getFichasJugador());
        System.out.println("Turno actual: " + juego.getTurno());

        do{
            System.out.println("Juego, ingresa 1 para lanzar dados");
            userInput = scnr.nextInt();

            if(userInput == 1){
                juego.turno();
                System.out.print("Resultado de primer dado: " + juego.getResultado1());
                switch(juego.getResultado1()){
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
                System.out.print("Resultado de segundo dado: " + juego.getResultado2());
                switch(juego.getResultado2()){
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

                System.out.println("Fichas del jugador: " + juego.getFichasJugador());
                System.out.println("Turno actual: " + juego.getTurno());
            }
        }while(!juego.juegoTerminado());
    }
}
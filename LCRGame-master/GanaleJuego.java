
/**
 * Write a description of class GanaleJuego here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GanaleJuego
{
    DadoLCR dado1, dado2;
    int fichas = 0;
    int turno = 0;
    boolean juegoTerminado = false;

    public GanaleJuego(){
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
    }

    public void lanzarDados(){

        if(juegoTerminado)return;

        dado1.lanzar();
        dado2.lanzar();

        switch(dado1.getValor()){
            case 'L':
                fichas--;
                break;
            case 'R':
                fichas--;
                fichas--;
                break;
            case '*':
                fichas++;
                break;
        }

        switch(dado2.getValor()){
            case 'L':
                fichas--;
                break;
            case 'R':
                fichas--;
                fichas--;
                break;
            case '*':
                fichas++;
                break;
        }

        if(dado1.getValor() == 'C' || dado2.getValor() == 'C'){
            fichas *= 2;
        }

        turno++;
        if(fichas >= 6 || turno >= 10)juegoTerminado = true;
    }
}
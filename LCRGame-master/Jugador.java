
/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jugador
{
    DadoLCR dado1;
    DadoLCR dado2;

    private int fichas = 0;
    private int id;

    public Jugador(int id){
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        this.id = id;
    }

    public void lanzarDados(){
        dado1.lanzar(); 
        dado2.lanzar();

        procesarResultados(dado1.getValor(), dado2.getValor());

    }

    private void procesarResultados(char resultado1, char resultado2){
        switch(resultado1){
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
        switch(resultado2){
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

        if(fichas<0) fichas = 0;

        if(dado1.getValor() == 'C' || dado2.getValor() == 'C'){
            fichas *= 2;
        }
    }
    
    public int getFichas(){
        return fichas;
    }
    
    public int getId(){
        return id;
    }
}
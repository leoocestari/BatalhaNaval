package pecas;

import tabuleiro.Tabuleiro;

import java.util.regex.Pattern;

public class Couracado extends Pecas{
    public Couracado(String cord, int tam){
        super(cord,4);
    }


    public void colocarPeca(String cord_inic, Tabuleiro m){
        String[] cord = cord_inic.split(Pattern.quote(","));
        int y = Integer.parseInt(cord[0]);
        int x = Integer.parseInt(cord[1]);

        for(int j = x; j<= (x+4)-1;j++) {
            m.inserTabuleiro(j,y,'C');
        }
    }
}

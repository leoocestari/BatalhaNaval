package pecas;

import tabuleiro.Tabuleiro;

import java.util.regex.Pattern;

public class Couracado extends Pecas {

    public Couracado(String cord, int tam) {
        super(cord, tam);
    }

    public void colocarPeca(String cord, Tabuleiro m){

        for(int j = x; j<= (x+4)-1;j++) {
            m.inserTabuleiro(j,y,'C');
        }


    }
}

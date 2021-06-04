package pecas;

import tabuleiro.Tabuleiro;

import java.util.regex.Pattern;

public class Pecas {
    private int tam;
    public String cord;

    public Pecas(){
        this.cord = null;
        this.tam = 0;
    }

    public Pecas(String cord, int tam){
        this.cord = cord;
        this.tam = tam;
    }

    public String cord(){
        return cord;
    }


    public Boolean tentarColocarpeca(String cord_inic,int tam_peca, Tabuleiro m){
        String[] cord = cord_inic.split(Pattern.quote(","));
        int y = Integer.parseInt(cord[0]);
        int x = Integer.parseInt(cord[1]);

        for(int i = y-1; i<= y+1; i++){
            for(int j = x-1; j<= (x + tam_peca+1);j++ ){
                if(i < 0) {
                    i = 0;
                }
                if(j < 0) {
                    j = 0;
                }
                if(j >= 15) {
                    i = 14;
                }
                if(m.pos(i, j) != '~'){
                    return false;
                }
            }
        }
        return true;
    }



    boolean acertouTiro(String[] cord) {
        for (String s : cord) {
            if (s.equals("~")) {
                return false;
            }
        }
        return true;
    }



/***
    public Boolean SeAtingida(){

    }
*/
}

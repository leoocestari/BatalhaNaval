
package pecas;

import tabuleiro.Tabuleiro;

import java.util.regex.Pattern;

public class Pecas {

    public String cord;


    public Pecas(String cord){
        this.cord = cord;
    }

    public String cord(){
        return cord;
    }


    public Boolean tentarColocarpeca(int[] cord_inic, char[][] m){

        int linha_antes = cord_inic[0]-1;

        int coluna_antes = cord_inic[1]-1;

        int linha_depois = cord_inic[0]+1;

        int coluna_depois = cord_inic[1]+1;

        if(linha_antes<0 || coluna_antes<0 || linha_depois>m.length  || coluna_depois>m[0].length){
            return false;
        }

        for(int i = linha_antes; i< linha_depois;i++){

            for(int j = coluna_antes;j<coluna_depois;j++){
                if(m[i][j]!='~'){
                    return false;
                }

            }

        }

        return true;
    }







/***
    public Boolean SeAtingida(){

    }
*/
}

import pecas.Aviao;
import pecas.Couracado;
import pecas.Destroier;
import tabuleiro.Tabuleiro;
import java.util.Scanner;


public class jogo {
    public static void main(String[] args){
        Tabuleiro tab = new Tabuleiro();

        Couracado couracado = new Couracado("7,7",4);
        Destroier destroier = new Destroier("9,9",2);

        Scanner teclado = new Scanner(System.in);

        String[] embarcacoes =
        ["couraçado", "destroier", "destroier", "avião", "avião", "submarino", "submarino", "submarino", "submarino"];

        for (int i = 0;i< embarcacoes.length;i++){
            System.out.println("Digite a coordenada inicial que deseja colocar o: " + embarcacoes[i]);

            String cord = teclado.next();

            switch(embarcacoes[i].indexOf()){
                case 0:
                    couracado.colocarPeca(cord);
                    break;
                case 1:
                    destroier.colocarPeca(cord);
                    break;
                case 2:
                    destroier.colocarPeca(cord);
                    break;
                case 3:
                    Aviao.colocarPeca(cord)            }


        }










        if(couracado.tentarColocarpeca(couracado.cord,4,tab)){
            couracado.colocarPeca("5,5",tab);
        }else{
            System.out.println("error");
        }
        if (couracado.tentarColocarpeca(couracado.cord, 4, tab)) {
                couracado.colocarPeca("5,2", tab);
        }else{
            System.out.println("error");
        }
        Tabuleiro.escrevaTabuleiro(tab);
    }



    boolean acertouTiro(String[] cord) {
        for (String s : cord) {
            if (s.equals("~")) {
                return false;
            }
        }
        return true;
    }


}

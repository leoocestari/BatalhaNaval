import pecas.Couracado;
import pecas.Destroier;
import tabuleiro.Tabuleiro;
import pecas.Pecas;

public class jogo {
    public static void main(String[] args){
        Tabuleiro tab = new Tabuleiro();

        Couracado couracado = new Couracado("7,7",4);
        Destroier destroier = new Destroier("9,9",2);




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
}

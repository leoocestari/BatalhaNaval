package pecas;

public class Aviao extends Pecas {


    public Aviao(String cord, int tam) {
        super(cord, tam);
    }

    public static boolean colocarPeca(char[][] m, String cord) {

        int [] posicao = {Integer.parseInt(cord.split(",")[0]),Integer.parseInt(cord.split(",")[1])};

        int[] posicao2 = {posicao[0]+1,posicao[1]+1};

        int[] posicao3 = {posicao[0],posicao[1]+2};



        if(tentarColocarpeca(posicao,m)){

            if(tentarColocarpeca(posicao2,m)){


                if(tentarColocarpeca(posicao3,m)){
                    return true;
                }

            }



        }


        return false;
    }

}

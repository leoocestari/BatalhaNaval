package tabuleiro;

public class Tabuleiro {
    public char[][] Tabuleiro;

    public Tabuleiro() {
        Tabuleiro = new char[15][15];

        for (int i = 0; i <= Tabuleiro.length - 1; i++) {
            for (int j = 0; j <= Tabuleiro[i].length - 1; j++) {
                Tabuleiro[i][j] = '~';
            }
        }

        for (char[] chars : Tabuleiro) {
            System.out.println();
            System.out.print("|");
            for (char aChar : chars) {
                System.out.print(aChar + "|");
            }
        }
    }

    public char pos(int posy, int posx){
        return Tabuleiro[posy][posx];
    }
    public int tam(Tabuleiro map){
        return Tabuleiro.length;
    }

    public void inserTabuleiro(int x, int y,char l){
        Tabuleiro[y][x] = l;
    }



    public static void escrevaTabuleiro(Tabuleiro map){
        System.out.println(" ");
        System.out.print("-----------------------------------------------");
        for (int i = 0; i < map.tam(map); i++) {
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < map.tam(map); j++) {
                System.out.print(map.pos(i,j) + "|");
            }
        }
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
    }


}

//        for(int i = 0; i<= tabuleiro.Tabuleiro.length-1; i++) {
//           for(int j = 0; j<= tabuleiro.Tabuleiro[i].length-1; j++) {
//                tabuleiro.Tabuleiro[i][j] = '~';
//            }
//        }
//    }
//}
//for(int i = 0; i < tabuleiro.Tabuleiro.length; i++) {
//            System.out.println("");
//            System.out.print("|");
//            for (int j = 0; j < tabuleiro.Tabuleiro[i].length; j++) {
//                System.out.print(tabuleiro.Tabuleiro[i][j] + "|");
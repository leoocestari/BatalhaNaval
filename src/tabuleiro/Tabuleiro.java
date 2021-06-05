package tabuleiro;

import pecas.Atingida;
import pecas.Peca;
import pecas.Vazio;

import java.util.Arrays;

public class Tabuleiro {
    //16 por 16 pq não será permitido colocar embarcações nas extremidades
    private Peca[][] ConfigJogo = new Peca[16][16];

    public Tabuleiro(){
        //Enchendo o array de vazios
        for (int i = 0; i < ConfigJogo.length; i++) for (int j = 0; j < ConfigJogo[i].length; j++) ConfigJogo[i][j] = new Vazio(new int[]{i},new int[]{j});
    }

    //getters e setters
    public void setConfigJogo(Peca[][] configJogo) { ConfigJogo = configJogo; }

    public Peca[][] getConfigJogo() { return ConfigJogo; }

    public Peca GetPeca(int x, int y){ return ConfigJogo[y][x]; }
    //-----------------------

    public boolean EstaVazio(int x, int y){
        return ConfigJogo[x][y] instanceof Vazio;
    }


    public void InserirPeca(Peca p){
        int[] x = p.getX(), y = p.getY();
        for (int i = 0; i < x.length; i++) ConfigJogo[y[i]][x[i]] = p;
    }

    public boolean CasaEhLadosVazios(Peca p){
        int[] x = p.getY(), y = p.getX();
        for (int i = 0; i < x.length; i++){
            if(!(ConfigJogo[x[i]][y[i]] instanceof Vazio) || ConfigJogo[x[i]][y[i]] instanceof Atingida) return false;
            //Testando se as casas do lado em x estão vazias
            if(!(ConfigJogo[x[i]][y[i] - 1] instanceof Vazio && ConfigJogo[x[i]][y[i] + 1] instanceof Vazio)) return false;
            //Testando se as casas do lado em y estão vazias
            if(!(ConfigJogo[x[i] - 1][y[i]] instanceof Vazio && ConfigJogo[x[i] + 1][y[i]] instanceof Vazio)) return false;
            //Testando se as diagonais estão vazias
            if(!(ConfigJogo[x[i] - 1][y[i] - 1] instanceof Vazio && ConfigJogo[x[i] - 1][y[i] + 1] instanceof Vazio)) return false;
            if(!(ConfigJogo[x[i] + 1][y[i] - 1] instanceof Vazio && ConfigJogo[x[i] + 1][y[i] + 1] instanceof Vazio)) return false;
        }

        return true;
    }
}

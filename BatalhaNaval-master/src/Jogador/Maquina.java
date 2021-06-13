package Jogador;

import Jogo.Jogada;
import ed.nseq.Pilha;
import pecas.*;

import java.util.ArrayList;

public class Maquina extends Jogador{
    protected String nome = "computador";

    public Maquina() {this.ColocarPecas();}

    public boolean TentarAtirar(Peca[][] ConfigJogo){
        int x,y;

        do{
            x = (int) (1 + (Math.random() * 13));
            y = (int) (1 + (Math.random() * 13));

        }while (this.JaAtirou(x, y));

        return this.Atirar(ConfigJogo,x,y);
    }

    public boolean JaAtirou(int x,int y){
        for (int i = 0; i<= this.historico.comprimento()-1;i++){
            Jogada jogada = (Jogada) historico.elemento(i);
            if (jogada.getX() == x && jogada.getY() == y) return true;
        }
        return false;
    }

    public void ColocarPecas(){
        int x[],y[];
        Peca p;

        //colocando encouraçado
        do{
            int xInicial = (int) (1 + (Math.random() * 11))  ;
            x = new int[]{xInicial,xInicial + 1,xInicial + 2,xInicial + 3};

            int yFinal = (int) (1 + (Math.random() * 11))  ;
            y = new int[]{yFinal,yFinal,yFinal,yFinal};

            p = new Encouracado(x,y);
        }while(!(p.EstaColocadoCorretamente() && this.t.CasaEhLadosVazios(p)));
        this.t.InserirPeca(p);

        //Colocando destroyers
        for (int i = 0; i < 2; i++) {
            do{
                int xInicial = (int) (1 + (Math.random() * 13))  ;
                x = new int[]{xInicial,xInicial + 1};

                int yFinal = (int) (1 + (Math.random() * 13))  ;
                y = new int[]{yFinal,yFinal};

                p = new Destroyer(x,y);
            }while(!(p.EstaColocadoCorretamente() && this.t.CasaEhLadosVazios(p)));
            this.t.InserirPeca(p);
       }

       //Colocando Submarinos
        for (int i = 0; i < 4; i++) {
            do{
                int xFinal = (int) (1 + (Math.random() * 14))  ;
                x = new int[]{xFinal};

                int yFinal = (int) (1 + (Math.random() * 14))  ;
                y = new int[]{yFinal};

                p = new Submarino(x,y);
            }while(!(p.EstaColocadoCorretamente() && this.t.CasaEhLadosVazios(p)));
            this.t.InserirPeca(p);
        }

        //Colocando Aviões
        for (int i = 0; i < 3; i++) {
            do{
                int xInicial = (int) (1 + (Math.random() * 12))  ;
                x = new int[]{xInicial,xInicial + 1,xInicial + 2};

                int yInicial = (int) (1 + (Math.random() * 12))  ;
                y = new int[]{yInicial,yInicial + 1,yInicial};

                p = new Aviao(x,y);
            }while(!(p.EstaColocadoCorretamente() && this.t.CasaEhLadosVazios(p)));
            this.t.InserirPeca(p);
        }
    }
}

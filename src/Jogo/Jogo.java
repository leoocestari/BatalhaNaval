//Classe responsável pela interação com o usuário e printagem dos elementos
package Jogo;

import Jogador.*;
import pecas.*;
import ed.nseq.Lista;
import ed.nseq.Fila;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Jogo {
    static Scanner input = new Scanner(System.in);
    private final Lista nomes = new Lista();
    private final Fila tiros = new Fila();
    private final int[] tamanhos = new int[]{4};
    //private final String[] nomes = new String[]{"Encouraçado","Destroyer","Destroyer","Avião","Avião","Avião","Submarino","Submarino","Submarino","Submarino"};
    private final Jogador jogador = new Jogador();
    private final Maquina maquina = new Maquina();

    public Jogo() {this.InteracaoComOhUsuario();}

    public void InteracaoComOhUsuario(){
        fillLista();
        //fillLista();
        System.out.println("Olá,bem vindo ao jogo de batalha naval.");
        System.out.println("Para começar, vamos posicionar suas peças");
        this.PedirCoordenadasPecas();

        do {
            //uma rodada do jogador com o mapa da máquina
            this.PedirCoordenadasTiro(this.maquina.getTabuleiro().getConfigJogo(), this.jogador);
            if((this.jogador.Perdeu()) || (this.maquina.Perdeu())) break;

            System.out.println("O tabuleiro da máquina está assim: ");
            this.PrintarTabuleiroMascarado(this.maquina.getTabuleiro().getConfigJogo());

            System.out.println("A máquina vai jogar agora(pressione enter para continuar...)");
            input.next();

            //uma rodada da máquina com o mapa do jogador
            if (this.maquina.TentarAtirar(this.jogador.getTabuleiro().getConfigJogo()))
                System.out.println("A máquina acertou");
            else System.out.println("A máquina errou");
            if((this.jogador.Perdeu()) || (this.maquina.Perdeu())) break;

            System.out.println("O seu tabuleiro está assim: ");
            this.PrintarTabuleiro(this.jogador.getTabuleiro().getConfigJogo());
        }while (true);

        if (this.jogador.Perdeu()) System.out.println("Você perdeu! Fim de jogo!");
        else System.out.println("O computador perdeu!Parabéns, você ganhou!");
    }

    private void PedirCoordenadasPecas(){
        int[] x;
        int[] y;
        Peca p;
        for (int i = 0; i < this.tamanhos.length; i++) {
            int tamanho = this.tamanhos[i];
            //String nome = nomes[i];
            String nome = (String) nomes.elemento(i);
            x = new int[tamanho];
            y = new int[tamanho];
            while (true) {
                for (int j = 0; j < tamanho; j++) {
                    System.out.println("Digite o valor " + (j + 1) + " de x do " + nome);
                    x[j] = input.nextInt();
                    System.out.println("Digite o valor " + (j + 1) + " de y do " + nome);
                    y[j] = input.nextInt();

                    //Valores inválidos não podem ser aceitos
                    if(x[j] <= 0 || x[j] >= 14 || y[j] <= 0 || y[j] >= 14) break;
                }

                switch (tamanho) {
                    case 4 -> p = new Encouracado(x, y);
                    case 2 -> p = new Destroyer(x, y);
                    case 1-> p = new Submarino(x,y);
                    default -> p = new Aviao(x, y);
                }

                if(p.EstaColocadoCorretamente() && this.jogador.getTabuleiro().CasaEhLadosVazios(p)) break;
                System.out.println("Você colocou a peça incorretamente ou colocou em cima de outra. Tente novamente.");
            }
            this.jogador.getTabuleiro().InserirPeca(p);
            System.out.println("Mudança efetuada com sucesso. O seu tabuleiro está assim no momento:");
            PrintarTabuleiro(this.jogador.getTabuleiro().getConfigJogo());
        }
    }

    private void PedirCoordenadasTiro(Peca[][] ConfigJogo,Jogador jogador){
        for(int oi = 0; oi <= 2; oi++) {
            System.out.println("Digite a coordenada de x para atirar na máquina");
             String x = Integer.toString(input.nextInt());
            System.out.println("Digite a coordenada de y para atirar ná máquina");
            String y = Integer.toString(input.nextInt());
            String tiro = x +","+ y;

            tiros.adicionar(tiro);
        }

        for(int i = 0; i <= 2; i++) {
            String shot = (String) tiros.elemento(i);
            String cord[] = shot.split(Pattern.quote(","));
            int x = Integer.parseInt(cord[0]);
            int y = Integer.parseInt(cord[1]);
            System.out.println(x +" - " + y);

            if (jogador.Atirar(ConfigJogo, x, y)) System.out.println("Parabéns,você acertou uma peça ");
            else System.out.println("Que pena, você errou");

        }

        for(int i = 0; i<= tiros.comprimento()+1;i++){
            tiros.remover();
        }

    }

    private void PrintarTabuleiro(Peca[][] ConfigJogo){
        for (Peca[] configJogo : ConfigJogo) {
            for (Peca jogo : configJogo) System.out.print(jogo.getLetra() + "|");
            System.out.println("");
        }
    }

    private void PrintarTabuleiroMascarado(Peca[][] ConfigJogo){
        for (Peca[] configJogo : ConfigJogo) {
            for (Peca jogo : configJogo) {
                if (jogo.getLetra() != 'X') System.out.print("?|");
                else System.out.print(jogo.getLetra() + "|");
            }
            System.out.println("");
        }
    }

    private void fillLista(){
        for(int tamanho: tamanhos){
            switch (tamanho) {
                case 4 -> nomes.adicionar("Encouraçado");
                case 2 -> nomes.adicionar("Destroyer");
                case 3 -> nomes.adicionar("Avião");
                case 1 -> nomes.adicionar("Submarino");
            }
        }
    }
}

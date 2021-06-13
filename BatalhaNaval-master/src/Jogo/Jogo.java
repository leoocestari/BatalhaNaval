//Classe responsÃ¡vel pela interaÃ§Ã£o com o usuÃ¡rio e printagem dos elementos
package Jogo;

import pecas.*;
import Jogador.*;
import tabuleiro.*;
import ed.nseq.Lista;
import ed.nseq.Fila;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Jogo {
    static Scanner input = new Scanner(System.in);
    private final Lista nomes = new Lista();
    private final Fila tiros = new Fila();
    private final int[] tamanhos = new int[]{4,2,2,3,3,3,1,1,1,1};
    //private final String[] nomes = new String[]{"EncouraÃ§ado","Destroyer","Destroyer","AviÃ£o","AviÃ£o","AviÃ£o","Submarino","Submarino","Submarino","Submarino"};
    private final Jogador jogador = new Jogador();
    private final Maquina maquina = new Maquina();

    public Jogo() {this.InteracaoComOhUsuario();}

    public void InteracaoComOhUsuario(){
        fillLista();
        //fillLista();
        System.out.println("OlÃ¡,bem vindo ao jogo de batalha naval.");
        System.out.println("Para comeÃ§ar, vamos posicionar suas peÃ§as");
        this.PedirCoordenadasPecas();

        do {
            //uma rodada do jogador com o mapa da mÃ¡quina
            this.PedirCoordenadasTiro(this.maquina.getTabuleiro().getConfigJogo(), this.jogador);
            if((this.jogador.Perdeu()) || (this.maquina.Perdeu())) break;

            System.out.println("O tabuleiro da mÃ¡quina estÃ¡ assim: ");
            this.PrintarTabuleiroMascarado(this.maquina.getTabuleiro().getConfigJogo());

            System.out.println("A mÃ¡quina vai jogar agora(pressione enter para continuar...)");
            input.next();

            //uma rodada da mÃ¡quina com o mapa do jogador
            if (this.maquina.TentarAtirar(this.jogador.getTabuleiro().getConfigJogo()))
                System.out.println("A mÃ¡quina acertou");
            else System.out.println("A mÃ¡quina errou");
            if((this.jogador.Perdeu()) || (this.maquina.Perdeu())) break;

            System.out.println("O seu tabuleiro estÃ¡ assim: ");
            this.PrintarTabuleiro(this.jogador.getTabuleiro().getConfigJogo());
        }while (true);

        if (this.jogador.Perdeu()) System.out.println("VocÃª perdeu! Fim de jogo!");
        else System.out.println("O computador perdeu!ParabÃ©ns, vocÃª ganhou!");
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
            int C1, C2;

                System.out.println("Digite o valor de x do " + nome);
                C1 = input.nextInt();
                System.out.println("Digite o valor de y do " + nome);
                C2 = input.nextInt();

                //Valores invÃ¡lidos nÃ£o podem ser aceitos
                if(C1 <= 0 || C1 >= 14 || C1 <= 0 || C2 >= 14) break;
                
            /*    do { */
                while(true) {
                    for (int j = 0; j < tamanho; j++) {
                        x[j]=C1+j;
                        y[j]=C2;
                }
                 
                switch (tamanho) {
                    case 4 -> p = new Encouracado(x, y);
                    case 2 -> p = new Destroyer(x, y);
                    case 1-> p = new Submarino(x,y);
                    default -> p = new Aviao(x, y);
                }
                
                if (x[x.length-1] >= 14) {
                	System.out.println("Você colocou as peças incorretamente!");
                }else this.jogador.getTabuleiro().InserirPeca(p); break;
                 
                 
                 
            /*   }while(true); /*


                /*
                if(p.EstaColocadoCorretamente() && this.jogador.getTabuleiro().CasaEhLadosVazios(p)) break;
                System.out.println("VocÃª colocou a peÃ§a incorretamente ou colocou em cima de outra. Tente novamente.");
                */
                
            }
            
            System.out.println("MudanÃ§a efetuada com sucesso. O seu tabuleiro estÃ¡ assim no momento:");
            PrintarTabuleiro(this.jogador.getTabuleiro().getConfigJogo());
        }
    }

    private void PedirCoordenadasTiro(Peca[][] ConfigJogo,Jogador jogador){
        for(int oi = 0; oi <= 2; oi++) {
            System.out.println("Digite a coordenada de x para atirar na mÃ¡quina");
             String x = Integer.toString(input.nextInt());
            System.out.println("Digite a coordenada de y para atirar nÃ¡ mÃ¡quina");
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

            if (jogador.Atirar(ConfigJogo, x, y)) System.out.println("ParabÃ©ns,vocÃª acertou uma peÃ§a ");
            else System.out.println("Que pena, vocÃª errou");

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
                case 4 -> nomes.adicionar("EncouraÃ§ado");
                case 2 -> nomes.adicionar("Destroyer");
                case 3 -> nomes.adicionar("AviÃ£o");
                case 1 -> nomes.adicionar("Submarino");
            }
        }
    }
}

package Jogador;

import Jogo.Jogada;
import pecas.Atingida;
import pecas.Peca;
import pecas.Vazio;
import tabuleiro.Tabuleiro;

import java.util.ArrayList;

public class Jogador {
    protected ArrayList<Jogada> jogadas = new ArrayList<>();
    protected Tabuleiro t = new Tabuleiro();
    protected String nome = "jogador";

    public String getNome() { return nome; }

    public Tabuleiro getTabuleiro() { return t; }

    private void AdicionarJogada(Peca p, int x, int y){ jogadas.add(new Jogada(p,x,y)); }

    /*devolve a última jogada e a deleta do array de jogadas*/
    public Jogada ResetarUltimaJogada(){
        Jogada UltimaJogada = jogadas.get(jogadas.size() - 1);
        jogadas.remove(jogadas.get(jogadas.size() - 1));

        return UltimaJogada;
    }

    //Tentar Atirar, salva a jogada e adiciona a casa como marcada se conseguir
    public boolean Atirar(Peca[][] ConfigJogo, int x,int y){
        if((x > 15 || x < 0) || (y > 15 || y < 0) || ConfigJogo[y][x] instanceof Atingida) return false;
        boolean CasaEhVazia = ConfigJogo[y][x] instanceof Vazio;
        AdicionarJogada(ConfigJogo[y][x],x,y);
        ConfigJogo[y][x] = new Atingida(new int[]{x},new int[]{y});
        if (CasaEhVazia) return false;
        return true;
    }

    //Função responsável por indicar se um jogador perdeu ou não
    /*Se todas as instâncias do tabuleiro forem Atingido ou vazio
    quer dizer que o jogador não tem mais peças e perdeu*/
    public boolean Perdeu(){
        Peca[][] ConfigJogo = this.t.getConfigJogo();
        for (Peca[] configJogo : ConfigJogo) for (Peca jogo : configJogo) if(!(jogo instanceof Vazio) && !(jogo instanceof Atingida)) return false;

        return true;
    }
}

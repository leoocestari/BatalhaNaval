package Jogo;

import pecas.Peca;

public class Jogada {
    private Peca pecaAcertada;
    private int x;
    private int y;

    public int getX() { return x; }

    public int getY() { return y; }

    public Jogada(Peca peca, int x, int y){
        this.pecaAcertada = peca;
        this.x = x;
        this.y = y;
    }
}

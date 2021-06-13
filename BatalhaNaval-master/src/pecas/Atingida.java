package pecas;

public class Atingida extends Peca{
    public Atingida(int[] x, int[] y){ super(x,y,1,'X'); }

    public boolean EstaColocadoCorretamente() { return this.x.length == 1 && this.y.length == 1 && this.tamanho == 1; }
}

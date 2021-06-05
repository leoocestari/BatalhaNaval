package pecas;
//Já que nosso sistema cada espaço vazio se comporta como uma peça, o trataremos como uma
public class Vazio extends Peca{
    public Vazio(int[] x, int[] y){ super(x,y,1,'~'); }

    public boolean EstaColocadoCorretamente() { return this.x.length == 1 && this.y.length == 1 && this.tamanho == 1; }
}

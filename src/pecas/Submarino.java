package pecas;

public class Submarino extends Peca{
    public Submarino(int[] x, int[] y){ super(x,y,1,'S'); }

    /*método específico para avaliar:
    -Se x e y tem o mesmo tamanho do navio
    */
    public boolean EstaColocadoCorretamente(){
        return (this.CoordenadasSaoValidas() && this.x.length == 1 && this.y.length == 1 && this.tamanho == 1);
    }
}

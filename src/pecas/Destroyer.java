package pecas;

public class Destroyer extends Peca{
    public Destroyer(int[] x, int[] y){ super(x,y,2,'D'); }

    /*método específico para avaliar:
    -Se x e y tem o mesmo tamanho do navio
    -Se todos valores de y são igual(totalmente horizontal)
    */
    public boolean EstaColocadoCorretamente(){
        return (this.CoordenadasSaoValidas() && this.TodosValoresIguais(this.y)) && (this.x.length == 2 && this.y.length == 2);
    }
}

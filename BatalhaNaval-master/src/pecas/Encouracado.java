package pecas;

public class Encouracado extends Peca {
    public Encouracado(int[] x, int[] y){ super(x,y,4,'E'); }

    /*método específico para avaliar:
    -Se x e y tem o mesmo tamanho do navio
    -Se todos valores de y são igual(totalmente horizontal)
    */
    public boolean EstaColocadoCorretamente(){
        return (this.CoordenadasSaoValidas() && this.TodosValoresIguais(this.y)) && (this.x.length == 4 && this.y.length == 4);
    }
}

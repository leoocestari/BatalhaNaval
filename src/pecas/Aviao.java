package pecas;

public class Aviao extends Peca{
    public Aviao(int[] x, int[] y){ super(x,y,3,'A'); }

    /*método específico para avaliar:
    -Se x e y tem o mesmo tamanho do navio
    -Se todos valores de y são igual(totalmente horizontal)
    -O avião tem um método de avaliar coordenada própria, devido a sua colocação diferente
    */
    public boolean EstaColocadoCorretamente(){
        return (this.CoordenadasSaoValidas()) && (this.x.length == 3 && this.y.length == 3);
    }

    @Override
    protected boolean CoordenadasSaoValidas() {
        //Se o primeio e o último elemento não estiverem no mesmo y, esta errado
        if(this.y[0] != this.y[2]) return false;
        //Se o último elemento - o primeiro na tiver uma distancia de 2, está errado
        if(!(this.x[2] - this.x[0] == 2)) return false;
        //Se o elemento do meio não estiver uma coluna abaixo ou acima dos outros 2, está errado
        if(!(x[0] + 1 == x[1] && (y[0] + 1 == y[1] || y[0] - 1 == y[1]))) return false;

        return true;
    }
}

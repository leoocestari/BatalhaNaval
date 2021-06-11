package pecas;

abstract public class Peca {
    protected final int[] x;
    protected final int[] y;
    protected final int tamanho;
    protected final char letra;

    public Peca(int[] x, int[] y, int tamanho,char letra){
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        this.letra = letra;
    }

    //getters e setters
    public int[] getX() { return x; }

    public int[] getY() { return y; }

    public char getLetra() { return letra; }
    //-----------------------------

    public abstract boolean EstaColocadoCorretamente();

    /*método geral para avaliar:
    -Se x e y tem o mesmo número de coordenadas
    -Se as coordenadas estão no tabuleiro
    -Se as coordenadas não pulam de um lado do tubuleiro para o outro (ex:14,15,1)
    -Se Todos os elementos são consecutivos
    */
    protected boolean CoordenadasSaoValidas(){
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) if(i > 0) if (!(x[i] - x[i -1] == 1)) return false;
        if(x[0] > x[x.length -1] || y[0] > y[y.length -1]) return false;

        return true;
    }

    protected boolean TodosValoresIguais(int[] array){
        for (int j : array) if (!(j == array[0])) return false;
        return true;
    }
}

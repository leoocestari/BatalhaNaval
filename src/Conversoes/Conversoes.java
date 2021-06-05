package Conversoes;

public class Conversoes {
    private static final char[] letras = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static char NumParaLetra(int n){
        return Conversoes.letras[n];
    }

    public static int LetraParaNumero(char l){
        for (int i = 0; i < Conversoes.letras.length; i++) if (Conversoes.letras[i] == l) return i;
        return 0;
    }
}

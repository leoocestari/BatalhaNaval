package pecas;

import java.util.regex.Pattern;

public class Destroier extends Pecas {

    public Destroier(String cord){
        super(cord,2);
    }

    public void colocarPeca(String cord_inic, Tabuleiro m){
        String[] cord = cord_inic.split(Pattern.quote(","));

        int y = Integer.parseInt(cord[0]);
        int x = Integer.parseInt(cord[1]);

        for(int j = x; j<= (x+2)-1;j++) {
            m.inserTabuleiro(j,y,'D');

        }
    }

}

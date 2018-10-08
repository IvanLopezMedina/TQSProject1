package HundirFlota;
import java.util.*;

public class Tablero {
    public int[][] Matriz;

    public Tablero (){
        this.Matriz = new int[5][5];
        for(int f=0;f<Matriz.length;f++) {
            for(int c=0;c<Matriz[f].length;c++) {
                Matriz[f][c]=0;
            }
    }

    Tablero tab = new Tablero();
    System.out.println(tab.MatrizSize(this));
    }

    private int MatrizSize(Tablero t) {
        return t.Matriz.length;
    }
}
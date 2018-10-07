package HundirFlota;
import java.util.*;

public class Tablero {
    int[][] Matriz;

    public Tablero (){
        this.Matriz = new int[5][5];
        for(int f=0;f<Matriz.length;f++) {
            for(int c=0;c<Matriz[f].length;c++) {
                Matriz[f][c]=0;
            }
    }

    public int MatrizSize(){
        return this.Matriz.length;
    }

    Tablero tab = new Tablero();

}
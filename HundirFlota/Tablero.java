package HundirFlota;
import org.jetbrains.annotations.Contract;

import java.util.*;

public class Tablero {
    private int[][] Matriz;
    private int size;
    public Tablero() {
        this.Matriz = new int[5][5];
        for (int f = 0; f < Matriz.length; f++) {
            for (int c = 0; c < Matriz[f].length; c++) {
                Matriz[f][c] = 0;
                //System.out.println(Matriz[f][c]);
            }
        }
    }

    public boolean MatrizSize(double size) {
        if (this.Matriz.length == size){
            return true;
        }else{
            return false;
        }

    }
}


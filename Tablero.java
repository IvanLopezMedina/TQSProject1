import java.util.*;

public class Tablero {
    private int[][] matriz;
    
    public Tablero() {
    	this.matriz = new int[9][9];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
            	matriz[f][c] = 0;
            }
        }
    }

    
    public int[][] getMatriz(){
    	return this.matriz;
    }
    
    
    public void setValorCasilla(int x, int y) {
    	matriz[x][y] = 1;
    }
}


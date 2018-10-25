import java.util.*;

public class Tablero {
    private int[][] matriz;
    
    /**
     * Nomenclatura valores matriz
     * 0 = agua; 1 = tocado; 2 = hundido; 
     * 3 = agua_init; 4 = barco_init;
     * 
     */
    public Tablero() {
    	this.matriz = new int[9][9];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
            	matriz[f][c] = 3;
            }
        }
    }

    
    public int[][] getMatriz(){
    	return this.matriz;
    }
    
    
    public void setValorCasilla(int x, int y) {
    	matriz[x][y] = 1;
    }
    
    public boolean setBarco(Barco b, int x, int y, char orientacion) {
    	if (orientacion == 'h') {
    		if (comprobarPosicionBarco(b.getTamano(), x, y, orientacion)) {
    			int x_init = x;
    			while (x_init < x+b.getTamano()) {
    				matriz[x][y] = 4;
    				x_init++;
    			}
    		}else return false;
    	}
    	
    	if (orientacion == 'v') {
    		if (comprobarPosicionBarco(b.getTamano(), x, y, orientacion)) {
    			int y_init = y;
    			while (y_init < y+b.getTamano()) {
    				matriz[x][y] = 4;
    				y_init++;
    			}
    		} else return false;
    	}
    	
    	return true;
    }
    
    public boolean comprobarPosicionBarco(int tamano, int x, int y, int orientacion) {
    	if (orientacion == 'h') {
    		int x_init = x;
	    	while (x_init < x+tamano) {
	    		if (matriz[x][y] == 4) {
	    			System.out.println("Error insertando el barco. Posicion ocupada");
	    			return false;
	    		}
	    		x_init++;
			}
    	}
    	
    	if (orientacion == 'v') {
    		int y_init = y;
	    	while (y_init < y+tamano) {
				
	    		if (matriz[x][y] == 4) {
	    			System.out.println("Error insertando el barco. Posicion ocupada");
	    			return false;
	    		}
	    		y_init++;
			}
    	}
    	
    	return true;   
    }
}


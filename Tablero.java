import java.util.*;

public class Tablero {
    private int[][] matriz;
    int MAX_FILA = 9;
    int MAX_COLUMNA = 9;
	boolean result;
    
    /**
     * Nomenclatura valores matriz
     * 0 = agua; 1 = tocado; 2 = hundido; 
     * 3 = agua_init; 4 = barco_init;
     * 
     */
    public Tablero() {
    	this.matriz = new int[MAX_FILA][MAX_COLUMNA];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
            	matriz[f][c] = 3;
            }
        }
    }
    
    public int[][] getMatriz(){
    	return this.matriz;
    }

    public static void imprimirTablero(Tablero t){

	}
    
    public void setValorCasilla(int x, int y) {
    	matriz[x][y] = 1;
    }
    
    public boolean setBarco(Barco b, int x, int y, char orientacion) {
    	result = true;
    	if (orientacion == 'h') {
    		if (comprobarPosicionBarco(b.getTamano(), x, y, orientacion)) {
    			int x_init = x;
    			while (x < x_init+b.getTamano()) {
    				matriz[x][y] = 4;
    				x++;
    			}
    		}else result = false;
    	}
    	
    	if (orientacion == 'v') {
    		if (comprobarPosicionBarco(b.getTamano(), x, y, orientacion)) {
    			int y_init = y;
    			while (y < y_init+b.getTamano()) {
    				matriz[x][y] = 4;
    				y++;
    			}
    		} else result = false;
    	}
    	return result;
    }
    
    public boolean comprobarPosicionBarco(int tamano, int x, int y, int orientacion) {
    	if (orientacion == 'h') {
    		int x_init = x;
    		
    		if (x_init + tamano > 8) {
    			return false;
    		}else {
    			while (x < x_init+tamano) {
    	    		if (matriz[x][y] == 4) {
    	    			System.out.println("Error insertando el barco. Posicion ocupada");
    	    			result = false;
    	    		}
    	    		x++;
    			}
    		}
	    	
    	}
    	
    	if (orientacion == 'v') {
    		
    		int y_init = y;
    		if (y_init + tamano > 8) {
    			return false;
    		}else {
    			while (y < y_init+tamano) {
    	    		if (matriz[x][y] == 4) {
    	    			System.out.println("Error insertando el barco. Posicion ocupada");
    	    			result = false;
    	    		}
    	    		y++;
    			}
    		}
	    	
    	}
    	
    	return result;   
    }
}


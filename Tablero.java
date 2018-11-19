import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class Tablero {
    private int[][] matriz;
    int MAX_FILA = 9;
    int MAX_COLUMNA = 9;
	boolean result;
	protected Collection<Barco> barcos = new ArrayList();
    
    /**
     * Nomenclatura valores matriz
     * 0 = agua; 1 = tocado; 2 = hundido; 
     * 3 = agua_init; 4 = barco_init;
     */
    public Tablero() {
    	this.matriz = new int[MAX_FILA][MAX_COLUMNA];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
            	matriz[f][c] = 3;
            }
        }
    }
    
    public Collection<Barco> getBarcos() {
    	return this.barcos;
    }
    
    public boolean barcoValido(String nombre) {
    	boolean result;
    	if (nombre.matches("Patrullero") || 
			nombre.matches("Submarino") || 
			nombre.matches("Acorazado") || 
			nombre.matches("Portaaviones")) {
    		result = true;
    	}else {
    		result = false;
    	}
    	return result;
    }
    
    public void setBarcos(Barco b) {
    	if (barcoValido(b.getNombre())) this.barcos.add(b);
    }
    
    public int getMatrizValor(int x, int y){
    	return this.matriz[x][y];
    }
    public int[][] getMatriz(){
    	return this.matriz;
    }
    
   public void setMatrizValor(int x, int y, int valor) {
	   this.matriz[x][y] = valor;
   }

    public void imprimirTablero(){
		for(int i=0; i<matriz.length;i++){
			for(int j=0; j<matriz.length; j++){
				if (matriz[i][j] == 3 ||matriz[i][j] == 4) {
					System.out.print("_" + "\t");
				}
				if (matriz[i][j] == 0) {
					System.out.print("o" + "\t");
				}
				if (matriz[i][j] == 1) {
					System.out.print("t" + "\t");		
				}
				if (matriz[i][j] == 2) {
					System.out.print("x" + "\t");
				}
				
			}
			System.out.println("\n");
		}
	}
	public Barco getBarco(int x, int y){
    	Barco barc = null;
		for(Barco b: barcos){
			int[] posicion = b.getPosicionBarco();
			if(b.getOrientacion() == 'h') {
				int[] posicionHorizontal = b.getPosicionHorizontalBarco();
				for(int i=0; i<b.getTamano(); i++){
					if (posicion[0] == x && posicionHorizontal[i] == y) {
						barc = b;
						i=1000;
					}
				}

			}else if(b.getOrientacion() == 'v'){
				int[] posicionVertical = b.getPosicionVerticalBarco();
				for(int i=0; i<b.getTamano(); i++){
					if (posicionVertical[i] == x && posicion[1] == y) {
						barc = b;
						i=1000;
					}
				}
			}
		}
		return barc;
	}
    
    public void setValorCasilla(int x, int y) {
    	matriz[x][y] = 1;
    }
    
    public boolean setBarco(Barco b, int x, int y, char orientacion) {
    	result = true;
		b.setOrientacion(orientacion);
    	if (orientacion == 'v') {
    		if (comprobarPosicionBarco(b.getTamano(), x, y, orientacion)) {
    			System.out.println(b.getTamano());
    			int x_init = x;
				b.setPosicionBarco(x,y); //Barco guarda la posicion en la que ha sido colocado en el tablero
				setBarcos(b);
				
				int v = 0;
				while (x < x_init+b.getTamano()) {
					b.setPosicionVerticalBarco(v, x);
					System.out.println("Barco ok");
					matriz[x][y] = 4;
					x++;
					v++;
    			}
    		}else result = false;
    	}
    	
    	if (orientacion == 'h') {
    		if (comprobarPosicionBarco(b.getTamano(), x, y, orientacion)) {
    			int y_init = y;
				b.setPosicionBarco(x,y); //Barco guarda la posicion en la que ha sido colocado en el tablero
				setBarcos(b);
				
				int h = 0;
				while (y < y_init+b.getTamano()) {
					b.setPosicionHorizontalBarco(h,y);
					System.out.println("Barco ok");
					matriz[x][y] = 4;
    				y++;
    				h++;
    			}
    		} else result = false;
    	}
    	return result;
    }
    
    public boolean comprobarPosicionBarco(int tamano, int x, int y, int orientacion) {
    	if (orientacion == 'h') {
    		int y_init = y;
    		
    		if (y_init + tamano > 8) {
    			System.out.println("Error insertando el barco. Te sales");
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
    	
    	if (orientacion == 'v') {
    		
    		int x_init = x;
    		if (x_init + tamano > 8) {
    			System.out.println("Error insertando el barco. Te sales");
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
    	
    	return result;   
    }
    
    public void insertarBarcosAleatorios() {		
    	boolean validar = false;
    	char orientacion = 'h';
    	int x = 0,y = 0;
    	
    	//Creamos una partida

        /*Barco acorazado = new Barco("Acorazado");
        setBarco(acorazado,0,0,'v');
        Barco submarino = new Barco("Submarino");
        setBarco(submarino,1,1,'v');
        Barco patrullero = new Barco("Patrullero");
        setBarco(patrullero,2,2,'h');
        Barco portaaviones = new Barco("Portaaviones");
        setBarco(portaaviones,6,6,'h');*/
        
       
        
    	Barco patrullero = new Barco("Patrullero");
    	Barco acorazado = new Barco("Acorazado");
    	Barco submarino = new Barco("Submarino");
    	Barco portaaviones = new Barco("Portaaviones");
    	Collection<Barco> insertadorBarcos = new ArrayList();
    	
    	
    	insertadorBarcos.add(patrullero);
    	insertadorBarcos.add(acorazado);
    	insertadorBarcos.add(submarino);
    	insertadorBarcos.add(portaaviones);
    	
    	for (Barco b: insertadorBarcos) {
    		while (validar == false) {
        		x = (int) (Math.random() * 8) + 1;
        		y = (int) (Math.random() * 8) + 1;
        		if ((x % 2) == 0) {
        			orientacion = 'v';
        		}else orientacion = 'h';
        		
        		validar = setBarco(b, x, y, orientacion);
        	}
    		validar = false;;
    		System.out.println("Barco " + b.getNombre() + "en posicion " + b.getOrientacion() + " en X : " + x + "Y:" + y);
    	}

	}
    
}


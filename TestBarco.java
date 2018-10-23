import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBarco {
	Tablero t = new Tablero();
	int[][] m = t.getMatriz();

	@Test
	void test_InitBarco() {
		String[] listanombres = {"Submarino" , "Portaaviones" };
		
		for(int i = 0; i<listanombres.length; i++) {
			Barco b1 = new Barco(listanombres[i]);
			String nombre = b1.getNombre();
			
			if (nombre.matches("Submarino")) {
				assertEquals(b1.getTamaño(),3);
			}
			if (nombre.matches("Portaaviones")) {
				assertEquals(b1.getTamaño(),5);
			}		
		}
	}
}

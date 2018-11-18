import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class TestBarco{
	Tablero t = new Tablero();
	int[][] m = t.getMatriz();

	@Test
	void test_InitBarco() {
		String[] listanombres = {"Submarino" , "Portaaviones" };
		
		for(int i = 0; i<listanombres.length; i++) {
			Barco b1 = new Crucero(listanombres[i]);
			String nombre = b1.getNombre();
			
			if (nombre.matches("Submarino")) {
				assertEquals(b1.getTamano(),3);
			}
			if (nombre.matches("Portaaviones")) {
				assertEquals(b1.getTamano(),5);
			}		
		}
	}
}

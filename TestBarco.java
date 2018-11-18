import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class TestBarco {
	Tablero t = new Tablero();
	int[][] m = t.getMatriz();

	@Test
	void test_InitBarco() {
		Collection<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Submarino");
		listaNombres.add("Portaaviones");
		
		for(String iter: listaNombres) {
			Barco b1 = new Barco(iter);
			if (b1.getNombre().matches("Submarino")) {
				assertEquals(b1.getTamano(),3);
			}
			if (b1.getNombre().matches("Portaaviones")) {
				assertEquals(b1.getTamano(),5);
			}			
		}
	}
}

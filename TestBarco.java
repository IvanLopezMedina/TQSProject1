import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class TestBarco{
	Tablero t = new Tablero();
	int[][] m = t.getMatriz();

	@Test
	void test_instanciarBarco() {
        String[] listaNombres = {"Patrullero", "Submarino" , "Acorazado", "Portaaviones"};
        int[] tamanos = {2,3,4,5};
        Barco b;
        for (int i = 0; i < listaNombres.length; i++ ) {
        	b = new Barco(listaNombres[i]);
        	assertEquals(b.getTamano(),tamanos[i]);        	
        }

	}
}

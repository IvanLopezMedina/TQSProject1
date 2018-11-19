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
        	assertEquals(b.getVida(),tamanos[i]);
        }

	}
	@Test
	void test_hundirBarco() {
		Barco b = new Barco("Acorazado");
		//Barco no hundido
		b.restVida();
		assertFalse(b.getHundido());
		b.restVida();
		b.restVida();
		assertEquals(b.getVida(), 1);
		b.restVida();
		//Barco hundido
		assertTrue(b.getHundido());
		
		//Seguir restando vida a un barco hundido no debe ser posible
		
		b.restVida();
		b.restVida();
		assertEquals(b.getVida(), 0);
		
		
	}
}

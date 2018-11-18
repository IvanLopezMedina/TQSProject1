import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class TestBarco{
	Tablero t = new Tablero();
	int[][] m = t.getMatriz();

	@Test
	void test_InitBarco() {
        String[] listaNombres = {"Crucero" , "Portavion", "Acorazado"};
		Barco crucero = new Crucero(listaNombres[0]);
		Barco portavion = new Portavion(listaNombres[1]);
		Barco acorazado = new Acorazado(listaNombres[2]);

		assertEquals(crucero.getNombre(),"Crucero");
        assertEquals(portavion.getNombre(),"Portavion");
        assertEquals(acorazado.getNombre(),"Crucero");

	}
}

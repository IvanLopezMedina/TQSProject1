import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTablero {
	Tablero t = new Tablero();
	int[][] m = t.getMatriz();

	@Test
	void test_initTablero() {
		//Test inicialización valor vacio
		assertEquals(m[0][0],0);

	}
	
	@Test
	void test_insertTableroValido() {
	
		//Valors limit
		t.setValorCasilla(0, 8);
		assertEquals(m[0][8],1);
		t.setValorCasilla(0, 0);
		assertEquals(m[0][0],1);
		
		//Valors intra
		t.setValorCasilla(1, 7);
		assertEquals(m[1][7],1);
				
	}
	
	@Test
	void test_insertTableroInvalido() {
		//Valors incorrectos
		t.setValorCasilla(-1, 7);
		assertEquals(m[-1][7],1);
		
		t.setValorCasilla(1, 9);
		assertEquals(m[1][9],1);
		
	}

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTablero {
	Tablero t = new Tablero();
	int[][] m = t.getMatriz();

	@Test
	void test_initTablero() {
		//Test inicializacion valor vacio
		assertEquals(m[0][0],3);
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
	
	@Test
	void test_colocarBarcoVacioHorizontal() {
		Barco b1 = new Barco("Submarino");
		int x_inicial = 0;
		int y_inicial = 0;
		char orientacion = 'h';
			
		assertEquals(m[0][0], 3);
		assertEquals(m[1][0], 3);
		assertEquals(m[2][0], 3);
		
		
		t.setBarco(b1,x_inicial, y_inicial,orientacion);
		
		assertEquals(m[0][0], 4);
		assertEquals(m[1][0], 4);
		assertEquals(m[2][0], 4);
		assertEquals(m[3][0], 3);
		
	}

	@Test
	void test_colocarBarcoVacioVertical() {
		Barco b1 = new Barco("Submarino");
		int x_inicial = 0;
		int y_inicial = 0;
		char orientacion = 'v';
			
		assertEquals(m[0][0], 3);
		assertEquals(m[0][1], 3);
		assertEquals(m[0][2], 3);
		
		
		t.setBarco(b1,x_inicial, y_inicial,orientacion);
		
		assertEquals(m[0][0], 4);
		assertEquals(m[0][1], 4);
		assertEquals(m[0][2], 4);
		assertEquals(m[0][3], 3);
		
	}
	
	@Test
	void test_colocarBarcoOcupadoHorizontal() {
		
		Barco b1 = new Barco("Submarino");
		int x_inicial = 0;
		int y_inicial = 0;
		char orientacion = 'h';
	
		t.setBarco(b1,x_inicial, y_inicial,orientacion);
		
		Barco b2 = new Barco("Portaaviones");
		x_inicial = 0;
		y_inicial = 0;
		orientacion = 'h';
	
		t.setBarco(b2,x_inicial, y_inicial,orientacion);	
		
		assertEquals(m[0][0], 4);
		assertEquals(m[1][0], 4);
		assertEquals(m[2][0], 4);
		assertEquals(m[3][0], 3);
		assertEquals(m[4][0], 3);
		
	}
	
	@Test
	void test_colocarBarcoOcupadoVertical() {
		
		Barco b1 = new Barco("Submarino");
		int x_inicial = 0;
		int y_inicial = 0;
		char orientacion = 'v';
	
		t.setBarco(b1,x_inicial, y_inicial,orientacion);
		
		Barco b2 = new Barco("Portaaviones");
		x_inicial = 0;
		y_inicial = 0;
		orientacion = 'h';
	
		boolean status = t.setBarco(b2,x_inicial, y_inicial,orientacion);	
		
		assertEquals(m[0][0], 4);
		assertEquals(m[0][1], 4);
		assertEquals(m[0][2], 4);
		assertEquals(m[0][3], 3);
		assertEquals(m[0][4], 3);
		
		/**
		 * Status devolverá si se ha colocado el barco o se ha omitido por errores
		 */
		assertFalse(status);
		
	}
	
	@Test
	void test_colocarBarcoFueraHorizontal() {
		Barco b1 = new Barco("Submarino");
		int x_inicial = 6;
		int y_inicial = 0;
		char orientacion = 'h';
	
		boolean status = t.setBarco(b1,x_inicial, y_inicial,orientacion);
		
		assertFalse(status);
		
	}
	
	@Test
	void test_colocarBarcoFueraVertical() {
		
		
		
	}
	
	

}

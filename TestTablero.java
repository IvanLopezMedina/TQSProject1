import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

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
	void test_arrayListBarcos() {
		
		//Lista vacia
		
		//Buscar elemento no existente
		String nombre = "Submarino";
		
		for (Barco iter: t.getBarcos()) {
			if (iter.getNombre().matches(nombre)) {
				assertFalse(true);
			}
		}
		
		//Buscar elemento existente
		Barco b1 = new Barco(nombre);
		t.setBarcos(b1);
		for (Barco iter: t.getBarcos()) {
			if (iter.getNombre().matches(nombre)) {
				assertTrue(true);
			}
		}
		
		//Insertar valor erroneo
		Barco b2 = new Barco("Falso");
		System.out.println(b2.getNombre());
		t.setBarcos(b2);
		for (Barco iter: t.getBarcos()) {
			if (iter.getNombre().matches("Falso")) {
				assertFalse(true);
			}
		}
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
		try {
			t.setValorCasilla(-1, 7);
			assertEquals(m[-1][7],1);
			
			t.setValorCasilla(1, 9);
			assertEquals(m[1][9],1);
			
		}catch(ArrayIndexOutOfBoundsException exception) {
		    System.out.println("Fora de rang");
		}
	}
	
	@Test
	void test_colocarBarcoVacioHorizontal() {
		Barco b1 = new Barco("Submarino");
		int x_inicial = 0;
		int y_inicial = 0;
		char orientacion = 'h';
			
		assertEquals(m[0][0], 3);
		assertEquals(m[0][1], 3);
		assertEquals(m[0][2], 3);
		
		
		t.setBarco(b1,x_inicial, y_inicial,orientacion);
		
		assertEquals(m[0][0], 4);
		assertEquals(m[0][1], 4);
		assertEquals(m[0][2], 4);
		assertEquals(m[0][3], 3);
		
		Barco b2 = new Barco("Patrullero");
		x_inicial = 2;
		y_inicial = 2;
		orientacion = 'h';
			
		assertEquals(m[2][2], 3);
		assertEquals(m[3][2], 3);
		assertEquals(m[4][2], 3);
		
		
		t.setBarco(b2,x_inicial, y_inicial,orientacion);
		
		assertEquals(m[2][2], 4);
		assertEquals(m[2][3], 4);
		assertEquals(m[2][4], 3);
		assertEquals(m[2][1], 3);
		
	}

	@Test
	void test_colocarBarcoVacioVertical() {
		Barco b1 = new Barco("Submarino");
		int x_inicial = 0;
		int y_inicial = 0;
		char orientacion = 'v';
		
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
		assertEquals(m[0][1], 4);
		assertEquals(m[0][2], 4);
		assertEquals(m[0][3], 3);
		assertEquals(m[0][4], 3);
		
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
		assertEquals(m[1][0], 4);
		assertEquals(m[2][0], 4);
		assertEquals(m[3][0], 3);
		assertEquals(m[4][0], 3);
		
		/**
		 * Status devolverá si se ha colocado el barco o se ha omitido por errores
		 */
		assertFalse(status);
		
	}
	
	@Test
	void test_colocarBarcoFueraHorizontal() {
		Barco b1 = new Barco("Submarino");
		int x_inicial = 0;
		int y_inicial = 6;
		char orientacion = 'h';
	
		boolean status = t.setBarco(b1,x_inicial, y_inicial,orientacion);
		assertFalse(status);
		
	}
	
	@Test
	void test_colocarBarcoFueraVertical() {
		
		Barco b1 = new Barco("Portaaviones");
		int x_inicial = 6;
		int y_inicial = 6;
		char orientacion = 'v';
	
		boolean status = t.setBarco(b1,x_inicial, y_inicial,orientacion);
		assertFalse(status);
		
	}
	
	@Test
	void test_setearBarcoHundidoTablero() {
		Barco b1 = new Barco("Submarino");
		Jugador j = new Jugador("Ivan");
		int x_inicial = 0;
		int y_inicial = 0;
		char orientacion = 'h';

		t.setBarco(b1,x_inicial, y_inicial,orientacion);
		
		//Disparo al submarino 3 veces, por lo que al tercer disparo debería hundirse y dar estado 2 
		j.disparar(t, 0, 0);
		//Estado 1 en casilla 0,0 indica tocado
		assertEquals(m[0][0], 1);
		j.disparar(t, 0, 1);
		//Estado 1 en casilla 0,1 indica tocado
		assertEquals(m[0][1], 1);
		//Estado 2 en casilla 0,2 indica HUNDIDO
		j.disparar(t, 0, 2);
		//Todas las casillas del barco deberían de pasar del estado 2 al estado 1
		assertEquals(m[0][2], 2);
		assertEquals(m[0][1], 2);
		assertEquals(m[0][0], 2);
		
	}

	@Test
	//loop testing
	void test_loopGetBarco() {
		//test 0 loops
		Tablero tab = new Tablero();
		assertNull(t.getBarco(5,5));

		//test 1 loop
		Barco b = new Barco("Patrullero");
		t.setBarco(b,4,4,'h');
		assertEquals(t.getBarco(4,4), b);
		

	}
	

}

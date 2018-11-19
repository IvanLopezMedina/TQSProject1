import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JuegoTest {

	@Test
    public void test_pintarTablero() {
    	//Creamos una partida
    	Jugador j1 = new Jugador("Ivan");
        Tablero t = new Tablero();
        Juego j = new Juego();
        Barco acorazado = new Barco("Acorazado");
        t.setBarco(acorazado,0,0,'v');
        Barco submarino = new Barco("Submarino");
        t.setBarco(submarino,1,1,'v');
        Barco patrullero = new Barco("Patrullero");
        t.setBarco(patrullero,2,2,'h');
        Barco portaaviones = new Barco("Portaaviones");
        t.setBarco(portaaviones,3,3,'h');
        
        Teclado tec = new MockTecladoSimularPartida();
        j.setTeclado(tec);  
        int c = 0;
        boolean validator = false;
        
        while (c < 14) {
        	System.out.println("fila" + tec.getFila() + " col" + tec.getColumna());
        	j.entradaUsuario();
        	int value = j1.disparar(t, tec.getFila(),tec.getColumna());
        	if (value == 3 || value == 1) validator = true;
        	assertTrue(validator);
        	c++;
        }
       
        t.imprimirTablero();
      
        
    }

}

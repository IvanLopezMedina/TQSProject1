import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestJugador{

    @Test
    public void test_nombre() {
        String[] listanombres = {"Ivan" , "IA" };
        Jugador j1 = new Jugador(listanombres[0]);
        Jugador j2 = new Jugador(listanombres[1]);
        assertEquals(j1.getNombre(),"Ivan");
        assertEquals(j2.getNombre(),"IA");
    }

    @Test
    public void test_disparo(){
    	Jugador j1 = new Jugador("Ivan");
        Tablero t = new Tablero();
        Juego j = new Juego();
        
        //Mock Teclado
        Teclado tec = new MockTecladoDisparos();
        j.setTeclado(tec);
        int fila = 0, col = 0;
        
        
        //Creo patrullero en la casilla 0 0 y lo hundiré 0 0 y 0 1
    	Barco patrullero = new Barco("Patrullero");
    	t.setBarco(patrullero, 0,0, 'h');
 
    	//Pido entrada usuario, disparo en la 0, 0, está el patrullero y ha de darle y vida = 1
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());	
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 1);
    	
    	//Vuelvo a pedir entrada de usuario. Ahora debería fallar y dar agua y vida = 1
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(0, 0).getVida(), 1);
    	
    	//Vuelvo a pedir entrada de usuario. Ahora debería acertar y hundir el barco
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 0);
    	
    	System.out.println("new submarino");
    	
    	//Creo submarino en vertical y lo hundo 
    	Barco submarino = new Barco("Submarino");
    	t.setBarco(submarino, 5,5, 'v');
 
    	//Pido entrada usuario, disparo en la 7, 5, está el submarino y ha de darle y vida = 1
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());	
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 2);
    	
    	//Vuelvo a pedir entrada de usuario. Disparo en 6,5
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 1);
    	
    	//Vuelvo a pedir entrada de usuario. Disparo en 5,5. Ahora debería acertar y hundir el barco
    	j.entradaUsuario();
    	System.out.println(tec.getFila());
    	System.out.println(tec.getColumna());
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 0);
    	
    	//Ahora que el barco está hundido vuelvo a disparar en 7,5. Valor 2 = Hundido
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 0);
    	
    	//Disparo dos veces en la misma casilla con agua
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	
    	//Disparo fuera del tablero
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	
    	//Disparo negativo 
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	
    }
    
    @Test
    public void test_pintarTablero() {
    	Jugador j1 = new Jugador("Ivan");
        Tablero t = new Tablero();
        Juego j = new Juego();
        t.imprimirTablero();
        
    }




}

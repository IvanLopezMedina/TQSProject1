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
        MockTeclado tec = new MockTeclado();
        j.setTeclado(tec);
        int fila = 0, col = 0;
        
        
        //Creo patrullero en la casilla 0 0
    	Barco patrullero = new Barco("Patrullero");
    	t.setBarco(patrullero, 0,0, 'h');
    	
    	j.entradaUsuario(fila, col);
    	j1.disparar(t, fila, col);
    	//La vida ahora debería ser 1
    	assertEquals(t.getBarco(0, 0).getVida(), 1);
    	
    	//Vuelvo a pedir entrada de usuario. Ahora debería fallar y dar agua y vida = 1
    	j.entradaUsuario(fila, col);
    	j1.disparar(t, fila, col);
    	assertEquals(t.getBarco(0, 0).getVida(), 1);
    	//Vuelvo a pedir entrada de usuario. Ahora debería acertar y hundir el barco
    	j.entradaUsuario(fila, col);
    	j1.disparar(t, fila, col);
    	assertEquals(t.getBarco(0, 0).getVida(), 0);
    	
    	
    	
    	
    	
    	
    	/*
    	Barco submarino = new Barco("Submarino");
        Barco acorazado = new Barco("Acorazado");
        Barco portavion = new Barco("Portaaviones");
        
        
        t.setBarco(acorazado, 1, 0, 'h');
        t.setBarco(portavion, 2, 0, 'h');
        
        
        
        System.out.println("Fila: " + tec.getFila());
        System.out.println("Columna: " + tec.getColumna());
        
        System.out.println("Fila: " + tec.getFila());
        System.out.println("Columna: " + tec.getColumna());
        
        assertEquals(1,1);
        */
        
        /*
        
        int disparo = 0;
        

        //Test true para los disparos TOCADO
        disparo = j1.disparar(t, 0,0);
        assertEquals(1,disparo);
        disparo = j1.disparar(t, 1,0);
        assertEquals(1,disparo);
        disparo = j1.disparar(t, 2,0);
        assertEquals(1,disparo);

        //Test false para los disparos AGUA
        disparo = j1.disparar(t, 3,0);
        assertEquals(1,disparo);
        disparo = j1.disparar(t, 4,0);
        assertEquals(1,disparo);
        disparo = j1.disparar(t, 5,0);
        assertEquals(1,disparo);

        //Test true para los disparos FUERA TABLERO
        disparo = j1.disparar(t, -1,-1);
        assertEquals(2,disparo);
        disparo = j1.disparar(t, -4,10);
        assertEquals(2,disparo);
        disparo = j1.disparar(t, -3,11);
        assertEquals(2,disparo);*/

    }




}

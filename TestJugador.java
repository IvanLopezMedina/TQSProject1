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
 
    	//Pido entrada usuario, disparo en la 7, 5, está el patrullero y ha de darle y vida = 1
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());	
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 2);
    	
    	//Vuelvo a pedir entrada de usuario. Disparo en 7,6
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(5, 5).getVida(), 1);
    	
    	//Vuelvo a pedir entrada de usuario. Disparo en 7,5. Ahora debería acertar y hundir el barco
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 0);
    	
    	//Ahora que el barco está hundido vuelvo a disparar en 7,5. Valor 2 = Hundido
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	assertEquals(t.getBarco(tec.getFila(), tec.getColumna()).getVida(), 0);
    	
    	//Disparo dos veces en la misma casilla con agua
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	
    	//Disparo fuera del tablero
    	j.entradaUsuario();
    	j1.disparar(t, tec.getFila(), tec.getColumna());
    	
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

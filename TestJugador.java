import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class TestJugador{

    @Test
    public void test_nombre() {
        String[] listanombres = {"Ivan" , "IA" };
        Jugador j1 = new Jugador(listanombres[0]);
        Jugador j2 = new Jugador(listanombres[1]);
        assertEquals(j1.getNombre(),"Ivan");
        assertEquals(j2.getNombre(),"IA");
    }

    public void test_disparo(){
        Jugador j1 = new Jugador("Ivan");
        Tablero t = new Tablero();
        Barco crucero = new Crucero("Crucero");
        Barco acorazado = new Acorazado("Acorazado");
        Barco portavion = new Portavion("Portavion");
        int disparo = 0;
        t.setBarco(crucero, 0,0, 'h');
        t.setBarco(acorazado, 1, 0, 'h');
        t.setBarco(portavion, 2, 0, 'h');

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
        assertEquals(2,disparo);

    }




}

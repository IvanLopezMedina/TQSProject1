package HundirFlota;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    @Test
    void testMatriz(){

        Tablero tablero = new Tablero();
        boolean res = tablero.MatrizLength(5);
        assertTrue(res);
        boolean reslimit9 = tablero.MatrizLength(4.9);
        assertFalse(reslimit9);
        boolean reslimit1 = tablero.MatrizLength(5.1);
        assertFalse(reslimit1);

    }
}

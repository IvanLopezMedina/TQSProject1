package HundirFlota;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    @Test
    void testMatriz(){

        Tablero tablero = new Tablero();
        boolean res = tablero.MatrizSize(5);
        assertTrue(res);
        boolean reslimit9 = tablero.MatrizSize(4.9);
        assertFalse(reslimit9);
        boolean reslimit1 = tablero.MatrizSize(5.1);
        assertFalse(reslimit1);

    }
}

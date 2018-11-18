import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class TestJugador{

    @Test
    void test_nombre() {
        String[] listanombres = {"Ivan" , "Maquina" };
        Jugador j1 = new Jugador(listanombres[0]);
        Jugador j2 = new Jugador(listanombres[1]);
        assertEquals(j1.getNombre(),"Ivan");
        assertEquals(j2.getNombre(),"Maquina");
    }

}

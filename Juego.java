import java.util.Scanner;

public class Juego {
    public static void main(String[] args)
    {
        int x;
        int y;
        System.out.println("Hundir la flota");
        Tablero tab = new Tablero();
        Jugador j1 = new Jugador("Ivan");
        Barco acorazado = new Acorazado("Acorazado");
        tab.setBarco(acorazado,2,4,'h');
        Scanner sc = new Scanner(System.in);
        //x = j1.pideFila(sc);
        //y = j1.pideColumna(sc);
        //System.out.println(j1.disparar(tab,x,y));

        tab.imprimirTablero(tab);
        //System.out.println(tab.MatrizSize());


    }


}

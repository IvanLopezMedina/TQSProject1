import java.util.*;

public class Jugador {

    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int pideFila(Scanner sc){
        System.out.println("Introduce la fila");
        return sc.nextInt();
    }

    public int pideColumna(Scanner sc){
        System.out.println("Introduce la columna");
        return sc.nextInt();
    }

    public int disparar(Tablero t, int x, int y){
        return 0;
    }

}

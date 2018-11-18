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
        int ret = 0;
        int matriz [][] = t.getMatriz();
        if (matriz[x][y] == 4){
            ret = 1;
        }else{
            ret = 0;
        }
        return ret;
    }

}

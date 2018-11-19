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
        if(x>=0 && x<=9 && y>=0 && y<=9) {
            int ret = 0;
            int matriz[][] = t.getMatriz();
            if (matriz[x][y] == 4) {
                System.out.println("Tocado");
                matriz[x][y] = 1;
                ret = 1;
            } else {
                System.out.println("Agua");
                matriz[x][y] = 0;
                ret = 0;
            }
            return ret;//Valor para el test
        }else{
            System.out.println("Fuera de rango");
            return 2; //Valor para el test
        }
    }

    public int disparoIA(Tablero t){
        int ret = 0;
        int matriz [][] = t.getMatriz();
        int x = (int)Math.random()*10;
        int y = (int)Math.random()*10;
        if (matriz[x][y] == 4) {
            System.out.println("Tocado");
            matriz[x][y] = 1;
            ret = 1;
        } else {
            System.out.println("Agua");
            matriz[x][y] = 0;
            ret = 0;
        }
        return ret;//Valor para el test

    }

}

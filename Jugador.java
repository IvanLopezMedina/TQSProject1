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
        if(x>=0 && x<9 && y>=0 && y<9) {
            Barco barco = t.getBarco(x, y); //Me guardo el barco que esta en esa posicion disparada

            int ret = 0;
            int matriz[][] = t.getMatriz();
            System.out.println("Valor" + matriz[x][y]);
            if (matriz[x][y] == 4) {
                barco.restVida(); //restamos la vida del barco
                if(barco.getHundido()){
                    System.out.println("BARCO HUNDIDO");
                    matriz[x][y] = 2;
                    ret = 3; //Valor para los test
                }else {
                    System.out.println("Tocado");
                    matriz[x][y] = 1;
                    ret = 1;
                }
            } else {
            		
            		if ( matriz[x][y] != 3 || matriz[x][y] != 4 ) {
            			System.out.println("Casella ja seleccionada");
            			ret = matriz[x][y];
            		}else {
            			matriz[x][y] = 0;
                        ret = 0;
            		}
                
                
            }
            return ret;//Valor para el test
        }else{
            System.out.println("Fuera de rango");
            return 2; //Valor para el test
        }
    }
    public boolean comprobarHundido(Barco b){
        int vida = b.getVida();
        if (vida <= 0){
            return true;
        }else{
            return false;
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

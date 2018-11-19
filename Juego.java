import java.util.Scanner;

public class Juego {
	MockTeclado tec;
	
	public void setTeclado(MockTeclado t) {
    	this.tec= t;
    }
	
	public void entradaUsuario(int fila, int col) {
			tec.filaCol(fila, col);
			System.out.println(tec.getFila());
			System.out.println(tec.getColumna());
	}
	
	
    public static void main(String[] args){
        int x;
        int y;
        
        System.out.println("Hundir la flota");
        Tablero tab = new Tablero();
        Jugador j1 = new Jugador("Ivan");
        Barco acorazado = new Barco("Acorazado");
        tab.setBarco(acorazado,0,0,'v');
        while(true) {
            Scanner sc = new Scanner(System.in);
            x = j1.pideFila(sc);
            y = j1.pideColumna(sc);
            System.out.println(j1.disparar(tab, x, y));
            //System.out.println(j1.disparoIA(tab));
            tab.imprimirTablero(tab);
        }
        //System.out.println(tab.MatrizSize());


    }


}

import java.util.Scanner;

public class Juego {
	Teclado tec;
	
	public void setTeclado(Teclado t) {
    	this.tec= t;
    }
	
	public void entradaUsuario() {
			tec.filaCol();
	}
	
	public void terminarPartida() {
		
	}
	
	
    public static void main(String[] args){
        int x;
        int y;
        
        System.out.println("Hundir la flota");
        Tablero tab = new Tablero();
        Jugador j1 = new Jugador("Ivan");
        //Barco acorazado = new Barco("Acorazado");
        tab.insertarBarcosAleatorios();
        //tab.setBarco(acorazado,0,0,'v');
        tab.imprimirTablero();
        
        int ganar = tab.getTotalBarcos();
        while(ganar > 0) {
            Scanner sc = new Scanner(System.in);
            x = j1.pideFila(sc);
            y = j1.pideColumna(sc);
            System.out.println(j1.disparar(tab, x, y));
            //System.out.println(j1.disparoIA(tab));
            tab.imprimirTablero();
            ganar = tab.getTotalBarcos();
        }
        
        if (ganar == 0) {
        	System.out.println("Has ganado!!");
        }

    }


}

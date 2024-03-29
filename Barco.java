public class Barco {
	protected String nombre;
	protected int tamano;
	int[] posicion = new int[2];
	protected int vida;
	protected int[] horizontal = new int[4];
	protected int[] vertical = new int[4];
	protected char orientacion;
	protected boolean hundido;

    public Barco(String nombre) {
        this.nombre = nombre;
        setTamano();
        this.vida = getTamano();
        this.horizontal =  new int[tamano];
        this.vertical =  new int[tamano];
        this.hundido = false;
    }

    public void setOrientacion(char orientacion){
        this.orientacion = orientacion;
    }
    
    public boolean getHundido() {
    	setHundido();
    	return this.hundido;
    }
    
    public void setHundido() {
    	if (vida == 0) {
    		this.hundido = true;
    	}
    }

    public char getOrientacion(){
        return this.orientacion;
    }

    public String getNombre() {
        return this.nombre;
    }
	public void restVida(){
		if (vida == 0) {
			
		}else {
			this.vida --;
			getHundido();
		}
	    
    }

	public int getVida(){
	    return this.vida;
    }
	
	public int getTamano() {
		return this.tamano;
	}
	
	public void setTamano() {
		if (nombre == "Patrullero") {
			tamano = 2;
		}
		
		if (nombre == "Submarino") {
			tamano = 3;
		}
		
		if (nombre == "Acorazado") {
			tamano = 4;
		}
		
		if (nombre == "Portaaviones") {
			tamano = 5;
		}
	}
    public int[] setPosicionBarco(int x, int y){
        posicion[0] = x;
        posicion[1] = y;
        return posicion;
    }

    public int[] getPosicionBarco(){
        return this.posicion;
    }


	public int[] setPosicionVerticalBarco(int i, int x){
	    vertical[i] = x;
	    return vertical;
    }

    public int[] getPosicionVerticalBarco(){
	    return this.vertical;
    }

    public int[] setPosicionHorizontalBarco(int i, int y){
        horizontal[i] = y;
        return horizontal;
    }

    public int[] getPosicionHorizontalBarco(){
        return this.horizontal;
    }

}

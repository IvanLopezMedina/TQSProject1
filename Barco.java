public abstract class Barco {
	protected String nombre;
	int tamano;
	int[] posicion = new int[2];
	int vida = 4;
	int[] horizontal = new int[4];
	int[] vertical = new int[4];
	char orientacion;

    public void Barco(String nombre) {
        this.nombre = nombre;
    }

    public void setOrientacion(char orientacion){
        this.orientacion = orientacion;
    }

    public char getOrientacion(){
        return this.orientacion;
    }

    public String getNombre() {
        return this.nombre;
    }
	public void restVida(){
	    this.vida -= 1;
    }

	public int getVida(){
	    return this.vida;
    }

	public void setNombre(String nombre){
	    this.nombre = nombre;
	}
	
	public int getTamano() {
		return this.tamano;
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

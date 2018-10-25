public class Barco {
	String nombre;
	int tamano;
	
	public Barco(String nombre) {
		this.nombre = nombre;
		this.tamano = 3;	
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTamano() {
		return this.tamano;
	}
}

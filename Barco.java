public class Barco {
	String nombre;
	int tamaño;
	
	public Barco(String nombre) {
		this.nombre = nombre;
		this.tamaño = 0;	
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTamaño() {
		return this.tamaño;
	}
}

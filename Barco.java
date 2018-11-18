public class Barco {
	String nombre;
	int tamano;
	
	public Barco(String nombre) {
		this.nombre = nombre;
		setTamano();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTamano() {
		return this.tamano;
	}
	
	private void setTamano() {
		
		
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
}

public abstract class Barco {
	protected String nombre;
	int tamano;
	
	public void Barco(String nombre) {
		this.nombre = nombre;
		this.tamano = 3;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre){
	    this.nombre = nombre;
	}
	
	public int getTamano() {
		return this.tamano;
	}
}

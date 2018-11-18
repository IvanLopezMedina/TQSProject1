public abstract class Barco {
	protected String nombre;
	int tamano;
	
	public void Barco(String nombre) {
		this.nombre = nombre;
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

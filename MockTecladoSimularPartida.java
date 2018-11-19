public class MockTecladoSimularPartida implements Teclado{
	
	int[] valorFila = {0,1,2,3,1,2,3,2,2,3,3,3,3,3};
	int[] valorCol =  {0,0,0,0,1,1,1,2,3,3,4,5,6,7};
	int i = 0;
	int j = 0;
	public int f;
	public int c;
	
	public int getFila() {
		return this.f;
	}
	
	public int getColumna() {
		return this.c;
	}
	
	public void filaCol() {	
		f = valorFila[i];
		c= valorCol[i];
		i++;
	}
}
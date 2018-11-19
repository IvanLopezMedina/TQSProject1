public class MockTecladoDisparos implements Teclado{
	
	int[] valorFila = {0,1,0,7,6,5,8,8,10,-1,0,-1,-1,0,10,10};
	 int[] valorCol = {0,0,1,5,5,5,8,8,10,-1,-1,0,10,10,-1,0};
	int i = 0;
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
		c = valorCol[i];
		i++;
	}
}



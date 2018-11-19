public class MockTeclado {
	
	int[] valorFila = {0,1,0};
	int[] valorCol = {0,0,1};
	int i = 0;
	public int f;
	public int c;

	public MockTeclado() {
		
	}
	
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



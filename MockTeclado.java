public class MockTeclado {
	
	int[] valorFila = {0,1,1};
	int[] valorCol = {0,1,0};
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
	
	public void filaCol(int fila, int col) {
		f = valorFila[i];
		c = valorCol[i];
		i++;
	}
	
	/*public class MockTeclado extends Teclado {
		int[] valorFila = {0,1};
		int[] valorCol = {0,1};
		int i = 0;
		
		public void filaCol(int f, int c) {
			f = valorFila[i];
			c = valorCol[i];
			i++;
		}
	}*/
	
}



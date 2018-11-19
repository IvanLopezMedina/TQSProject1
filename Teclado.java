public class Teclado {

	public Teclado() {
		
	}
	
	public void filaCol(int f, int c) {
		
	}
	
	public class MockTecladoDisparos extends Teclado {
		int[] valorFila = {0,1};
		int[] valorCol = {0,1};
		int i = 0;
		
		public void filaCol(int f, int c) {
			f = valorFila[i];
			c = valorCol[i];
			i++;
		}
	}
	
}



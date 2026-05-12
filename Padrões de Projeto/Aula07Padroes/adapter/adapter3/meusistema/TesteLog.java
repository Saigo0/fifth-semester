package meusistema;

public class TesteLog {

	public TesteLog(/*guardar a instancia do adaptador*/) {
		
			
	}
	
	public void imprimir(String texto) {
		/*executar a instancia do adaptador*/
	}

	public static void main(String[] args) {
		
		TesteLog teste1 = new TesteLog(/*passar uma instancia do adaptador de objeto do logtext*/);
		teste1.imprimir("123");
		
		TesteLog teste2 = new TesteLog(/*passar uma instancia do adaptador de classe do logtext*/);
		teste2.imprimir("123");

		TesteLog teste3 = new TesteLog(/*passar uma instancia do adaptador de objeto do winlog*/);
		teste3.imprimir("123");
		
		TesteLog teste4 = new TesteLog(/*passar uma instancia do adaptador de objeto do winlog*/);
		teste4.imprimir("123");
		
	}

}

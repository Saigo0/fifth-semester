package lsp03;

public class LivroDigital{

	private Livro livro;
	private int downloadsRealizados = 0;
    
	public LivroDigital(String titulo, String autor) {
		livro = new Livro(titulo, autor);
	}

	public void emprestar() {
		downloadsRealizados++;
	}
	
	public int getDownloadsRealizados() {
		return downloadsRealizados;
	}
	
	// essa classe tem um metodo devolver sem sentido
	// Leaky Abstraction 

	
}

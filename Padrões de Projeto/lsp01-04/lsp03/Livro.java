package lsp03;

public class Livro {
	private String titulo;
	private String autor;
	private boolean emprestado;
    
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }
    
    public void emprestar() {
        if (emprestado) {
            throw new IllegalStateException("Livro j\u00E1 emprestado");
        }
        emprestado = true;
    }
    
    public void devolver() {
        if (!emprestado) {
            throw new IllegalStateException("Livro n\u00E3o estava emprestado");
        }
        emprestado = false;
    }
    
    public String getAutor() {
		return autor;
	}
    
    public String getTitulo() {
		return titulo;
	}
}

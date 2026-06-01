package lsp03;

public class Biblioteca {

	public static void main(String[] args) {
		Livro l1 = new Livro("Dom Casmurro", "Machado de Assis");
		LivroDigital l2 = new LivroDigital("O Morro dos Ventos Uivantes", "Emily Bronte");
		
		l1.emprestar();
		l2.emprestar();
		l2.emprestar();
		
	}

}
